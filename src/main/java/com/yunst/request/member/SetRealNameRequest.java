package com.yunst.request.member;

import com.yunst.annotation.EncryptRsa;
import com.yunst.enums.IdentityType;
import com.yunst.request.BaseMemberRequest;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class SetRealNameRequest extends BaseMemberRequest {
    /**
     * 是否由云商通进行认证
     */
    private Boolean isAuth = true;

    /**
     * 姓名
     */
    private String name;

    /**
     * 证件类型
     */
    private IdentityType identityType;

    /**
     * 证件号码
     */
    @EncryptRsa
    private String identityNo;

    /**
     * 证件有效开始日期
     */
    private String identityBeginDate;

    /**
     * 证件有效截止日期
     * 若长期有效则上送“9999-12-31”
     */
    private String identityEndDate;

    /**
     * 地址
     * 不少于 10 个中文汉字
     */
    private String address;

    /**
     * 职业
     */
    private String professionNo;

    /**
     * 手机号
     */
    private String telephone;

    @Builder
    public SetRealNameRequest(String bizUserId, Boolean isAuth, IdentityType identityType, String identityNo, String identityBeginDate, String identityEndDate, String address, String professionNo, String telephone) {
        super(bizUserId);
        this.isAuth = isAuth;
        this.identityType = identityType;
        this.identityNo = identityNo;
        this.identityBeginDate = identityBeginDate;
        this.identityEndDate = identityEndDate;
        this.address = address;
        this.professionNo = professionNo;
        this.telephone = telephone;
    }
}
