package com.yunst.request.member;

import com.yunst.enums.VerificationCodeType;
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
public class SendVerificationCodeRequest extends BaseMemberRequest {
    /**
     * 手机号
     */
    private String phone;

    /**
     * 验证码类型
     */
    private VerificationCodeType verificationCodeType;

    @Builder
    public SendVerificationCodeRequest(String bizUserId, String phone, VerificationCodeType verificationCodeType) {
        super(bizUserId);
        this.phone = phone;
        this.verificationCodeType = verificationCodeType;
    }
}
