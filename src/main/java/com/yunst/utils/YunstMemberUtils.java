package com.yunst.utils;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.allinpay.yunst.sdk.YunClient;
import com.allinpay.yunst.sdk.bean.YunRequest;
import com.yunst.enums.MemberType;
import com.yunst.enums.OperationType;
import com.yunst.request.BaseMemberRequest;
import com.yunst.request.MemberRequestBuilder;
import com.yunst.request.member.*;
import com.yunst.response.member.*;

import static com.yunst.constant.YunstConstants.MemberPwdService.*;
import static com.yunst.constant.YunstConstants.MemberService.*;

/**
 * 会员工具类接口
 * @author dudangman
 */
public class YunstMemberUtils {
    private static final String RPS_KEY = "signedValue";
    private static final String MEMBER_TYPE = "memberType";

    /**
     * 创建会员
     * @param memberRequest memberRequest
     * @return CreateMemberResponseVo
     * @see CreateMemberResponseVo
     * @throws Exception 自己捕获异常
     */
    public static CreateMemberResponseVo createMember(CreateMemberRequest memberRequest) throws Exception {
        // 参数校验
        YunstRequestUtils.checkParam(memberRequest.getBizUserId(), memberRequest.getMemberType(), memberRequest.getSource());
        YunRequest request = MemberRequestBuilder.builder(CREATE_MEMBER_METHOD_NAME)
                .bizUserId(memberRequest.getBizUserId())
                .memberType(memberRequest.getMemberType().getCode())
                .source(memberRequest.getSource().getCode())
                .extendParam(memberRequest.getExtendParam())
                .build();
        return YunstRequestUtils.request(request, CreateMemberResponseVo.class);
    }

    /**
     * 发送短信验证码
     * @param memberRequest memberRequest
     * @return VerificationCodeResponseVo
     * @see VerificationCodeResponseVo
     * @throws Exception 调用异常
     */
    public static VerificationCodeResponseVo sendVerificationCode(SendVerificationCodeRequest memberRequest) throws Exception {
        YunstRequestUtils.checkParam(memberRequest.getBizUserId(), memberRequest.getPhone(), memberRequest.getVerificationCodeType());
        YunRequest request = MemberRequestBuilder.builder(SEND_VERIFICATION_CODE_METHOD_NAME)
                .bizUserId(memberRequest.getBizUserId())
                .phone(memberRequest.getPhone())
                .verificationCodeType(memberRequest.getVerificationCodeType().getCode())
                .build();
        return YunstRequestUtils.request(request, VerificationCodeResponseVo.class);
    }

    /**
     * 绑定手机
     * @param memberRequest memberRequest
     * @return VerificationCodeResponseVo
     * @see VerificationCodeResponseVo
     * @throws Exception 调用异常
     */
    public static VerificationCodeResponseVo bindPhone(BindPhoneRequest memberRequest) throws Exception {
        YunstRequestUtils.checkParam(memberRequest.getBizUserId(), memberRequest.getPhone(), memberRequest.getVerificationCode());
        YunRequest request = MemberRequestBuilder.builder(BIND_PHONE_METHOD_NAME)
                .bizUserId(memberRequest.getBizUserId())
                .phone(memberRequest.getPhone())
                .verificationCode(memberRequest.getVerificationCode())
                .build();
        return YunstRequestUtils.request(request, VerificationCodeResponseVo.class);
    }

    /**
     * 会员电子协议签约
     * @param memberRequest memberRequest
     * @return SignContractResponseVo
     * @see SignContractResponseVo
     * @throws Exception 调用异常
     */
    public static SignContractResponseVo signContract(SignContractRequest memberRequest) throws Exception {
        YunstRequestUtils.checkParam(memberRequest.getBizUserId(), memberRequest.getBackUrl(), memberRequest.getSource());
        YunRequest request = MemberRequestBuilder.builder(SIGN_CONTRACT_METHOD_NAME)
                .bizUserId(memberRequest.getBizUserId())
                .jumpPageType(memberRequest.getJumpPageType().getCode())
                .jumpUrl(memberRequest.getJumpUrl())
                .noContractUrl(memberRequest.getNoContractUrl())
                .backUrl(memberRequest.getBackUrl())
                .source(memberRequest.getSource().getCode())
                .build();
        return YunstRequestUtils.request(request, SignContractResponseVo.class);
    }

