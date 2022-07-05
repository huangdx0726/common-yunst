package com.yunst.utils;

import com.allinpay.yunst.sdk.bean.YunRequest;
import com.yunst.request.OrderRequestBuilder;
import com.yunst.request.order.*;
import com.yunst.response.order.*;
import org.springframework.util.Assert;

import static com.yunst.constant.YunstConstants.OrderService.*;

/**
 * @author dudangman
 */
public class YunstOrderUtils {

    private static final String PAY_METHOD_ERROR_MESSAGE = "%s不支持组合支付!";

    /**
     * 充值
     * @param orderRequest request
     * @return DepositApplyResponseVo
     * @throws Exception 接口异常
     */
    public static DepositApplyResponseVo depositApply(DepositApplyRequest orderRequest) throws Exception {
        YunstRequestUtils.checkMethodParam(DEPOSIT_APPLY_METHOD_NAME, orderRequest);
        YunstRequestUtils.checkParam(orderRequest.getBizOrderNo(), orderRequest.getBizUserId(), orderRequest.getAccountSetNo(),
                orderRequest.getAmount(), orderRequest.getFee(), orderRequest.getBackUrl(), orderRequest.getPayMethods(), orderRequest.getIndustryCode(),
                orderRequest.getIndustryName(), orderRequest.getSource());
        Assert.isTrue(orderRequest.getPayMethods().size() == 1, String.format(PAY_METHOD_ERROR_MESSAGE, "充值业务"));
        YunRequest request = OrderRequestBuilder.builder(DEPOSIT_APPLY_METHOD_NAME)
                .payMethods(orderRequest.getPayMethods())
                .autoBuild(orderRequest);
        return YunstRequestUtils.request(request, DepositApplyResponseVo.class);
    }

    /**
     * 提现
     * @param orderRequest orderRequest
     * @return WithdrawApplyResponseVo
     * @throws Exception 接口异常
     */
    public static WithdrawApplyResponseVo withdrawApply(WithdrawApplyRequest orderRequest) throws Exception {
        YunstRequestUtils.checkMethodParam(WITH_DRAW_APPLY_METHOD_NAME, orderRequest);
        YunstRequestUtils.checkParam(orderRequest.getBizOrderNo(), orderRequest.getBizUserId(), orderRequest.getAccountSetNo(),
                orderRequest.getAccountSetNo(), orderRequest.getFee(), orderRequest.getBackUrl(), orderRequest.getBankCardNo(),
                orderRequest.getIndustryCode(), orderRequest.getIndustryName(), orderRequest.getSource());
        YunRequest request = OrderRequestBuilder.builder(WITH_DRAW_APPLY_METHOD_NAME)
                .payMethod(orderRequest.getPayMethod())
                .autoBuild(orderRequest);
        return YunstRequestUtils.request(request, WithdrawApplyResponseVo.class);
    }

    /**
     * 托管代收申请（标准版）
     * @param orderRequest request
     * @return AgentCollectApplyResponseVo
     * @throws Exception 接口异常
     */
    public static AgentCollectApplyResponseVo agentCollectApply(AgentCollectApplyRequest orderRequest) throws Exception {
        YunstRequestUtils.checkMethodParam(AGENT_COLLECT_APPLY_METHOD_NAME, orderRequest);
        YunstRequestUtils.checkParam(orderRequest.getPayerId(), orderRequest.getBizOrderNo(), orderRequest.getRecieverList(), orderRequest.getTradeCode(),
                orderRequest.getAmount(), orderRequest.getBackUrl(), orderRequest.getPayMethods(), orderRequest.getIndustryCode(),
                orderRequest.getIndustryName(), orderRequest.getSource());
        YunRequest request = OrderRequestBuilder.builder(AGENT_COLLECT_APPLY_METHOD_NAME)
                .payMethods(orderRequest.getPayMethods())
                .recieverList(orderRequest.getRecieverList())
                .autoBuild(orderRequest);
        return YunstRequestUtils.request(request, AgentCollectApplyResponseVo.class);
    }

