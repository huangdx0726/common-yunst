package com.yunst.request.member;

import cn.hutool.json.JSONObject;
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
public class SetCompanyInfoRequest extends BaseMemberRequest {

    /**
     * 后台通知地址
     * 企业会员审核结果通知
     */
    private String backUrl;

    /**
     * 企业基本信息
     */
    private CompanyInfo companyBasicInfo;

    /**
     * 企业扩展信息
     */
    private JSONObject companyExtendInfo;

    /**
     * 是否进行线上认证
     */
    private Boolean isAuth;

    @Builder
    public SetCompanyInfoRequest(String bizUserId, String backUrl, CompanyInfo companyBasicInfo, JSONObject companyExtendInfo, Boolean isAuth) {
        super(bizUserId);
        this.backUrl = backUrl;
        this.companyBasicInfo = companyBasicInfo;
        this.companyExtendInfo = companyExtendInfo;
        this.isAuth = isAuth;
    }
}