    /**
     * 会员电子协议签约查询
     * @param memberRequest memberRequest
     * @return SignContractResponseVo
     * @see SignContractResponseVo
     * @throws Exception 调用接口异常
     */
    public static SignContractResponseVo signContractQuery(SignContractQueryRequest memberRequest) throws Exception {
        YunstRequestUtils.checkParam(memberRequest.getBizUserId(), memberRequest.getSource());
        YunRequest request = MemberRequestBuilder.builder(SIGN_CONTRACT_QUERY_METHOD_NAME)
                .bizUserId(memberRequest.getBizUserId())
                .jumpPageType(memberRequest.getJumpPageType().getCode())
                .jumpUrl(memberRequest.getJumpUrl())
                .source(memberRequest.getSource().getCode())
                .build();
        return YunstRequestUtils.request(request, SignContractResponseVo.class);
    }

    /**
     * 个人实名认证
     * @param memberRequest memberRequest
     * @return SetRealNameResponseVo
     * @see SetRealNameResponseVo
     * @throws Exception 调用异常
     */
    public static SetRealNameResponseVo setRealName(SetRealNameRequest memberRequest) throws Exception {
        YunstRequestUtils.checkParam(memberRequest.getBizUserId(), memberRequest.getName(), memberRequest.getIdentityType(), memberRequest.getIdentityNo());
        // 字段加密
        RsaUtils.encrypt(memberRequest);
        YunRequest request = MemberRequestBuilder.builder(SET_REAL_NAME_METHOD_NAME)
                .bizUserId(memberRequest.getBizUserId())
                .isAuth(memberRequest.getIsAuth())
                .name(memberRequest.getName())
                .identityType(memberRequest.getIdentityType().getCode())
                .identityNo(memberRequest.getIdentityNo())
                .identityBeginDate(memberRequest.getIdentityBeginDate())
                .identityEndDate(memberRequest.getIdentityEndDate())
                .address(memberRequest.getAddress())
                .professionNo(memberRequest.getProfessionNo())
                .telephone(memberRequest.getTelephone())
                .build();
        SetRealNameResponseVo rps = YunstRequestUtils.request(request, SetRealNameResponseVo.class);
        // 参数解密
        RsaUtils.decrypt(rps.getSignedValue());
        return rps;
    }

    /**
     * 设置企业信息
     * @param memberRequest memberRequest
     * @return SetCompanyInfoResponseVo
     * @see SetCompanyInfoResponseVo
     * @throws Exception 接口异常
     */
    public static SetCompanyInfoResponseVo setCompanyInfo(SetCompanyInfoRequest memberRequest) throws Exception {
        YunstRequestUtils.checkParam(memberRequest.getBizUserId(), memberRequest.getCompanyBasicInfo(), memberRequest.getIsAuth());
        // 字段加密
        RsaUtils.encrypt(memberRequest.getCompanyBasicInfo());
        YunRequest request = MemberRequestBuilder.builder(SET_COMPANY_INFO_METHOD_NAME)
                .bizUserId(memberRequest.getBizUserId())
                .backUrl(memberRequest.getBackUrl())
                .companyBasicInfo(memberRequest.getCompanyBasicInfo())
                .build();
        return YunstRequestUtils.request(request, SetCompanyInfoResponseVo.class);
    }

    /**
     * 企业信息审核结果通知
     * @param memberRequest dto
     * @return BaseYunstResponseVo
     * @throws Exception 接口异常
     */
    public static SetCompanyInfoResponseVo verifyResult(BaseMemberRequest memberRequest) throws Exception {
        // todo 待核实
        YunRequest request = MemberRequestBuilder.builder(VERIFY_RESULT_METHOD_NAME)
                .bizUserId(memberRequest.getBizUserId())
                .build();
        return YunstRequestUtils.request(request, SetCompanyInfoResponseVo.class);
    }

