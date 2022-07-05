package com.yunst.utils;

import cn.hutool.core.exceptions.UtilException;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.ClassScanner;
import cn.hutool.json.JSONUtil;
import com.allinpay.yunst.sdk.YunClient;
import com.allinpay.yunst.sdk.bean.YunRequest;
import com.yunst.annotation.EncryptRsa;
import com.yunst.annotation.EnumValue;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 通联请求参数工具
 * @author dudangman
 */
@Slf4j
public class YunstRequestUtils {
    private final static Map<Class<?>, String> ENUM_METHOD;
    private final static String ENUM_PACKAGE = "com.yunst.enums";
    private final static String ERR_MESSAGE_FORMAT = "[%s]方法的参数不能为空！";
    static {
        ENUM_METHOD = new HashMap<>();
        Set<Class<?>> classes = ClassScanner.scanPackage(ENUM_PACKAGE);
        classes.stream()
                .filter(Class::isEnum)
                .forEach(cls -> {
                    String getMethodName = Arrays.stream(cls.getDeclaredMethods())
                            .filter(method -> method.getAnnotation(EnumValue.class) != null)
                            .map(Method::getName)
                            .findFirst().orElse(null);
                    ENUM_METHOD.put(cls, getMethodName);
                });
    }
    /**
     * 构建通联请求参数忽略对象中的null值
     * 属性名需与通联入参一致
     * @param request request
     * @param object obj
     */
    public static YunRequest buildYunRequest(YunRequest request, Object object, Boolean ignoreNull) {
        Assert.notNull(request, "YunRequest对象不能为空！");
        Assert.notNull(object, "object 不能为空！");
        Field[] fields = object.getClass().getDeclaredFields();
        doValue(request, fields, object, ignoreNull);
        fields = object.getClass().getFields();
        doValue(request, fields, object, ignoreNull);
        return request;
    }

    private static void doValue (YunRequest request, Field[] fields, Object object, Boolean ignoreNull) {
        if (fields == null || fields.length == 0){
            return;
        }
        try {
            for (Field field : fields) {
                // 不覆盖自己处理过的值
                if (!ObjectUtils.isEmpty(request.get(field.getName()))) {
                    continue;
                }
                field.setAccessible(true);
                Object value = field.get(object);
                if (ignoreNull && ObjectUtils.isEmpty(value)) {
                    continue;
                }
                // 处理枚举类型
                value = getEnumValue(value);
                EncryptRsa encrypt = field.getAnnotation(EncryptRsa.class);
                if (encrypt != null) {
                    value = YunClient.encrypt((String) value);
                }
                request.put(field.getName(), value);
                field.setAccessible(false);
            }
        } catch (Exception ex) {
            throw new UtilException("构建通联请求参数异常");
        }
    }

    /**
     * 请求通联接口
     * @param request request
     * @param tClass class
     * @param <T> t
     * @return T
     * @throws Exception 接口异常
     */
    public static <T> T request(YunRequest request, Class<T> tClass) throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("请求通联接口参数:{}",request);
        }
        T result = JSONUtil.toBean(YunClient.request(request), tClass);
        if (log.isDebugEnabled()) {
            log.debug("通联接口返回值:{}", request);
        }
        return result;
    }

    /**
     * 检查参数
     * @param params params
     */
    public static void checkParam(Object... params) {
        if (params == null) {
            return;
        }
        for (Object param : params) {
            Assert.notNull(param, param + "不允许为空！");
        }
    }

    public static void checkMethodParam(String methodName, Object param) {
        Assert.notNull(param, String.format(ERR_MESSAGE_FORMAT, methodName));
    }

    /**
     * 枚举取值方法
     * @param object obj
     * @return Object
     */
    public static Object getEnumValue(Object object) {
        Class<?> cls = object.getClass();
        if (ENUM_METHOD.get(cls) == null) {
            return object;
        }
        try {
            Method method = cls.getMethod(ENUM_METHOD.get(cls));
            return method.invoke(object);
        } catch (Exception ex) {
           log.error("转化枚举值异常:",ex);
           return object;
        }
    }
}
