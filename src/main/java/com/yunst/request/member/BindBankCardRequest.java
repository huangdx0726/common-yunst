package com.yunst.request.member;

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
public class BindBankCardRequest extends BaseMemberRequest {
    /**
     * 流水号
     * 请求绑定银行卡接口返回
     */
    private String tranceNum;

    /**
     * 申请时间
     *
     * 请求绑定银行卡接口返回
     */
    private String transDate;

    /**
     * 手机号
     */
    private String phone;

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

    /**
     * 验证码
     */
    private String verificationCode;

    @Builder
    public BindBankCardRequest(String bizUserId, String tranceNum, String transDate, String phone, String validate, String cvv2, String verificationCode) {
        super(bizUserId);
        this.tranceNum = tranceNum;
        this.transDate = transDate;
        this.phone = phone;
        this.validate = validate;
        this.cvv2 = cvv2;
        this.verificationCode = verificationCode;
    }
}
