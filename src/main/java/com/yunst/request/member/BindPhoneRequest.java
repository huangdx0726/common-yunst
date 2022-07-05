package com.yunst.request.member;

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
public class BindPhoneRequest extends BaseMemberRequest {
    /**
     * 手机号
     */
    private String phone;

    /**
     * 验证码
     */
    private String verificationCode;

    @Builder
    public BindPhoneRequest(String bizUserId, String phone, String verificationCode) {
        super(bizUserId);
        this.phone = phone;
        this.verificationCode = verificationCode;
    }
}
