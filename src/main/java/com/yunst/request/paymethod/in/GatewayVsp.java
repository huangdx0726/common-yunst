package com.yunst.request.paymethod.in;

import com.yunst.enums.LimitPay;
import com.yunst.enums.PayType;
import com.yunst.request.BasePayMethod;
import lombok.*;

/**
 * 收银宝网关支付
 * 入金
 * @author dudangman
 */
public class GatewayVsp extends BasePayMethod {
    public GatewayVsp(GatewayVspRequest payMethodRequest) {
        super(payMethodRequest);
    }

    @Override
    public String getSimpleName() {
        return this.getClass().getSimpleName();
    }

    @Getter
    @Setter
    public abstract static class BaseGatewayVspRequest extends BasePayMethodRequest {
        public BaseGatewayVspRequest() {}
        public BaseGatewayVspRequest(Long amount, String gateid, PayType paytype, LimitPay limitPay) {
            this.amount = amount;
            this.gateid = gateid;
            this.paytype = paytype;
            this.limitPay = limitPay;
        }

        /**
         * 支付金额，单位：分
         */
        public Long amount;

        /**
         * 支付银行，见收银宝网银银行列表
         *
         * 注：不填时，跳转至收银宝网关页
         * 面，提供银行列表供用户选择
         */
        public String gateid;

        /**
         * 交易类型，详情
         * gateid 不为空时， 该域只能上送
         * “B2C”或者“B2B”;
         * gateid 为空时， 该域可以上送
         * “B2C”,“B2B”,“B2C,B2B”;
         */
        public PayType paytype;

        /**
         * 不填--借、贷记卡均支持，
         * 默认no_credit--指定不能使用信用卡支付
         * to_credit--限定使用信用卡支付
         */
        public LimitPay limitPay;
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @NoArgsConstructor
    public static class GatewayVspRequest extends BaseGatewayVspRequest {

        @Builder
        public GatewayVspRequest(Long amount, String gateid, PayType paytype, LimitPay limitPay) {
            super(amount, gateid, paytype, limitPay);
        }
    }

}
