package com.yunst.request.paymethod.in;

import com.yunst.enums.LimitPay;
import com.yunst.request.BasePayMethod;
import lombok.*;

/**
 * 收银宝付款码支付—— 支持微信、支付宝、银联、手机QQ
 * @author dudangman
 */
public class CodepayVsp extends BasePayMethod {
    public CodepayVsp(CodePayVspRequest payMethodRequest) {
        super(payMethodRequest);
    }

    @Override
    public String getSimpleName() {
        return this.getClass().getSimpleName();
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public abstract static class BaseCodePayVspRequest extends BasePayMethodRequest {
        /**
         * 支付金额,单位：分
         */
        public Long amount;

        /**
         * 渠道拓展参数，最长 1000 字符
         */
        public String extendParams;

        /**
         * 用户的付款二维码
         * *不支持数字货币付款码
         */
        public String authcode;

        /**
         * 非贷记卡：no_credit
         * 借、贷记卡：””，需要传空字符串，不能不传
         */
        public LimitPay limitPay;

        /**
         * 订单支付标识，订单优惠标记，用于区分订单是否可以享受优惠,字段内容在微信后台配置券时进行设
         * 置，只对微信支付有效
         */
        public String goods_tag;

        /**
         * 优惠信息，benefitdetail 的 json
         * 字符串,注意是 String，微信单品优惠
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
    }

    @NoArgsConstructor
    public static class CodePayVspRequest extends BaseCodePayVspRequest {
        @Builder
        public CodePayVspRequest(Long amount, String extendParams, String authcode, LimitPay limitPay, String goods_tag, String benefitdetail, String chnlstoreid, String subbranch) {
            super(amount, extendParams, authcode, limitPay, goods_tag, benefitdetail, chnlstoreid, subbranch);
        }
    }
}
