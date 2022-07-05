package com.yunst.request.paymethod.in;

import com.yunst.enums.IdentityType;
import com.yunst.enums.LimitPay;
import com.yunst.request.BasePayMethod;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 收银宝微信小程序支付_ 集团
 * @author dudangman
 */
public class WeChatPayMiniProgramOrg extends BasePayMethod {

    private static final String KEY = "WECHATPAY_MINIPROGRAM_ORG";

    public WeChatPayMiniProgramOrg(WeChatPayMiniProgramOrgRequest payMethodRequest) {
        super(payMethodRequest);
    }

    @Override
    public String getSimpleName() {
        return KEY;
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @NoArgsConstructor
    public static class WeChatPayMiniProgramOrgRequest extends WeChatPayMiniProgram.BaseWechatPayMiniProgramRequest {
        /**
         * 收银宝子商户号
         */
        private String vspCusid;

        @Builder
        public WeChatPayMiniProgramOrgRequest(LimitPay limitPay, String subAppid, Long amount, String extendParams, String acct, String goods_tag, String benefitdetail, String chnlstoreid, String subbranch, String idNo, String name, IdentityType certType, String vspCusid) {
            super(limitPay, subAppid, amount, extendParams, acct, goods_tag, benefitdetail, chnlstoreid, subbranch, idNo, name, certType);
            this.vspCusid = vspCusid;
        }
    }
}
