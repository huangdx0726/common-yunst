package com.yunst.request.paymethod.in;

import com.yunst.enums.LimitPay;
import com.yunst.enums.PayType;
import com.yunst.request.BasePayMethod;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author dudangman
 */
public class GatewayVspOrg extends BasePayMethod {

    public GatewayVspOrg(GatewayVspOrgRequest payMethodRequest) {
        super(payMethodRequest);
    }

    @Override
    public String getSimpleName() {
        return this.getClass().getSimpleName();
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @NoArgsConstructor
    public static class GatewayVspOrgRequest extends GatewayVsp.BaseGatewayVspRequest {
        /**
         * 收银宝子商户号
         */
        private String vspCusid;

        @Builder(toBuilder = true)
        public GatewayVspOrgRequest(Long amount, String gateid, PayType paytype, LimitPay limitPay, String vspCusid) {
            super(amount, gateid, paytype, limitPay);
            this.vspCusid = vspCusid;
        }
    }
}
