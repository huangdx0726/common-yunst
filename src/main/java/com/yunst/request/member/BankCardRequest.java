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
public class BankCardRequest extends BaseMemberRequest {
    /**
     * 银行卡号
     */
    @EncryptRsa
    private String cardNo;

    @Builder
    public BankCardRequest(String bizUserId, String cardNo) {
        super(bizUserId);
        this.cardNo = cardNo;
    }
}
