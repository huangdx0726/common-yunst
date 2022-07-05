package com.yunst.request.paymethod.in;

import com.yunst.enums.IdentityType;
import com.yunst.enums.LimitPay;
import com.yunst.request.BasePayMethod;
import lombok.*;

/**
 * 收银宝微信小程序支付
 * @author dudangman
 */
public class WeChatPayMiniProgram extends BasePayMethod {

    private static final String KEY = "WECHATPAY_MINIPROGRAM";

    public WeChatPayMiniProgram(WechatPayMiniProgramRequest payMethodRequest) {
        super(payMethodRequest);
    }

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public String getSimpleName() {
        return null;
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public abstract static class BaseWechatPayMiniProgramRequest extends BasePayMethodRequest {

        /**
         * 非贷记卡：no_credit
         * 借、贷记卡：””需要传空字符串， 不能不传
         */
        public LimitPay limitPay;

        /**
         * 微信小程序支付 appid 参数
         * 当商户有多个小程序或公众号时接口指定上送
         */
        public String subAppid;

        /**
         * 支付金额，单位：分
         */
        public Long amount;

        /**
         * 渠道拓展参数，最长 1000 字符
         */
        public String extendParams;

        /**
         * 微信小程序支付 openid——微信分配
         */
        public String acct;

        /**
         * 订单支付标识，订单优惠标记，用于区分订单是否可以享受优惠,字段内容在微信后台配置券时进行设
         * 置，只对微信支付有效
         */
        public String goods_tag;

        /**
         * 优惠信息，benefitdetail 的 json 字符串,注意是 String，微信单品优
         * 惠
         */
        public String benefitdetail;

        /**
         * 渠道门店号--商户在支付渠道端的
         * 门店编号
         */
        public String chnlstoreid;

        /**
         * 门店号
         */
        public String subbranch;

        /**
         * 证件号
         */
        public String idNo;

        /**
         * 付款人姓名
         */
        public String name;

        /**
         * 证件类型
         * 仅支持“1-身份证”
         */
        public IdentityType certType;
    }

    @NoArgsConstructor
    public static class WechatPayMiniProgramRequest extends BaseWechatPayMiniProgramRequest {
        @Builder
        public WechatPayMiniProgramRequest(LimitPay limitPay, String subAppid, Long amount, String extendParams, String acct, String goods_tag, String benefitdetail, String chnlstoreid, String subbranch, String idNo, String name, IdentityType certType) {
            super(limitPay, subAppid, amount, extendParams, acct, goods_tag, benefitdetail, chnlstoreid, subbranch, idNo, name, certType);
        }
    }
}
