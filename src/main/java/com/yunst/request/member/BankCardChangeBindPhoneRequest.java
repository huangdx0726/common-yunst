package com.yunst.request.member;

import com.yunst.annotation.EncryptRsa;
import com.yunst.enums.BindCardMethod;
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
public class BankCardChangeBindPhoneRequest extends BaseMemberRequest {
    /**
     * 银行卡号
     */
    @EncryptRsa
    private String cardNo;

    /**
     * 预留手机号
     */
    private String phone;

    /**
     * 姓名
     */
    private String name;

    /**
     * 绑卡方式 默认方式-7
     */
    private BindCardMethod cardCheck;

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
     * 有效期
     * 格式为月年；如 0321，2 位月 2 位年，RSA 加密, 详细。使用万鉴通 4 要素绑信用卡
     * 可以不上送此字段
     */
    @EncryptRsa
    private String validate;

    /**
     * 3 位数字，RSA 加密, 详细。使用万鉴通 4 要素绑信用卡
     * 可以不上送此字段
     */
    @EncryptRsa
    private String cvv2;

    @Builder
    public BankCardChangeBindPhoneRequest(String bizUserId, String cardNo, String phone, String name, BindCardMethod cardCheck, IdentityType identityType, String identityNo, String validate, String cvv2) {
        super(bizUserId);
        this.cardNo = cardNo;
        this.phone = phone;
        this.name = name;
        this.cardCheck = cardCheck;
        this.identityType = identityType;
        this.identityNo = identityNo;
        this.validate = validate;
        this.cvv2 = cvv2;
    }
}
