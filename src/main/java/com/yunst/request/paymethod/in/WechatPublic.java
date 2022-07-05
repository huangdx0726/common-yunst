package com.yunst.request.paymethod.in;

import com.yunst.request.BasePayMethod;
import lombok.*;

/**
 * 收银宝微信JS 支付（公众号）
 * @author dudangman
 */
public class WechatPublic extends BasePayMethod {
    public WechatPublic(WechatPublicRequest payMethodRequest) {
        super(payMethodRequest);
    }

    @Override
    public String getSimpleName() {
        return this.getClass().getSimpleName();
    }

    @EqualsAndHashCode(callSuper = true)
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public abstract static class BaseWechatPublicRequest extends ScanWeixin.BaseScanRequest {
        /**
         * 微信公众号支付 appid 参数
         * 当商户有多个小程序或公众号时接口指定上送
         */
        public String subAppid;

        /**
         * 微信 JS 支付 openid——微信分配
         */
        public String acct;

        /**
         * 订单支付标识，订单优惠标记，用于区分订单是否可以享受优惠,字段内容在微信后台配置券时进行设
         * 置，只对微信支付有效
         */
        public String goods_tag;

        /**
         * 优惠信息，benefitdetail 的 json
         * 字符串,注意是 String，微信单品优惠
         */
        public String benefitdetail;

        /**
         * 渠道门店号--商户在支付渠道端的
         * 门店编号
         */
        public String chnlstoreid;

        /**
         * 门店号
         */
        public String subbranch;
    }

    @NoArgsConstructor
    public static class WechatPublicRequest extends BaseWechatPublicRequest {
        @Builder
        public WechatPublicRequest(String subAppid, String acct, String goods_tag, String benefitdetail, String chnlstoreid, String subbranch) {
            super(subAppid, acct, goods_tag, benefitdetail, chnlstoreid, subbranch);
        }
    }
}