    /**
     * 确认支付（后台+短信验证码确认）
     * @param payRequest payRequest
     * @return PayResponseVo
     * @throws Exception 接口异常
     */
    public static PayResponseVo pay(PayRequest payRequest) throws Exception {
        YunstRequestUtils.checkMethodParam(PAY_METHOD_NAME, payRequest);
        YunstRequestUtils.checkParam(payRequest.getBizUserId(), payRequest.getBizOrderNo(), payRequest.getVerificationCode(), payRequest.getConsumerIp());
        YunRequest request = OrderRequestBuilder.builder(PAY_METHOD_NAME)
                .autoBuild(payRequest);
        return YunstRequestUtils.request(request, PayResponseVo.class);
    }

    /**
     * 单笔托管代付（标准版）
     * @param payRequest request
     * @return SignalAgentPayResponseVo
     * @throws Exception 接口异常
     */
    public static SignalAgentPayResponseVo signalAgentPay(SignalAgentPayRequest payRequest) throws Exception {
        YunstRequestUtils.checkMethodParam(SIGNAL_AGENT_PAY_METHOD_NAME, payRequest);
        YunstRequestUtils.checkParam(payRequest.getBizOrderNo(), payRequest.getCollectPayList(), payRequest.getBizUserId(), payRequest.getAccountSetNo(),
                payRequest.getBackUrl(), payRequest.getAmount(), payRequest.getFee(), payRequest.getTradeCode());
        YunRequest request = OrderRequestBuilder.builder(SIGNAL_AGENT_PAY_METHOD_NAME)
                .autoBuild(payRequest);
        return YunstRequestUtils.request(request, SignalAgentPayResponseVo.class);
    }

    /**
     * 批量托管代付（标准版）
     * @param payRequest request
     * @return BatchAgentPayResponseVo
     * @throws Exception 接口异常
     */
    public static BatchAgentPayResponseVo batchAgentPay(BatchAgentPayRequest payRequest) throws Exception {
        YunstRequestUtils.checkMethodParam(BATCH_AGENT_PAY_METHOD_NAME, payRequest);
        YunstRequestUtils.checkParam(payRequest.getBizBatchNo(), payRequest.getBatchPayList());

        YunRequest request = OrderRequestBuilder.builder(BATCH_AGENT_PAY_METHOD_NAME)
                .autoBuild(payRequest);
        return YunstRequestUtils.request(request, BatchAgentPayResponseVo.class);
    }

    /**
     * 消费申请
     * @param consumeRequest request
     * @return ConsumeApplyResponseVo
     * @throws Exception 接口异常
     */
    public static ConsumeApplyResponseVo consumeApply(ConsumeApplyRequest consumeRequest) throws Exception {
        YunstRequestUtils.checkMethodParam(CONSUME_APPLY_METHOD_NAME, consumeRequest);
        YunstRequestUtils.checkParam(consumeRequest.getPayMethods(), consumeRequest.getRecieverId(), consumeRequest.getBizOrderNo(), consumeRequest.getAmount(),
                consumeRequest.getFee(), consumeRequest.getBackUrl(), consumeRequest.getPayMethods(), consumeRequest.getIndustryCode(), consumeRequest.getIndustryName());
        YunRequest request = OrderRequestBuilder.builder(CONSUME_APPLY_METHOD_NAME)
                .payMethods(consumeRequest.getPayMethods())
                .autoBuild(consumeRequest);
        return YunstRequestUtils.request(request, ConsumeApplyResponseVo.class);
    }

    /**
     * 平台转账
     * @param applicationRequest request
     * @return ApplicationTransferResponseVo
     * @throws Exception 接口异常
     */
    public static ApplicationTransferResponseVo applicationTransfer(ApplicationTransferRequest applicationRequest) throws Exception {
        YunstRequestUtils.checkMethodParam(APPLICATION_TRANSFER_METHOD_NAME, applicationRequest);
        YunstRequestUtils.checkParam(applicationRequest.getBizTransferNo(), applicationRequest.getSourceAccountSetNo(), applicationRequest.getTargetBizUserId(),
                applicationRequest.getTargetAccountSetNo(), applicationRequest.getAmount());
        YunRequest request = OrderRequestBuilder.builder(APPLICATION_TRANSFER_METHOD_NAME)
                .autoBuild(applicationRequest);
        return YunstRequestUtils.request(request, ApplicationTransferResponseVo.class);
    }

