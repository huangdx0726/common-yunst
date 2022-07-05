package com.yunst.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author dudangman
 */
@Data
@Builder
@AllArgsConstructor
public class ExtUserInfo implements Serializable {
    private static final long serialVersionUID = -621144375722893231L;

    /**
     * 姓名
     * 注： need_check_info=T 时该参数才有效
     */
    private String name;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 注： need_check_info=T 时该参数才有效
     */
    private CertType cert_type;

    /**
     * 证件号
     * 注：need_check_info=T 时该参数才有效
     */
    private String cert_no;

    /**
     * 允许的最小买家年龄，买家年龄必须大于等于所传数值注：
     * 1.	need_check_info=T 时该参数才有效
     * 2.	min_age 为整数，必须大于等于 0
     */
    private String mini_age;

    /**
     * 是否强制校验付款人身份信息
     */
    private CheckInfo fix_buyer;

    /**
     * 是否强制校验付款人身份信息
     */
    private CheckInfo need_check_info;

    public enum CertType {
        /**
         * 身份证
         */
        IDENTITY_CARD,
        /**
         * 护照
         */
        PASSPORT,
        /**
         * 军官证
         */
        OFFICER_CARD,
        /**
         * 士兵证
         */
        SOLDIER_CARD,
        /**
         * 户口本
         */
        HOKOU
    }

    public enum CheckInfo {
        /**
         * 强制校验
         */
        T,
        /**
         * 强制校验
         */
        F
    }

}