    /**
     * 影印件采集
     * @param memberRequest dto
     * @return IdCardCollectResponseVo
     * @throws Exception 接口异常
     */
    public static CommonResponseVo idCardCollect(IdCardCollectRequest memberRequest) throws Exception {
       YunstRequestUtils.checkParam(memberRequest.getBizUserId(), memberRequest.getPicType(), memberRequest.getPicture());
        YunRequest request = MemberRequestBuilder.builder(ID_CARD_COLLECT_METHOD_NAME)
                .bizUserId(memberRequest.getBizUserId())
                .picType(memberRequest.getPicType())
                .picture(memberRequest.getPicture())
                .build();
        return YunstRequestUtils.request(request, CommonResponseVo.class);
    }


    public static void ocrComparisonResult(BaseMemberRequest memberRequest) {
        // todo 影印件核对结果异步通知
    }

    /**
     * 获取会员信息
     * @param memberRequest dot
     * @return MemberInfoResponseVo
     * @throws Exception 接口异常
     */
    public static MemberInfoResponseVo getMemberInfo(GetMemberInfoRequest memberRequest) throws Exception {
        YunstRequestUtils.checkParam(memberRequest.getBizUserId());
        YunRequest request = MemberRequestBuilder.builder(GET_MEMBER_INFO_METHOD_NAME)
                .bizUserId(memberRequest.getBizUserId())
                .acctOrgType(memberRequest.getAcctOrgType())
                .build();
        String result = YunClient.request(request);
        JSONObject jsonObject = JSONUtil.parseObj(result);
        Integer memberType = jsonObject.getJSONObject(RPS_KEY).getInt(MEMBER_TYPE);
        MemberInfoResponseVo rps;
        if (MemberType.PERSONAL_MEMBER.getCode().equals(memberType)){
            // 个人
            rps = JSONUtil.toBean(result, PersonalMemberInfoResponseVo.class);
        }else {
            // 企业
            rps = JSONUtil.toBean(result, EnterpriseMemberInfoResponseVo.class);
        }
        // 解密
        RsaUtils.decrypt(rps.getSignedValue().getMemberInfo());
        return rps;
    }

    /**
     * 查询卡bin
     * @param cardNo 银行卡号
     * @return CardBinInfoResponseVo
     * @see CardBinInfoResponseVo
     * @throws Exception 接口异常
     */
    public static CardBinInfoResponseVo getBankCardBin(String cardNo) throws Exception {
        YunstRequestUtils.checkParam(cardNo);
        YunRequest request = MemberRequestBuilder.builder(GET_BANK_CARD_BIN_METHOD_NAME)
                .cardNo(YunClient.encrypt(cardNo))
                .build();
        return YunstRequestUtils.request(request, CardBinInfoResponseVo.class);
    }

    /**
     * 请求绑定银行卡
     * @param memberRequest request
     * @return ApplyBindBankCardResponseVo
     * @throws Exception 接口异常
     */
    public static ApplyBindBankCardResponseVo applyBindBankCard(ApplyBindBankCardRequest memberRequest) throws Exception {
        YunstRequestUtils.checkParam(memberRequest.getBizUserId(), memberRequest.getCardNo(), memberRequest.getName(), memberRequest.getIdentityType(), memberRequest.getIdentityNo());
        // 加密
        RsaUtils.encrypt(memberRequest);
        YunRequest request = MemberRequestBuilder.builder(APPLY_BIND_BANK_CARD_METHOD_NAME)
                .bizUserId(memberRequest.getBizUserId())
                .cardNo(memberRequest.getCardNo())
                .phone(memberRequest.getPhone())
                .name(memberRequest.getName())
                .cardCheck(memberRequest.getCardCheck().getCode())
                .identityType(memberRequest.getIdentityType().getCode())
                .identityNo(memberRequest.getIdentityNo())
                .validate(memberRequest.getValidate())
                .cvv2(memberRequest.getCvv2())
                .unionBank(memberRequest.getUnionBank())
                .build();
        return YunstRequestUtils.request(request, ApplyBindBankCardResponseVo.class);
    }

