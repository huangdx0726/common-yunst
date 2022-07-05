package com.yunst.request.paymethod.out;

import com.yunst.request.BasePayMethod;
import lombok.*;

/**
 * 通联通代付
 * @author dudangman
 */
public class WithdrawTlt extends BasePayMethod {
    public WithdrawTlt(WithdrawTltRequest payMethodRequest) {
        super(payMethodRequest);
    }

    @Override
    public String getSimpleName() {
        return this.getClass().getSimpleName();
    }

    @Getter
    public abstract static class BaseWithdrawTltRequest extends BasePayMethodRequest {
        /**
         * 必须传withdraw_tlt
         */
        private final String payTypeName = "withdraw_tlt";
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @Builder
    @AllArgsConstructor
    public static class WithdrawTltRequest extends BaseWithdrawTltRequest {
        /**
         * 支付行号，12 位数字
         */
        private String unionBank;

        /**
         * 开户行支行名称
         */
        private String bankName;

        /**
         * 开户行所在省
         */
        private String province;

        /**
         * 开户行所在市
         */
        private String city;
    }

}
