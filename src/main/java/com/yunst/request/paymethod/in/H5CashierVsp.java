package com.yunst.request.paymethod.in;

import com.yunst.enums.LimitPay;
import com.yunst.request.BasePayMethod;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 收银宝H5 收银台
 * 入金
 * @author dudangman
 */
public class H5CashierVsp extends BasePayMethod {

    public H5CashierVsp(H5CashierVspRequest payMethodRequest) {
        super(payMethodRequest);
    }

    @Override
    public String getSimpleName() {
        return this.getClass().getSimpleName();
    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static abstract class BaseH5CashierVspRequest extends BasePayMethodRequest {

        public BaseH5CashierVspRequest(Long amount, String extendParams, LimitPay limitPay, String goods_tag, String benefitdetail, String subbranch) {
            this.amount = amount;
            this.extendParams = extendParams;
            this.limitPay = limitPay;
            this.goods_tag = goods_tag;
            this.benefitdetail = benefitdetail;
            this.subbranch = subbranch;
        }

        /**
         * 支付金额，单位：分
         */
        public Long amount;

        /**
         * 渠道拓展参数，最长 1000 字符
         */
        public String extendParams;

        /**
         * 非贷记卡：no_credit
         * 借、贷记卡：””，需要传空字符串，不能不传
         */
        public LimitPay limitPay;

        /**
         * 订单支付标识
         */
        public String goods_tag;

        /**
         * 优惠信息，benefitdetail 的 json
         * 字符串,注意是 String，微信单品优惠
         */
        // todo 优惠信息jsonobject 未处理成对象
        public String benefitdetail;

        /**
         * 门店号
         */
        public String subbranch;
    }

    @NoArgsConstructor
    public static class H5CashierVspRequest extends BaseH5CashierVspRequest {
        @Builder
        public H5CashierVspRequest(Long amount, String extendParams, LimitPay limitPay, String goods_tag, String benefitdetail, String subbranch) {
            super(amount, extendParams, limitPay, goods_tag, benefitdetail, subbranch);
        }
    }
}
