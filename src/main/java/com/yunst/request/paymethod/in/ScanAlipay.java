package com.yunst.request.paymethod.in;

import com.yunst.enums.IdentityType;
import com.yunst.enums.LimitPay;
import com.yunst.request.BasePayMethod;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 收银宝支付宝扫码支付( 正扫)
 * @author dudangman
 */
public class ScanAlipay extends BasePayMethod {
    public ScanAlipay(ScanAlipayRequest payMethodRequest) {
        super(payMethodRequest);
    }

    @Override
    public String getSimpleName() {
        return this.getClass().getSimpleName();
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @NoArgsConstructor
    public static class ScanAlipayRequest extends ScanWeixin.BaseScanRequest {
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
        public ScanAlipayRequest(Long amount, String extendParams, LimitPay limitPay, String idNo, String name, IdentityType certType, String benefitdetail, String chnlstoreid, String subbranch) {
            super(amount, extendParams, limitPay, idNo, name, certType);
            this.benefitdetail = benefitdetail;
            this.chnlstoreid = chnlstoreid;
            this.subbranch = subbranch;
        }
    }
}
