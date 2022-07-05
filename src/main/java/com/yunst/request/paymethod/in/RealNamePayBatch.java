package com.yunst.request.paymethod.in;

import com.yunst.request.BasePayMethod;

/**
 * 实名付（批量）
 * @author dudangman
 */
public class RealNamePayBatch extends BasePayMethod {

    private static final String KEY = "REALNAMEPAY_BATCH";

    public RealNamePayBatch(RealNamePay.RealNamePayRequest payMethodRequest) {
        super(payMethodRequest);
    }

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public String getSimpleName() {
        return null;
    }
}
