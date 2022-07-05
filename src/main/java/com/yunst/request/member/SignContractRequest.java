package com.yunst.request.member;

import com.yunst.enums.JumpPageType;
import com.yunst.enums.SourceType;
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
public class SignContractRequest extends BaseMemberRequest {

    /**
     * 跳转页面类型
     * 默认为H5
     */
    private JumpPageType jumpPageType;

    /**
     * 签订成功后，跳转返回的页面地址
     */
    private String jumpUrl;

    /**
     * 会员取消签约，跳转返回的页面地址
     */
    private String noContractUrl;

    /**
     * 后台通知地址
     * 企业会员审核结果通知
     */
    private String backUrl;

    /**
     * 访问终端类型
     */
    private SourceType source;

    @Builder
    public SignContractRequest(String bizUserId, JumpPageType jumpPageType, String jumpUrl, String noContractUrl, String backUrl, SourceType source) {
        super(bizUserId);
        this.jumpPageType = jumpPageType;
        this.jumpUrl = jumpUrl;
        this.noContractUrl = noContractUrl;
        this.backUrl = backUrl;
        this.source = source;
    }
}
