package com.yunst.request.paymethod.in;

import com.yunst.enums.IdentityType;
import com.yunst.enums.LimitPay;
import com.yunst.request.BasePayMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 收银宝支付宝APP 支付_集团
 * @author dudangman
 */
public class AlipayAppVspOrg extends BasePayMethod {
    public AlipayAppVspOrg(AlipayAppVspOrgRequest payMethodRequest) {
        super(payMethodRequest);
    }

    @Override
    public String getSimpleName() {
        return null;
    }
    @EqualsAndHashCode(callSuper = true)
    @Data
    @AllArgsConstructor
    public static class AlipayAppVspOrgRequest extends ScanWeixin.BaseScanRequest {

        /**
         * 收银宝子商户号
         */
        private String vspCusid;
        /**
         * 优惠信息，benefitdetail 的 json 字符串
         */
        private String benefitdetail;

        /**
         * 渠道门店号--商户在支付渠道端的
         * 门店编号
         */
        private String chnlstoreid;

        /**
         * 门店号
         */
        private String subbranch;

        @Builder
        public AlipayAppVspOrgRequest(Long amount, String extendParams, LimitPay limitPay, String idNo, String name, IdentityType certType, String vspCusid, String benefitdetail, String chnlstoreid, String subbranch) {
            super(amount, extendParams, limitPay, idNo, name, certType);
            this.vspCusid = vspCusid;
            this.benefitdetail = benefitdetail;
            this.chnlstoreid = chnlstoreid;
            this.subbranch = subbranch;
        }
    }
}
