package com.yunst.constant;

/**
 * @author dudangman
 */
public final class YunstConstants {
    /**
     * MemberService
     */
    public interface MemberService {
        /**
         * 会员服务名称
         */
        String SERVICE_NAME = "MemberService";

        /**
         * 创建会员
         */
        String CREATE_MEMBER_METHOD_NAME = "createMember";

        /**
         * 发送短信验证码
         */
        String SEND_VERIFICATION_CODE_METHOD_NAME = "sendVerificationCode";

        /**
         * 绑定手机
         */
        String BIND_PHONE_METHOD_NAME = "bindPhone";

        /**
         * 会员电子协议签约
         */
        String SIGN_CONTRACT_METHOD_NAME = "signContract";

        /**
         * 会员电子协议签约查询
         */
        String SIGN_CONTRACT_QUERY_METHOD_NAME = "signContractQuery";

        /**
         * 个人实名认证
         */
        String SET_REAL_NAME_METHOD_NAME = "setRealName";

        /**
         * 设置企业信息
         */
        String SET_COMPANY_INFO_METHOD_NAME = "setCompanyInfo";

        /**
         * 企业信息审核结果通知
         */
        String VERIFY_RESULT_METHOD_NAME = "verifyResult";

        /**
         * 影印件采集
         */
        String ID_CARD_COLLECT_METHOD_NAME = "idcardCollect";

        /**
         * 获取会员信息
         */
        String GET_MEMBER_INFO_METHOD_NAME = "getMemberInfo";

        /**
         * 查询卡bin
         */
        String GET_BANK_CARD_BIN_METHOD_NAME = "getBankCardBin";

        /**
         * 请求绑定银行卡
         */
        String APPLY_BIND_BANK_CARD_METHOD_NAME = "applyBindBankCard";

        /**
         * 确认绑定银行卡
         */
        String BIND_BANK_CARD_METHOD_NAME = "bindBankCard";

        /**
         * 查询绑定银行卡
         */
        String QUERY_BANK_CARD_METHOD_NAME = "queryBankCard";

        /**
         * 解绑绑定银行卡
         */
        String UNBIND_BANK_CARD_METHOD_NAME = "unbindBankCard";

        /**
         * 锁定会员
         */
        String LOCK_MEMBER_METHOD_NAME = "lockMember";

        /**
         * 解锁会员
         */
        String UNLOCK_MEMBER_METHOD_NAME = "unlockMember";

        /**
         * 会员收银宝渠道商户信息及终端信息绑定
         */
        String VSP_TERMID_SERVICE_METHOD_NAME = "vspTermidService";

        /**
         * 会员绑定支付账户用户标识
         */
        String APPLY_BIND_ACCT_METHOD_NAME = "applyBindAcct";

        /**
         * 解绑手机（验证原手机短信验证码）
         */
        String UNBIND_PHONE_METHOD_NAME = "unbindPhone";

        /**
         * 修改绑定手机(银行卡验证)
         */
        String BANK_CARD_CHANGE_BIND_PHONE_METHOD_NAME = "bankCardChangeBindPhone";

        /**
         * 确定修改绑定手机(银行卡验证)
         */
        String VERIFY_BANK_CARD_CHANGE_BIND_PHONE_METHOD_NAME = "verifyBankCardChangeBindPhone";

        /**
         * 会员子账号开通
         */
        String CREATE_BANK_SUB_ACCT_NO_METHOD_NAME = "createBankSubAcctNo";

    }

    /**
     * MemberPwdService
     */
    public interface MemberPwdService {
        /**
         * 密码服务名称
         */
        String SERVICE_NAME = "MemberPwdService";

        /**
         * 设置支付密码【密码验证版】
         */
        String SET_PAY_PWD_METHOD_NAME = "setPayPwd";

        /**
         * 修改支付密码【密码验证版】
         */
        String UPDATE_PAY_PWD_METHOD_NAME = "updatePayPwd";

        /**
         * 重置支付密码【密码验证版】
         */
        String RESET_PAY_PWD_METHOD_NAME = "resetPayPwd";

        /**
         * 修改绑定手机【密码验证版】
         */
        String UPDATE_PHONE_BY_PAY_PWD_METHOD_NAME = "updatePhoneByPayPwd";

    }

    /**
     * 订单服务
     */
    public interface OrderService {
        String SERVICE_NAME = "OrderService";

        /**
         * 充值
         */
        String DEPOSIT_APPLY_METHOD_NAME = "depositApply";

        /**
         * 提现
         */
        String WITH_DRAW_APPLY_METHOD_NAME = "withdrawApply";

        /**
         * 托管代收申请（标准版）
         */
        String AGENT_COLLECT_APPLY_METHOD_NAME = "agentCollectApply";

        /**
         * 确认支付（后台+短信验证码确认）
         */
        String PAY_METHOD_NAME = "pay";

        /**
         * 单笔托管代付(标准版)
         */
        String SIGNAL_AGENT_PAY_METHOD_NAME = "signalAgentPay";

        /**
         * 批量托管代付（标准版）
         */
        String BATCH_AGENT_PAY_METHOD_NAME = "batchAgentPay";

        /**
         * 消费申请
         */
        String CONSUME_APPLY_METHOD_NAME = "consumeApply";

        /**
         * 平台转账
         */
        String APPLICATION_TRANSFER_METHOD_NAME = "applicationTransfer";

        /**
         * 退款申请
         */
        String REFUND_METHOD_NAME = "refund";

        /**
         * 查询余额
         */
        String QUERY_BALANCE_METHOD_NAME = "queryBalance";

        /**
         * 查询账户明细
         */
        String QUERY_IN_EXP_DETAIL_METHOD_NAME = "queryInExpDetail";

        /**
         * 冻结金额
         */
        String FREEZE_MONEY_METHOD_NAME = "freezeMoney";

        /**
         * 解冻金额
         */
        String UN_FREEZE_MONEY_METHOD_NAME = "unfreezeMoney";
    }
}
