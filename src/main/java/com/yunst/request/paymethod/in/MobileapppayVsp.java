package com.yunst.request.paymethod.in;

import com.yunst.request.BasePayMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 收银宝手机银行APP
 * @author dudangman
 */
public class MobileapppayVsp extends BasePayMethod {
    public MobileapppayVsp(MobileAppPayVspRequest payMethodRequest) {
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
    public static class MobileAppPayVspRequest extends BasePayMethodRequest {
        /**
         *支付金额，单位：分
         */
        private Long amount;
    }
}
