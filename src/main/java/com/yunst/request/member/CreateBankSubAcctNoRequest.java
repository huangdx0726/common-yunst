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
public class CreateBankSubAcctNoRequest extends BaseMemberRequest {
    /**
     * 账户集编号
     */
    private String accountSetNo;

    /**
     * 开户机构类型
     * 0-通联
     */
    private Integer acctOrgType;

    @Builder
    public CreateBankSubAcctNoRequest(String bizUserId, String accountSetNo, Integer acctOrgType) {
        super(bizUserId);
        this.accountSetNo = accountSetNo;
        this.acctOrgType = acctOrgType;
    }
}
