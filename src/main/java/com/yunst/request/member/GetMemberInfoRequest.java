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
public class GetMemberInfoRequest extends BaseMemberRequest {
    /**
     * 开户机构类型 0 - 通联
     */
    private Integer acctOrgType;

    @Builder
    public GetMemberInfoRequest(String bizUserId, Integer acctOrgType) {
        super(bizUserId);
        this.acctOrgType = acctOrgType;
    }
}
