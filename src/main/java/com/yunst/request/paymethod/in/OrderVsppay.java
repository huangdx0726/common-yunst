package com.yunst.request.paymethod.in;

import com.yunst.request.BasePayMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 收银宝 POS 当面付及订单模式支付
 * @author dudangman
 */
public class OrderVsppay extends BasePayMethod {
    public OrderVsppay(OrderVspPayRequest payMethodRequest) {
        super(payMethodRequest);
    }

    @Override
    public String getSimpleName() {
        return this.getClass().getSimpleName();
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @Builder
    @AllArgsConstructor
    public static class OrderVspPayRequest extends BasePayMethodRequest {
        /**
         * 单商户模式：收银宝单商户号集团模式：收银宝子商户号
         * 通过调用【会员收银宝渠道商户信
         * 息及终端信息绑定】接口绑定
         */
        private String vspCusid;

        /**
         * 支付金额，单位：分
         */
        private Long amount;
    }
}
