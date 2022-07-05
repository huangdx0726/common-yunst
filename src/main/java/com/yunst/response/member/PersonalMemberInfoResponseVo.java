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
public class PersonalMemberInfoResponseVo extends MemberInfoResponseVo {
    private static final long serialVersionUID = 93102654785010469L;

    private PersonalMemberInfoVo signedValue;

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class PersonalMemberInfoVo extends MemberInfoVo {
        protected PersonalMemberInfo memberInfo;
    }
    /**
     * 个人基本信息
     */
    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class PersonalMemberInfo extends MemberInfo {
        /**
         * 姓名
         */
        private String name;
        /**
         * 用户状态
         * @see com.yunst.enums.UserState
         */
        private Integer userState;
        /**
         * 云商同用户id
         */
        private String userId;
        /**
         * 国家
         */
        private String country;
        /**
         * 省份
         */
        private String province;
        /**
         * 县市
         */
        private String area;
        /**
         * 地址
         */
        private String address;
        /**
         * 职业
         */
        private String professionNo;
        /**
         * 联系电话
         */
        private String telephone;
        /**
         * 手机号码
         */
        private String phone;
        /**
         * 身份证号码
         * rsa加密
         */
        @DecryptRsa
        private String identityCardNo;
        /**
         * 证件有效开始日期
         */
        private String identityBeginDate;
        /**
         * 证件有效截止日期
         */
        private String identityEndDate;
        /**
         * 是否绑定手机
         */
        private Boolean isPhoneChecked;
        /**
         * 创建时间
         */
        private String registerTime;
        /**
         * 创建ip
         */
        private String registerIp;
        /**
         * 支付失败次数
         */
        private Long payFailAmount;
        /**
         * 是否进行实名认证
         */
        private Boolean isIdentityChecked;
        /**
         * 实名认证时间
         */
        private String realNameTime;
        /**
         * 备注
         */
        private String remark;
        /**
         * 访问终端类型
         * @see com.yunst.enums.SourceType
         */
        private Long source;
        /**
         * 是否已设置支付密码
         */
        private Boolean isSetPayPwd;
        /**
         * 是否已签电子协议
         */
        private Boolean isSignContract;
        /**
         * 开户机构类型
         * 0-通联
         */
        private Long acctOrgType;
        /**
         * 会员开通通联子账号
         */
        private String subAcctNo;
        /**
         * 签订电子协议时间
         */
        private String signContractTime;
        /**
         * 电子协议编号
         */
        private String ContractNo;
    }
}
