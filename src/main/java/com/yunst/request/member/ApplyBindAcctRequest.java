package com.yunst.request.member;

import com.yunst.enums.AcctType;
import com.yunst.enums.OperationType;
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
public class ApplyBindAcctRequest extends BaseMemberRequest {
    /**
     * 操作
     */
    private OperationType operationType;

    /**
     * 支付账户类型
     */
    private AcctType acctType;


    /**
     * 支付账户用户标识
     */
    private String acct;

    @Builder
    public ApplyBindAcctRequest(String bizUserId, OperationType operationType, AcctType acctType, String acct) {
        super(bizUserId);
        this.operationType = operationType;
        this.acctType = acctType;
        this.acct = acct;
    }
}
