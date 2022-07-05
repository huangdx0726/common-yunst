package com.yunst.enums;

import com.yunst.annotation.EnumValue;

/**
 * @author dudangman
 */
public enum IdentityType {
    /**
     * 身份证
     */
    ID_CARD(1),
    /**
     * 护照
     */
    PASSPORT(2),
    /**
     * 军官证
     */
    MILITARY_ID(3),
    /**
     * 回乡证
     */
    HOMECOMING_ID(4),
    /**
     * 台胞证
     */
    TAIWAN_ID(5),
    /**
     * 警官证
     */
    POLICE_CARD(6),
    /**
     * 士兵证
     */
    SOLDIER_ID(7),
    /**
     * 户口簿
     */
    HOUSEHOLDS_REGISTER(8),
    /**
     * 港澳居民来往内地通行证
     */
    MAINLAND_PERMIT_FOR_HONG_KONG_AND_MACAO(9),
    /**
     * 临时身份证
     */
    TEMPORARY_ID_CARD(10),
    /**
     * 外国人居留证
     */
    ALIEN_PERMIT(11),
    /**
     * Residence
     */
    RESIDENCE_PERMIT_FOR_HONG_KONG_AND_MACAO_AND_TAIWAN(12),
    /**
     * 其他证件
     */
    OTHER_CARD(13)
    ;

    final Integer code;
    IdentityType(Integer code) {
        this.code = code;
    }

    @EnumValue
    public Integer getCode() {
        return code;
    }
}
