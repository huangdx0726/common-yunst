package com.yunst.enums;

import com.yunst.annotation.EnumValue;

/**
 * @author dudangman
 */
public enum AcctType {
    /**
     * 微信公众号
     */
    WECHAT_PUBLIC("weChatPublic"),
    /**
     * 微信小程序
     */
    WECHAT_MINI_PROGRAM("weChatMiniProgram"),
    /**
     * 支付宝生活号
     */
    ALIPAY_SERVICE("aliPayService"),
    /**
     * 银联 JS
     */
    UNION_PAY_JS("unionPayjs"),
    /**
     * 其他
     */
    OTHER("other")
    ;
    final String name;
    AcctType(String name) {
        this.name = name;
    }

    @EnumValue
    public String getName() {
        return name;
    }
}
