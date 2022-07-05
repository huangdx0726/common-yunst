package com.yunst.enums;

import com.yunst.annotation.EnumValue;

/**
 * @author dudangman
 */
public enum ReceiptFlag {
    Y("Y");
    final String flag;
    ReceiptFlag(String flag) {
        this.flag = flag;
    }

    @EnumValue
    public String getFlag() {
        return flag;
    }
}
