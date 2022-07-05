package com.yunst.request.paymethod.in;

import com.yunst.enums.IdentityType;
import com.yunst.enums.LimitPay;
import com.yunst.request.BasePayMethod;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 收银宝支付宝JS 支付（生活号）
 * @author dudangman
 */
public class AlipayService extends BasePayMethod {
    public AlipayService(AlipayServiceRequest payMethodRequest) {
        super(payMethodRequest);
    }

    @Override
    public String getSimpleName() {
        return this.getClass().getSimpleName();
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @NoArgsConstructor
    public static class AlipayServiceRequest extends ScanWeixin.BaseScanRequest {
        /**
         * 支付宝 JS 支付 user_id——支付宝分配
         */
        private String acct;

        /**
         * 优惠信息，benefitdetail 的 json 字符串,注意是 String，支付宝智慧
         * 门店
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
        public AlipayServiceRequest(Long amount, String extendParams, LimitPay limitPay, String idNo, String name, IdentityType certType, String acct, String benefitdetail, String chnlstoreid, String subbranch) {
            super(amount, extendParams, limitPay, idNo, name, certType);
            this.acct = acct;
            this.benefitdetail = benefitdetail;
            this.chnlstoreid = chnlstoreid;
            this.subbranch = subbranch;
        }
    }
}
