package com.yunst.request;

import com.yunst.annotation.DecryptRsa;
import com.yunst.annotation.EncryptRsa;
import com.yunst.enums.BankName;
import com.yunst.enums.CompanyAuthType;
import com.yunst.enums.IdentityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 公司信息
 * @author dudangman
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyInfo implements Serializable {
    private static final long serialVersionUID = 8194715869956841247L;

    /**
     * 企业名称，如有括号，用中文格式（）
     */
    private String companyName;

    /**
     * 企业地址
     */
    private String companyAddress;

    /**
     * 认证类型，默认三证
     */
    private CompanyAuthType authType = CompanyAuthType.THREE;

    /**
     * 统一社会信用（一证）
     * 认证类型为 2 时必传
     */
    private String uniCredit;

    /**
     * 营业执照号（三证）
     * 认证类型为 1 时必传
     */
    private String businessLicense;

    /**
     * 组织机构代码（三证）
     * 认证类型为 1 时必传
     */
    private String organizationCode;

    /**
     * 税务登记证（三证）
     * 认证类型为 1 时必传
     */
    private String taxRegister;

    /**
     * 统一社会信用/营业执照号到期时间
     * 格式：yyyy-MM-dd
     */
    private String expLicense;

    /**
     * 联系电话
     */
    private String telephone;

    /**
     * 法人姓名
     */
    private String legalName;

    /**
     * 法人证件类型
     */
    private IdentityType identityType;

    /**
     * 法人证件号码
     * RSA 加密
     */
    @EncryptRsa
    @DecryptRsa
    private String legalIds;

    /**
     * 证件有效开始日期
     */
    private String identityBeginDate;

    /**
     * 证件有效截止日期格式
     */
    private String identityEndDate;

    /**
     * 法人手机号码
     */
    private String legalPhone;

    /**
     * 企业对公账户，支持数字和“-”字符
     * RSA 加密
     */
    @EncryptRsa
    @DecryptRsa
    private String accountNo;

    /**
     * 开户银行名称，详细，需严格按照银行列表上送， 部分银行支持多种上送方式，选其一上送即可。
     */
    private BankName parentBankName;

    /**
     * 开户行地区代码
     */
    private String bankCityNo;

    /**
     * 开户行支行名称
     */
    private String bankName;

    /**
     * 支付行号，12 位数字
     */
    private String unionBank;

    /**
     * 开户行所在省 开户行所在市必须同时上送 根据中国省市表的“省份”内容填写
     */
    private String province;

    /**
     * 开户行所在市 开户行所在省必须同时上送 根据中国省市表的“城市”内容填写
     */
    private String city;
}
