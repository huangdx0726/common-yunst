package com.yunst.request.member;

import com.yunst.annotation.EncryptRsa;
import com.yunst.enums.IdentityType;
import com.yunst.enums.JumpPageType;
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
public class UpdatePhoneByPayPwdRequest extends BaseMemberRequest {
    /**
     * 跳转页面类型
     * 默认为H5
     */
    private JumpPageType jumpPageType;

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
     * 原手机号
     */
    private String oldPhone;

    /**
     * 后台通知地址
     * 企业会员审核结果通知
     */
    private String backUrl;

    /**
     * 修改密码成功后，跳转返回的页面地址
     */
    private String jumpUrl;

    /**
     * 修改密码失败后，跳转商户页面
     */
    private String errorJumpUrl;

    @Builder
    public UpdatePhoneByPayPwdRequest(String bizUserId, JumpPageType jumpPageType, String name, IdentityType identityType, String identityNo, String oldPhone, String backUrl, String jumpUrl, String errorJumpUrl) {
        super(bizUserId);
        this.jumpPageType = jumpPageType;
        this.name = name;
        this.identityType = identityType;
        this.identityNo = identityNo;
        this.oldPhone = oldPhone;
        this.backUrl = backUrl;
        this.jumpUrl = jumpUrl;
        this.errorJumpUrl = errorJumpUrl;
    }
}
