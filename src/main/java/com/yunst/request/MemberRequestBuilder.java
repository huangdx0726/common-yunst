package com.yunst.request;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.allinpay.yunst.sdk.bean.YunRequest;
import com.yunst.constant.YunstConstants;
import com.yunst.enums.PicType;
import com.yunst.utils.YunstRequestUtils;

/**
 * @author dudangman
 */
public class MemberRequestBuilder {
    private final YunRequest request;

    private MemberRequestBuilder(String methodName, Boolean pwd) {
        this.request = new YunRequest( pwd ? YunstConstants.MemberPwdService.SERVICE_NAME : YunstConstants.MemberService.SERVICE_NAME, methodName);
    }

    public static MemberRequestBuilder builder(String methodName) {
        return new MemberRequestBuilder(methodName, Boolean.FALSE);
    }

    public static MemberRequestBuilder builderPwd(String methodName) {
        return new MemberRequestBuilder(methodName, Boolean.TRUE);
    }

    public MemberRequestBuilder bizUserId(String bizUserId) {
        this.request.put("bizUserId", bizUserId);
        return this;
    }

    public MemberRequestBuilder memberType(Integer memberType) {
        this.request.put("memberType", memberType);
        return this;
    }

    public MemberRequestBuilder source(Integer source) {
        this.request.put("source", source);
        return this;
    }

    public MemberRequestBuilder extendParam(JSONObject extendParam) {
        this.request.put("extendParam", extendParam);
        return this;
    }

    public MemberRequestBuilder phone(String phone) {
        this.request.put("phone", phone);
        return this;
    }

    public MemberRequestBuilder verificationCodeType(Integer verificationCodeType) {
        this.request.put("verificationCodeType", verificationCodeType);
        return this;
    }
    public MemberRequestBuilder verificationCode(String verificationCode) {
        this.request.put("verificationCode", verificationCode);
        return this;
    }

    public MemberRequestBuilder jumpPageType(Integer jumpPageType) {
        this.request.put("jumpPageType", jumpPageType);
        return this;
    }

    public MemberRequestBuilder jumpUrl(String jumpUrl) {
        this.request.put("jumpUrl", jumpUrl);
        return this;
    }

    public MemberRequestBuilder noContractUrl(String noContractUrl) {
        this.request.put("noContractUrl", noContractUrl);
        return this;
    }

    public MemberRequestBuilder backUrl(String backUrl) {
        this.request.put("backUrl", backUrl);
        return this;
    }

    public MemberRequestBuilder isAuth(Boolean isAuth) {
        this.request.put("isAuth", isAuth);
        return this;
    }

    public MemberRequestBuilder identityType(Integer identityType) {
        this.request.put("identityType", identityType);
        return this;
    }

    public MemberRequestBuilder identityNo(String identityNo) {
        this.request.put("identityNo", identityNo);
        return this;
    }

    public MemberRequestBuilder identityBeginDate(String identityBeginDate) {
        this.request.put("identityBeginDate", identityBeginDate);
        return this;
    }

    public MemberRequestBuilder identityEndDate(String identityEndDate) {
        this.request.put("identityEndDate", identityEndDate);
        return this;
    }

    public MemberRequestBuilder address(String address) {
        this.request.put("address", address);
        return this;
    }

    public MemberRequestBuilder professionNo(String professionNo) {
        this.request.put("professionNo", professionNo);
        return this;
    }

    public MemberRequestBuilder telephone(String telephone) {
        this.request.put("telephone", telephone);
        return this;
    }

    public MemberRequestBuilder name(String name) {
        this.request.put("name", name);
        return this;
    }

    public MemberRequestBuilder companyBasicInfo(CompanyInfo companyInfo){
        this.request.put("companyBasicInfo", JSONUtil.parseObj(companyInfo));
        return this;
    }

    public MemberRequestBuilder ocrComparisonResultBackUrl(String ocrComparisonResultBackUrl) {
        this.request.put("ocrComparisonResultBackUrl", ocrComparisonResultBackUrl);
        return this;
    }

    public MemberRequestBuilder picType(PicType picType) {
        this.request.put("picType", picType.getCode());
        return this;
    }

    public MemberRequestBuilder picture(String picture) {
        this.request.put("picture", picture);
        return this;
    }

    public MemberRequestBuilder acctOrgType(Integer acctOrgType) {
        this.request.put("acctOrgType", acctOrgType);
        return this;
    }

    public MemberRequestBuilder cardNo(String cardNo) {
        this.request.put("cardNo", cardNo);
        return this;
    }

    public MemberRequestBuilder cardCheck(Integer cardCheck) {
        this.request.put("cardCheck", cardCheck);
        return this;
    }

    public MemberRequestBuilder validate(String validate) {
        this.request.put("validate", validate);
        return this;
    }

    public MemberRequestBuilder cvv2(String cvv2) {
        this.request.put("cvv2", cvv2);
        return this;
    }

    public MemberRequestBuilder unionBank(String unionBank) {
        this.request.put("unionBank", unionBank);
        return this;
    }

    public MemberRequestBuilder tranceNum(String tranceNum) {
        this.request.put("tranceNum", tranceNum);
        return this;
    }

    public MemberRequestBuilder transDate(String transDate) {
        this.request.put("transDate", transDate);
        return this;
    }

    public MemberRequestBuilder errorJumpUrl(String errorJumpUrl) {
        this.request.put("errorJumpUrl", errorJumpUrl);
        return this;
    }

    public MemberRequestBuilder acctType(String acctType) {
        this.request.put("acctType", acctType);
        return this;
    }

    public MemberRequestBuilder acct(String acct) {
        this.request.put("acct", acct);
        return this;
    }

    public MemberRequestBuilder accountSetNo(String accountSetNo) {
        this.request.put("accountSetNo", accountSetNo);
        return this;
    }

    public YunRequest build() {
        return this.request;
    }

    /**
     * 根据对象属性字段构建通联request
     * 对需要加密对参数字段加密
     * @param baseMemberRequest memberRequest
     * @return YunRequest
     */
    public YunRequest autoBuild(BaseMemberRequest baseMemberRequest){
        return YunstRequestUtils.buildYunRequest(this.request, baseMemberRequest, Boolean.TRUE);
    }
}
