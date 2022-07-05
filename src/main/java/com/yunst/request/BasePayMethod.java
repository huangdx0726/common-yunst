package com.yunst.request;

import cn.hutool.core.util.StrUtil;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * @author dudangman
 */
public abstract class BasePayMethod {
    public String getKey(){
        return StrUtil.toUnderlineCase(this.getSimpleName()).toUpperCase(Locale.ROOT);
    }

    /**
     * 返回子类名称
     * 子类名称需按支付方式key严格驼峰命名
     * @return 子类到getSimpleName
     */
    public abstract String getSimpleName();
    public BasePayMethodRequest getPayMethodRequest(){
        return this.payMethodRequest;
    }
    private final BasePayMethodRequest payMethodRequest;
    public BasePayMethod(BasePayMethodRequest payMethodRequest) {
       this.payMethodRequest = payMethodRequest;
    }

    /**
     * 支付方式jsonobj
     */
    public abstract static class BasePayMethodRequest {

    }
}
