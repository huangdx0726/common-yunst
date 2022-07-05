package com.yunst.request;

import com.allinpay.yunst.sdk.bean.YunRequest;
import com.yunst.request.order.DepositApplyRequest;
import com.yunst.request.order.SignalAgentPayRequest;
import com.yunst.request.paymethod.in.AlipayAppVsp;
import com.yunst.request.paymethod.in.RealNamePay;
import com.yunst.request.paymethod.out.WithdrawTlt;
import com.yunst.request.paymethod.transfer.Balance;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dudangman
 */
public class OrderRequestBuilderTest {


    public void payMethodsTest() {

        Balance.BalanceRequest request1 = Balance.BalanceRequest.builder()
                .accountSetNo("1")
                .amount(1000L)
                .build();

        Balance.BalanceRequest request2 = Balance.BalanceRequest.builder()
                .accountSetNo("2")
                .amount(2000L)
                .build();
        Balance.BalanceRequest request3 = Balance.BalanceRequest.builder()
                .accountSetNo("3")
                .amount(3000L)
                .build();

        WithdrawTlt.WithdrawTltRequest request4 = WithdrawTlt.WithdrawTltRequest.builder()
                .bankName("中国工商银行股份有限公司北京樱桃园支行")
                .build();

        AlipayAppVsp.AlipayAppVspRequest request6 = AlipayAppVsp.AlipayAppVspRequest.builder()
                .chnlstoreid("fd")
                .build();

        RealNamePay.RealNamePayRequest request5 = RealNamePay.RealNamePayRequest.builder()
                .bankCardNo("434")
                .build();

        BasePayMethod basePayMethod1 = new Balance(request1);
        BasePayMethod basePayMethod2 = new Balance(request2);
        BasePayMethod basePayMethod3 = new Balance(request3);

        BasePayMethod basePayMethod4 = new WithdrawTlt(request4);

        BasePayMethod basePayMethod5 = new RealNamePay(request5);

        List<BasePayMethod> payMethods = new ArrayList<>();
        payMethods.add(basePayMethod1);
        payMethods.add(basePayMethod2);
        payMethods.add(basePayMethod3);
        payMethods.add(basePayMethod4);
        payMethods.add(basePayMethod5);

        BaseOrderRequest orderRequest = DepositApplyRequest.builder()
                .payMethods(payMethods)
                .bizOrderNo("21234")
                .build();
        YunRequest request = OrderRequestBuilder.builder("depositApply")
                //.payMethods(payMethods)
                .payMethod(basePayMethod5)
                .autoBuild(orderRequest);
        System.out.println(request.getMethod());

    }

    public static void main(String[] args) {
        SplitRule split1 = SplitRule.builder()
                .accountSetNo("1.1")
                .amount(50L)
                .fee(1L)
                .bizUserId("2")
                .build();
        SplitRule split2 = SplitRule.builder()
                .accountSetNo("1.2")
                .amount(50L)
                .fee(1L)
                .bizUserId("3")
                .build();
        List<SplitRule> sub = new ArrayList<>();
        sub.add(split1);
        sub.add(split2);
        SplitRule splitRule = SplitRule.builder()
                .accountSetNo("1")
                .amount(100L)
                .fee(2L)
                .remark("1")
                .bizUserId("1")
                .splitRuleList(sub)
                .build();
        List<SplitRule> splitRuleList = new ArrayList<>();
        splitRuleList.add(splitRule);
        SignalAgentPayRequest request = SignalAgentPayRequest.builder()
                .splitRuleList(splitRuleList)
                .build();

        YunRequest yunRequest = OrderRequestBuilder.builder("test").autoBuild(request);
        System.out.println(yunRequest);


        RealNamePay.RealNamePayRequest request5 = RealNamePay.RealNamePayRequest.builder()
                .bankCardNo("434")
                .build();

    }
}