    /**
     * 退款申请
     * @param refundRequest request
     * @return RefundResponseVo
     * @throws Exception 接口异常
     */
    public static RefundResponseVo refund(RefundRequest refundRequest) throws Exception {
        YunstRequestUtils.checkMethodParam(REFUND_METHOD_NAME, refundRequest);
        YunstRequestUtils.checkParam(refundRequest.getBizOrderNo(), refundRequest.getOriBizOrderNo(), refundRequest.getBizUserId(),
                refundRequest.getAmount());
        YunRequest request = OrderRequestBuilder.builder(REFUND_METHOD_NAME)
                .autoBuild(refundRequest);
        return YunstRequestUtils.request(request, RefundResponseVo.class);
    }

    /**
     * 查询余额
     * @param balanceRequest request
     * @return QueryBalanceResponseVo
     * @throws Exception 接口异常
     */
    public static QueryBalanceResponseVo queryBalance(QueryBalanceRequest balanceRequest) throws Exception {
        YunstRequestUtils.checkMethodParam(QUERY_BALANCE_METHOD_NAME, balanceRequest);
        YunstRequestUtils.checkParam(balanceRequest.getBizUserId(), balanceRequest.getAccountSetNo());

        YunRequest request = OrderRequestBuilder.builder(QUERY_BALANCE_METHOD_NAME)
                .autoBuild(balanceRequest);
        return YunstRequestUtils.request(request, QueryBalanceResponseVo.class);
    }

    /**
     * 查询账户收支明细
     * @param detailRequest req
     * @return QueryInExpDetailResponseVo
     * @throws Exception 接口异常
     */
    public static QueryInExpDetailResponseVo queryInExpDetail(QueryInExpDetailRequest detailRequest) throws Exception {
        YunstRequestUtils.checkMethodParam(QUERY_IN_EXP_DETAIL_METHOD_NAME, detailRequest);
        YunstRequestUtils.checkParam(detailRequest.getBizUserId(), detailRequest.getDateStart(), detailRequest.getDateEnd(), detailRequest.getStartPosition(),
                detailRequest.getQueryNum());
        YunRequest request = OrderRequestBuilder.builder(QUERY_IN_EXP_DETAIL_METHOD_NAME)
                .autoBuild(detailRequest);
        return YunstRequestUtils.request(request, QueryInExpDetailResponseVo.class);
    }

    /**
     * 冻结金额
     * @param freezeRequest req
     * @return FreezeMoneyResponseVo
     * @throws Exception 接口异常
     */
    public static FreezeMoneyResponseVo freezeMoney(FreezeMoneyRequest freezeRequest) throws Exception {
        YunstRequestUtils.checkMethodParam(FREEZE_MONEY_METHOD_NAME, freezeRequest);
        YunstRequestUtils.checkParam(freezeRequest.getBizUserId(), freezeRequest.getBizFreezenNo(),
                freezeRequest.getAccountSetNo(), freezeRequest.getAmount());

        YunRequest request = OrderRequestBuilder.builder(FREEZE_MONEY_METHOD_NAME)
                .autoBuild(freezeRequest);
        return YunstRequestUtils.request(request, FreezeMoneyResponseVo.class);
    }

    /**
     * 解冻金额
     * @param unFreezeRequest req
     * @return FreezeMoneyResponseVo
     * @throws Exception 接口异常
     */
    public static FreezeMoneyResponseVo unfreezeMoney(FreezeMoneyRequest unFreezeRequest) throws Exception {
        YunstRequestUtils.checkMethodParam(UN_FREEZE_MONEY_METHOD_NAME, unFreezeRequest);
        YunstRequestUtils.checkParam(unFreezeRequest.getBizUserId(), unFreezeRequest.getBizFreezenNo(),
                unFreezeRequest.getAccountSetNo(), unFreezeRequest.getAmount());
        YunRequest request = OrderRequestBuilder.builder(UN_FREEZE_MONEY_METHOD_NAME)
                .autoBuild(unFreezeRequest);
        return YunstRequestUtils.request(request, FreezeMoneyResponseVo.class);
    }
}