    /**
     * 确认绑定银行卡
     * @param memberRequest request
     * @return BindBankCardResponseVo
     * @throws Exception 接口异常
     */
    public static BindBankCardResponseVo bindBankCard(BindBankCardRequest memberRequest) throws Exception {
        YunstRequestUtils.checkParam(memberRequest.getBizUserId(), memberRequest.getPhone(), memberRequest.getVerificationCode());
        // 对请求参数加密
        RsaUtils.encrypt(memberRequest);
        YunRequest request = MemberRequestBuilder.builder(BIND_BANK_CARD_METHOD_NAME)
                .bizUserId(memberRequest.getBizUserId())
                .tranceNum(memberRequest.getTranceNum())
                .transDate(memberRequest.getTransDate())
                .phone(memberRequest.getPhone())
                .validate(memberRequest.getValidate())
                .cvv2(memberRequest.getCvv2())
                .verificationCode(memberRequest.getVerificationCode())
                .build();
        return YunstRequestUtils.request(request, BindBankCardResponseVo.class);
    }

    /**
     * 查询绑定银行卡
     * @param memberRequest request
     * @return QueryBankCardResponseVo
     * @throws Exception 接口异常
     */
    public static QueryBankCardResponseVo queryBankCard(BankCardRequest memberRequest) throws Exception {
        YunstRequestUtils.checkParam(memberRequest.getBizUserId());
        // 加密
        RsaUtils.encrypt(memberRequest);
        YunRequest request = MemberRequestBuilder.builder(QUERY_BANK_CARD_METHOD_NAME)
                .bizUserId(memberRequest.getBizUserId())
                .cardNo(memberRequest.getCardNo())
                .build();
        QueryBankCardResponseVo rps = YunstRequestUtils.request(request, QueryBankCardResponseVo.class);
        // 解密
        RsaUtils.decryptList(rps.getSignedValue().getBindCardList());
        return rps;
    }

    /**
     * 解绑绑定银行卡
     * @param memberRequest request
     * @return UnbindBankCardResponseVo
     * @throws Exception 接口异常
     */
    public static UnbindBankCardResponseVo unbindBankCard(BankCardRequest memberRequest) throws Exception {
        YunstRequestUtils.checkParam(memberRequest.getBizUserId(), memberRequest.getCardNo());
        // 加密
        RsaUtils.encrypt(memberRequest);
        YunRequest request = MemberRequestBuilder.builder(UNBIND_BANK_CARD_METHOD_NAME)
                .bizUserId(memberRequest.getBizUserId())
                .cardNo(memberRequest.getCardNo())
                .build();
        UnbindBankCardResponseVo rps = YunstRequestUtils.request(request, UnbindBankCardResponseVo.class);
        RsaUtils.decrypt(rps.getSignedValue());
        return rps;
    }

    /**
     * 锁定会员
     * @param bizUserId 商户系统用户标识
     * @return LockMemberResponseVo
     * @throws Exception 接口异常
     */
    public static LockMemberResponseVo lockMember(String bizUserId) throws Exception {
        YunstRequestUtils.checkParam(bizUserId);
        YunRequest request = MemberRequestBuilder.builder(LOCK_MEMBER_METHOD_NAME)
                .bizUserId(bizUserId)
                .build();
        return YunstRequestUtils.request(request, LockMemberResponseVo.class);
    }

