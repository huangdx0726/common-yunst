package com.yunst.request.paymethod.in;

import com.yunst.enums.LimitPay;
import com.yunst.request.BasePayMethod;
import lombok.*;

/**
 * 微信原生H5 支付
 * @author dudangman
 */
public class WechatpayH5Open extends BasePayMethod {
    public WechatpayH5Open(WeChatPayH5OpenRequest payMethodRequest) {
        super(payMethodRequest);
    }

    @Override
    public String getSimpleName() {
        return this.getClass().getSimpleName();
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class WeChatPayH5OpenRequest extends BasePayMethodRequest {
        /**
         * 微信端应用 ID：appid
         */
        private String subAppId;

        /**
         * 支付金额，单位：分
         */
        private Long amount;

        /**
         * 非贷记卡：no_credit
         * 借、贷记卡：””，需要传空字符串，不能不传
         */
        private LimitPay limitPay;

        /**
         * 微信用户标识 openid——微信分配
         */
        private String acct;

        /**
         * 用户下单及调起支付的终端 IP
         * 注：最大长度 16
         */
        private String cusip;

        /**
         * 场景信息
         * 	sceneInfo	场景信息注：
         * //IOS 移动应用
         * {"h5_info":
         * {"type":"IOS","app_name": "王者荣耀 ","bundle_id": "com.tencent.wzryIOS"}}
         *
         * //安卓移动应用
         * {"h5_info":
         * {"type":"Android","app_name": "王者荣耀 ","package_name": "com.tencent.tmgp.sgame"}}
         *
         * //WAP 网站应用
         * {"h5_info":
         * {"type":"Wap","wap_url": "https://pay.qq.com","wap_name": "腾讯充值"}}
         */
        private String sceneInfo;
    }
}
