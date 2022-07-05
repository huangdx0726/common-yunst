package com.yunst.response.member;

import com.yunst.annotation.DecryptRsa;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class EnterpriseMemberInfoResponseVo extends MemberInfoResponseVo {
    private static final long serialVersionUID = 3928145514418933465L;

    private EnterpriseMemberInfoVo signedValue;

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class EnterpriseMemberInfoVo extends MemberInfoResponseVo.MemberInfoVo {
        private EnterpriseMemberInfo memberInfo;
    }
    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class EnterpriseMemberInfo extends MemberInfoResponseVo.MemberInfo {
        /**
         * 企业名称
         */
        private String companyName;

        /**
         * 企业地址
         */
        private String companyAddress;

        /**
         * 认证类型（三证或一证）
         * @see com.yunst.enums.CompanyAuthType
         */
        private Integer authType;

        /**
         * 营业执照号（三证）
         */
        private String businessLicense;

        /**
         * 组织机构代码（三证）
         */
        private String organizationCode;

        /**
         * 统一社会信用（一证）
         */
        private String uniCredit;

        /**
         * 税务登记证（三证）
         */
        private String taxRegister;

        /**
         * 统一社会信用/营业执照号到期时间
         */
        private String expLicense;

        /**
         * 联系电话
         */
        private String telephone;

        /**
         * 手机号码
         */
        private String phone;

        /**
         * 法人姓名
         */
        private String legalName;

        /**
         * 法人证件类型
         * @see com.yunst.enums.IdentityType
         */
        private String identityType;

        /**
         * 法人证件号码
         * rsa 加密
         */
        @DecryptRsa
        private String legalIds;

        /**
         * 证件有效开始日期
         */
        private String identityBeginDate;

        /**
         * 证件有效截止日期
         */
        private String identityEndDate;

        /**
         * 法人手机号码
         */
        private String legalPhone;

        /**
         * 企业对公账户账号
         * RSA 加密
         */
        @DecryptRsa
        private String accountNo;

        /**
         * 开户银行名称
         */
        private String parentBankName;

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
         * 开户行所在省
         */
        private String province;

        /**
         * 开户行所在市
         */
        private String city;

        /**
         * 是否已签电子协议
         */
        private Boolean isSignContract;

        /**
         * 审核状态
         */
        private Integer status;

        /**
         * 审核时间
         */
        private String checkTime;

        /**
         * 备注
         */
        private String remark;

        /**
         * 审核失败原因
         */
        private String failReason;

        /**
         * 开户机构类型
         * 0-通联
         */
        private Integer acctOrgType;

        /**
         * 会员开通或通联子账号
         */
        private String subAcctNo;

        /**
         * 云商通用户id
         */
        private String userId;

        /**
         * 是否绑定手机
         */
        private Boolean isPhoneChecked;

        /**
         * 签订电子协议时间
         */
        private String signContractTime;

        /**
         * 电子协议编号
         */
        private String ContractNo;

        /**
         * OCR 识别与企业工商认证信息是否一致0-否
         * 1-是
         */
        private Integer ocrRegnumComparisonResult;

        /**
         * OCR 识别与企业法人实名信息是否一致0-否
         * 1-是
         */
        private Integer ocrIdcardComparisonResult;

        /**
         * 比对结果信息，存在多种结果信息一起返回，使
         * 用“;”进行拼接
         */
        private String resultInfo;
    }
}