    /**
     * 解锁会员
     * @param bizUserId 商户系统用户标识
     * @return LockMemberResponseVo
     * @throws Exception 即可异常
     */
    public static LockMemberResponseVo unlockMember (String bizUserId) throws Exception {
        YunstRequestUtils.checkParam(bizUserId);
        YunRequest request = MemberRequestBuilder.builder(UNLOCK_MEMBER_METHOD_NAME)
                .bizUserId(bizUserId)
                .build();
        return YunstRequestUtils.request(request, LockMemberResponseVo.class);
    }

    /**
     * 设置支付密码【密码验证版】
     * @param memberRequest request
     * @return CommonResponseVo
     * @throws Exception 接口异常
     */
    public static CommonResponseVo setPayPwd(SetPayPwdRequest memberRequest) throws Exception {
        YunstRequestUtils.checkParam(memberRequest.getBizUserId(), memberRequest.getPhone(), memberRequest.getName(), memberRequest.getIdentityType(), memberRequest.getIdentityNo(), memberRequest.getBackUrl());
        YunRequest request = MemberRequestBuilder.builderPwd(SET_PAY_PWD_METHOD_NAME)
                .autoBuild(memberRequest);
        return YunstRequestUtils.request(request, CommonResponseVo.class);
    }

    /**
     * 修改支付密码【密码验证版】
     * @param memberRequest request
     * @return CommonResponseVo
     * @throws Exception 接口异常
     */
    public static CommonResponseVo updatePayPwd(UpdatePayPwdRequest memberRequest) throws Exception {
        YunstRequestUtils.checkParam(memberRequest.getBizUserId(), memberRequest.getName(), memberRequest.getIdentityType(), memberRequest.getIdentityNo(), memberRequest.getBackUrl());
        YunRequest request = MemberRequestBuilder.builderPwd(UPDATE_PAY_PWD_METHOD_NAME)
                .autoBuild(memberRequest);
        return YunstRequestUtils.request(request, CommonResponseVo.class);
    }

    /**
     * 重置支付密码【密码验证版】
     * @param memberRequest request
     * @return CommonResponseVo
     */
    public static CommonResponseVo resetPayPwd(ResetPayPwdRequest memberRequest) throws Exception {
        YunstRequestUtils.checkParam(memberRequest.getBizUserId(), memberRequest.getName(), memberRequest.getPhone(), memberRequest.getIdentityType(), memberRequest.getIdentityNo(), memberRequest.getBackUrl());
        YunRequest request = MemberRequestBuilder.builderPwd(RESET_PAY_PWD_METHOD_NAME)
                .autoBuild(memberRequest);
        return YunstRequestUtils.request(request, CommonResponseVo.class);
    }

    /**
     * 修改绑定手机【密码验证版】
     * @param memberRequest request
     * @return UpdatePhoneByPayPwdResponseVo
     * @throws Exception 接口异常
     */
    public static UpdatePhoneByPayPwdResponseVo updatePhoneByPayPwd(UpdatePhoneByPayPwdRequest memberRequest) throws Exception {
        YunstRequestUtils.checkParam(memberRequest.getBizUserId(), memberRequest.getName(), memberRequest.getOldPhone(), memberRequest.getIdentityType(), memberRequest.getIdentityNo(), memberRequest.getBackUrl());
        YunRequest request = MemberRequestBuilder.builderPwd(UPDATE_PHONE_BY_PAY_PWD_METHOD_NAME)
                .autoBuild(memberRequest);
        return YunstRequestUtils.request(request, UpdatePhoneByPayPwdResponseVo.class);
    }

    /**
     * 会员收银宝渠道商户信息及终端信息绑定
     * @param memberRequest request
     * @return VspTermidResponseVo
     * @throws Exception 接口异常
     */
    public static VspTermidResponseVo vspTermidService(VspTermIdServiceRequest memberRequest) throws Exception {
        YunstRequestUtils.checkParam(memberRequest.getBizUserId(), memberRequest.getOperationType(), memberRequest.getVspCusid(),
                memberRequest.getAppid());
        YunRequest request = MemberRequestBuilder.builder(VSP_TERMID_SERVICE_METHOD_NAME)
                .autoBuild(memberRequest);
        return YunstRequestUtils.request(request, VspTermidResponseVo.class);
    }

