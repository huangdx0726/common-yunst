package com.yunst.request.paymethod.in;

import com.yunst.request.BasePayMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 收银宝手机银行 APP_集团
 * @author dudangman
 */
public class MobileapppayVspOrg extends BasePayMethod {
    public MobileapppayVspOrg(MobileAppPayVspOrgRequest payMethodRequest) {
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
    public static class MobileAppPayVspOrgRequest extends BasePayMethodRequest {
        /**
         * 收银宝子商户号
         */
        private String vspCusid;
        /**
         * 支付金额，单位：分
         */
        private Long amount;
    }
}
