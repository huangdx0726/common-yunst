package com.yunst.request.paymethod.in;

import com.yunst.enums.LimitPay;
import com.yunst.request.BasePayMethod;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 收银宝付款码支付_ 集团—
 * — 支持微信、支付宝、银联、手机QQ
 * @author dudangman
 */
public class CodepayVspOrg extends BasePayMethod {
    public CodepayVspOrg(CodePayVspOrgRequest payMethodRequest) {
        super(payMethodRequest);
    }

    @Override
    public String getSimpleName() {
        return this.getClass().getSimpleName();
    }

    @EqualsAndHashCode(callSuper = true)
    @NoArgsConstructor
    @Data
    public static class CodePayVspOrgRequest extends CodepayVsp.BaseCodePayVspRequest {
        /**
         * 收银宝子商户号
         */
        private String vspCusid;

        @Builder
        public CodePayVspOrgRequest(Long amount, String extendParams, String authcode, LimitPay limitPay, String goods_tag, String benefitdetail, String chnlstoreid, String subbranch, String vspCusid) {
            super(amount, extendParams, authcode, limitPay, goods_tag, benefitdetail, chnlstoreid, subbranch);
            this.vspCusid = vspCusid;
        }
    }

}
