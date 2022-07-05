package com.yunst.request.member;

import com.yunst.annotation.DecryptRsa;
import com.yunst.annotation.EncryptRsa;
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
public class VerifyBankCardChangeBindPhoneRequest extends BaseMemberRequest {
    /**
     * 流水号
     */
    private String tranceNum;

    /**
     * 银行预留手机
     */
    private String phone;

    /**
     * 短信验证码
     */
    private String verificationCode;

    /**
     * 有效期
     * 信用卡必填，
     * 绑卡方式 6、7-格式为月年；如 0321， 2 位月 2 位年
     * RSA 加密
     */
    @EncryptRsa
    private String validate;

    /**
     * CVV2
     * 信用卡必填。RSA 加密。
     */
    @EncryptRsa
    private String cvv2;

    @Builder
    public VerifyBankCardChangeBindPhoneRequest(String bizUserId, String tranceNum, String phone, String verificationCode, String validate, String cvv2) {
        super(bizUserId);
        this.tranceNum = tranceNum;
        this.phone = phone;
        this.verificationCode = verificationCode;
        this.validate = validate;
        this.cvv2 = cvv2;
    }
}
