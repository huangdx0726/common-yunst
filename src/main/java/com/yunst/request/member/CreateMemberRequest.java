package com.yunst.request.member;

import cn.hutool.json.JSONObject;
import com.yunst.enums.*;
import com.yunst.request.BaseMemberRequest;
import com.yunst.request.CompanyInfo;
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
public class CreateMemberRequest extends BaseMemberRequest {
    /**
     * 会员类型
     */
    private MemberType memberType;

    /**
     * 访问终端类型
     */
    private SourceType source;

    /**
     * 扩展参数
     * JSONObject
     */
    private JSONObject extendParam;

    @Builder
    public CreateMemberRequest(String bizUserId, MemberType memberType, SourceType source, JSONObject extendParam) {
        super(bizUserId);
        this.memberType = memberType;
        this.source = source;
        this.extendParam = extendParam;
    }
}
