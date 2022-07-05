package com.yunst.response.order;

import com.yunst.response.BaseYunstResponseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class WithdrawApplyResponseVo extends BaseYunstResponseVo {

    private static final long serialVersionUID = 6913275222054345185L;

    private WithdrawApplyVo signedValue;

    @Data
    public static class WithdrawApplyVo {

        /**
         * 支付状态
         * 成功：success
         * 进行中：pending
         * 失败：fail
         */
        private String payStatus;
        /**
         * 支付失败信息
         */
        private String payFailMessage;

        /**
         * 商户系统用户标识，商户
         * 系统中唯一编号。
         */
        private String bizUserId;

        /**
         * 云商通订单号
         */
        private String orderNo;

        /**
         * 商户订单号（支付订单）
         */
        private String bizOrderNo;

        /**
         * 扩展信息
         */
        private String extendInfo;
    }
}
