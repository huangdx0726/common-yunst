package com.yunst.request.paymethod.in;

import com.yunst.enums.LimitPay;
import com.yunst.request.BasePayMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 收银宝银联JS 支付
 * @author dudangman
 */
public class UnionpayJs extends BasePayMethod {
    public UnionpayJs(UnionPayJsRequest payMethodRequest) {
        super(payMethodRequest);
    }

    @Override
    public String getSimpleName() {
        return this.getClass().getSimpleName();
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @AllArgsConstructor
    public abstract static class BaseUnionPayJsRequest extends BasePayMethodRequest {
        /**
         * 支付金额
         * 单位：分
         */
        public Long amount;

        /**
         * 渠道拓展参数，最长 1000 字符
         */
        public String extendParams;

        /**
         * 支付账户用户标示，银联 userid
         */
        public String acct;

        /**
         * 非贷记卡：no_credit
         * 借、贷记卡：””，需要传空字符串，不能不传
         */
        public LimitPay limitPay;

        /**
         * 用户下单和调起支付的终端ip 地址
         */
        public String cusip;
    }

    public static class UnionPayJsRequest extends BaseUnionPayJsRequest {
        @Builder
        public UnionPayJsRequest(Long amount, String extendParams, String acct, LimitPay limitPay, String cusip) {
            super(amount, extendParams, acct, limitPay, cusip);
        }
    }

}
