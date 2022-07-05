package com.yunst.request.paymethod.in;

import com.yunst.enums.IdentityType;
import com.yunst.enums.LimitPay;
import com.yunst.request.BasePayMethod;
import lombok.*;

/**
 * 收银宝微信扫码支付(正扫)
 * @author dudangman
 */
public class ScanWeixin extends BasePayMethod {
    public ScanWeixin(ScanWeiXinRequest payMethodRequest) {
        super(payMethodRequest);
    }

    @Override
    public String getSimpleName() {
        return this.getClass().getSimpleName();
    }

    @EqualsAndHashCode(callSuper = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public abstract static class BaseScanRequest extends BasePayMethodRequest {
        /**
         * 支付金额，单位：分
         */
        public Long amount;

        /**
         * 渠道拓展参数，最长 1000 字符
         */
        public String extendParams;

        /**
         * 非贷记卡：no_credit
         * 借、贷记卡：””，需要传空字符串，不能不传
         */
        public LimitPay limitPay;

        /**
         * 证件号
         */
        public String idNo;

        /**
         * 付款人姓名
         */
        public String name;

        /**
         * 证件类型
         * 仅支持“1-身份证”
         */
        public IdentityType certType;
    }


    @NoArgsConstructor
    public static class ScanWeiXinRequest extends BaseScanRequest {
        @Builder
        public ScanWeiXinRequest(Long amount, String extendParams, LimitPay limitPay, String idNo, String name, IdentityType certType) {
            super(amount, extendParams, limitPay, idNo, name, certType);
        }
    }
}
