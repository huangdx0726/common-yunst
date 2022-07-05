package com.yunst.request.paymethod.in;

import com.yunst.request.BasePayMethod;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 收银宝微信JS 支付（公众号）_集团
 * @author dudangman
 */
public class WechatPublicOrg extends BasePayMethod {
    public WechatPublicOrg(WechatPublicOrgRequest payMethodRequest) {
        super(payMethodRequest);
    }

    @Override
    public String getSimpleName() {
        return this.getClass().getSimpleName();
    }

    @EqualsAndHashCode(callSuper = true)
    @NoArgsConstructor
    @Data
    public static class WechatPublicOrgRequest extends WechatPublic.BaseWechatPublicRequest {
        /**
         * 收银宝子商户号，与公众号对应
         */
        private String vspCusid;

        @Builder
        public WechatPublicOrgRequest(String subAppid, String acct, String goods_tag, String benefitdetail, String chnlstoreid, String subbranch, String vspCusid) {
            super(subAppid, acct, goods_tag, benefitdetail, chnlstoreid, subbranch);
            this.vspCusid = vspCusid;
        }
    }

}
