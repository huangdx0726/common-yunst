package com.yunst.enums;

import com.yunst.annotation.EnumValue;

/**
 * 影印件类型
 * @author dudangman
 */
public enum PicType {
    /**
     * 1-统一社会信用证(三证合
     * 一)/营业执照（三证）（一证
     * 或三证必传）
     */
    THREE(1),
    /**
     * 2-组织机构代码证（三证时必传）
     */
    ORGANIZATION_CODE(2),
    /**
     * 3-税务登记证（三证时必传）
     */
    TAX_CERTIFICATE(3),
    /**
     * 4-银行开户证明（非必传，上
     * 传《银行开户许可证》或《基
     * 本存款账户信息》等可证明平
     * 台银行账号和户名的文件）
     */
    BANK_ACCOUNT_CERTIFICATE(4),
    /**
     * 5-机构信用代码
     */
    ORGANIZATION_CREDIT_CODE(5),
    /**
     * 6-ICP 备案许可
     */
    ICP(6),
    /**
     * 7-行业许可证
     */
    INDUSTRY_LICENSE(7),
    /**
     * 8-身份证正面（人像面）
     */
    ID_CARD_FRONT(8),
    /**
     * 9-身份证反面（国徽面）
     */
    ID_CARD_BACK(9)
    ;
    final Integer code;
    PicType(Integer code) {
        this.code = code;
    }

    @EnumValue
    public Integer getCode() {
        return code;
    }
}
