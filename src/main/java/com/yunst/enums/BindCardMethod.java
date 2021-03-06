package com.yunst.enums;

import com.yunst.annotation.EnumValue;

/**
 * 绑卡方式
 * @author dudangman
 */
public enum BindCardMethod {
    /**
     * 通联通账户实名验证
     * (三要素)
     * 无需调用【确认绑定银行卡】，不支持贷记卡
     */
    M1(1),
    /**
     * 通联通实名付
     * 需调【确认绑定银行卡】完成绑卡。不支持绑贷记卡测试环境下绑卡时，短信验证码为 11111。
     * 测试环境手机号 13616515002
     */
    M3(3),
    /**
     * 通联通账户实名验证
     * (四要素)
     * 无需调用【确认绑定银行卡】，不支持贷记卡
     * 账户名：云商通
     * 卡号：6228481234567898346
     * 手机号：18019823456
     * 身份证：310226123456745676
     * 银行代码：01030000
     */
    M5(5),
    /**
     * 通联通协议支付签约 ——支持通联通协议支付
     *
     * 需调【确认绑定银行卡】完成绑卡。支持绑借记和贷记卡；
     * 测试环境下绑卡要求： 证件：身份证
     * 手机号：11 位
     * 短信验证码：111111
     * 验证码有效时间：10 分钟
     * 卡号：符合卡 BIN 规则
     * 卡号 00 结尾模拟为贷记卡，为贷记卡时有效期和 CVV 至少输入一个
     * 卡号 01 结尾模拟为手机号不一致
     * 卡号 02 结尾模拟为身份证不一致
     * 卡号 03 结尾模拟为卡号异常
     * 卡号 04 结尾模拟为账号户名不一致
     * 其余情况为模拟成功。
     */
    M6(6),
    /**
     * 收银宝快捷支付签约（有银行范围） ——支持收银宝快捷支付
     *
     * 需调【确认绑定银行卡】完成绑卡。支持绑借记和贷记卡； 测试环境下使用真实银行卡进行绑卡
     */
    M7(7),
    /**
     * 银行卡四要素验证（万鉴通，全部银行）
     *
     * 无需调用【确认绑定银行卡】，支持绑借记和贷记卡；
     * 测试环境请使用以下信息：
     * 银行卡号：6228480402637874214（农业银行） 姓名：王小二
     * 身份证号：610422198600000000
     */
    M8(8),
    /**
     * 后台绑定银行卡
     */
    M99(99)
    ;

    final Integer code;

    BindCardMethod(Integer code) {
        this.code = code;
    }

    @EnumValue
    public Integer getCode() {
        return code;
    }
}
