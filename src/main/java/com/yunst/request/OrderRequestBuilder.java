package com.yunst.request;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.allinpay.yunst.sdk.bean.YunRequest;
import com.yunst.constant.YunstConstants;
import com.yunst.utils.RsaUtils;
import com.yunst.utils.YunstRequestUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author dudangman
 */
@Slf4j
public class OrderRequestBuilder {

    private final YunRequest request;

    private OrderRequestBuilder(String methodName) {
        this.request = new YunRequest(YunstConstants.OrderService.SERVICE_NAME, methodName);
    }

    public static OrderRequestBuilder builder(String methodName) {
        return new OrderRequestBuilder(methodName);
    }

    public YunRequest build() {
        return this.request;
    }

    public OrderRequestBuilder recieverList(List<Reciever> recieverList) {
        this.request.put("recieverList", JSONUtil.parseArray(recieverList));
        return this;
    }

    public OrderRequestBuilder payMethod(BasePayMethod basePayMethod) {
        if (ObjectUtils.isEmpty(basePayMethod)) {
            return this;
        }
        JSONObject jsonObject = new JSONObject();
        doPayMethod(basePayMethod, jsonObject);
        this.request.put("payMethod", jsonObject);
        return this;
    }

    public OrderRequestBuilder payMethods(List<BasePayMethod> payMethods) {
        if (ObjectUtils.isEmpty(payMethods)) {
            return this;
        }
        JSONObject jsonObject = new JSONObject();
        payMethods.forEach(basePayMethod -> doPayMethod(basePayMethod, jsonObject));
        this.request.put("payMethod", jsonObject);
        return this;
    }

    private void doPayMethod(BasePayMethod basePayMethod, JSONObject jsonObject) {
        // 处理加密
        RsaUtils.encrypt(basePayMethod);
        BasePayMethod.BasePayMethodRequest payMethodRequest = basePayMethod.getPayMethodRequest();
        JSONObject payMethod = JSONUtil.parseObj(JSON.toJSONString(payMethodRequest));
        Field[] fields = payMethodRequest.getClass().getFields();
        // 处理枚举值
        doEnumValues(fields, payMethodRequest, payMethod);
        fields = payMethodRequest.getClass().getDeclaredFields();
        doEnumValues(fields, payMethodRequest, payMethod);
        Object exist = jsonObject.get(basePayMethod.getKey());
        if (exist == null) {
            jsonObject.putOnce(basePayMethod.getKey(), payMethod);
            return;
        }
        // key 重复生成jsonarray 数组
        if (exist instanceof JSONArray) {
            ((JSONArray)exist).add(payMethod);
        } else if (exist instanceof JSONObject) {
            JSONArray array = JSONUtil.createArray();
            array.add(payMethod);
            array.add(exist);
            exist = array;
        }
        jsonObject.putOpt(basePayMethod.getKey(), exist);
    }

    private void doEnumValues(Field[] fields, Object object, JSONObject payMethod) {
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(object);
                field.setAccessible(false);
                if (ObjectUtils.isEmpty(value) || !value.getClass().isEnum()) {
                    continue;
                }
                payMethod.putOpt(field.getName(), YunstRequestUtils.getEnumValue(value));
            }
        } catch (IllegalAccessException e) {
            log.error("处理枚举异常:",e);
        }
    }

    /**
     * 根据字段属性字段构建request对象
     * @param orderRequest request
     * @return YunRequest
     */
    public YunRequest autoBuild(OrderRequest orderRequest) {
        return YunstRequestUtils.buildYunRequest(this.request, orderRequest, Boolean.TRUE);
    }
}