    /**
     * 会员绑定支付账户用户标识
     * @param memberRequest request
     * @return CommonResponseVo
     * @throws Exception 接口调用异常
     */
    public static CommonResponseVo applyBindAcct(ApplyBindAcctRequest memberRequest) throws Exception {
        YunstRequestUtils.checkParam(memberRequest.getBizUserId(), memberRequest.getOperationType());
        if (OperationType.SET.equals(memberRequest.getOperationType())) {
            YunstRequestUtils.checkParam(memberRequest.getAcct(), memberRequest.getAcctType());
        }
        YunRequest request = MemberRequestBuilder.builder(APPLY_BIND_ACCT_METHOD_NAME)
                .autoBuild(memberRequest);
        return YunstRequestUtils.request(request, CommonResponseVo.class);
    }

    /**
     * 解绑手机（验证原手机短信验证码）
     * @param memberRequest request
     * @return UnbindPhoneResponseVo
     * @throws Exception 接口异常
     */
    public static UnbindPhoneResponseVo unbindPhone(UnbindPhoneRequest memberRequest) throws Exception {
        YunstRequestUtils.checkParam(memberRequest.getBizUserId(), memberRequest.getPhone(), memberRequest.getVerificationCode());
        YunRequest request = MemberRequestBuilder.builder(UNBIND_PHONE_METHOD_NAME)
                .autoBuild(memberRequest);
        return YunstRequestUtils.request(request, UnbindPhoneResponseVo.class);
    }

    /**
     * 修改绑定手机(银行卡验证)
     * @param memberRequest request
     * @return BankCardChangeBindPhoneResponseVo
     * @throws Exception 接口异常
     */
    public static BankCardChangeBindPhoneResponseVo bankCardChangeBindPhone(BankCardChangeBindPhoneRequest memberRequest) throws Exception {
        YunstRequestUtils.checkParam(memberRequest.getBizUserId(), memberRequest.getCardNo(), memberRequest.getPhone(),
                memberRequest.getName(), memberRequest.getCardCheck(), memberRequest.getIdentityType(), memberRequest.getIdentityNo());
        YunRequest request = MemberRequestBuilder.builder(BANK_CARD_CHANGE_BIND_PHONE_METHOD_NAME)
                .autoBuild(memberRequest);
        return YunstRequestUtils.request(request, BankCardChangeBindPhoneResponseVo.class);
    }

    /**
     * 确定修改绑定手机(银行卡验证)
     * @param memberRequest request
     * @return BindBankCardResponseVo
     * @throws Exception 接口异常
     */
    public static BindBankCardResponseVo verifyBankCardChangeBindPhone(VerifyBankCardChangeBindPhoneRequest memberRequest) throws Exception {
        YunstRequestUtils.checkParam(memberRequest.getBizUserId(), memberRequest.getPhone(), memberRequest.getVerificationCode());
        YunRequest request = MemberRequestBuilder.builder(VERIFY_BANK_CARD_CHANGE_BIND_PHONE_METHOD_NAME)
                .autoBuild(memberRequest);
        return YunstRequestUtils.request(request, BindBankCardResponseVo.class);
    }

    /**
     * 会员子账号开通
     * @param memberRequest request
     * @return CreateBanKSubAcctNoResponseVo
     * @throws Exception 接口异常
     */
    public static CreateBanKSubAcctNoResponseVo createBankSubAcctNo(CreateBankSubAcctNoRequest memberRequest) throws Exception {
        YunstRequestUtils.checkParam(memberRequest.getBizUserId(), memberRequest.getAccountSetNo(), memberRequest.getAcctOrgType());
        YunRequest request = MemberRequestBuilder.builder(CREATE_BANK_SUB_ACCT_NO_METHOD_NAME)
                .autoBuild(memberRequest);
        return YunstRequestUtils.request(request, CreateBanKSubAcctNoResponseVo.class);
    }
}
