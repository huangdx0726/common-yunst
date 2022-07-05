package com.yunst.enums;

import com.yunst.annotation.EnumValue;

/**
 * @author dudangman
 */
public enum GoodsType {
    /**
     * 虚拟商品
     */
    VIRTUAL(2),
    /**
     * 实物商品
     */
    PHYSICAL(3),
    /**
     * 线下商品
     */
    OFFLINE(4),
    /**
     * 跨境商品
     */
    CROSS_BORDER(5),
    /**
     * 营销活动
     */
    MARKETING(90),
    /**
     * 其他
     */
    OTHER(99);

    final Integer code;
    GoodsType(Integer code) {
        this.code = code;
    }

    @EnumValue
    public Integer getCode() {
        return code;
    }
}
