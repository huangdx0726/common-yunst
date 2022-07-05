package com.yunst.request.paymethod.transfer;

import com.yunst.request.BasePayMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 代金券
 * 账户内转账
 * @author dudangman
 */
public class Coupon extends BasePayMethod {
    public Coupon(CouponRequest payMethodRequest) {
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
    public static class CouponRequest extends BasePayMethodRequest {
        /**
         * 支付金额 单位：分
         */
        private Long amount;

        /**
         * 账户集编号
         */
        private String accountSetNo;
    }
}
