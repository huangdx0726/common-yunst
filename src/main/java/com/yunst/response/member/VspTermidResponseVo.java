package com.yunst.response.member;

import com.yunst.response.BaseYunstResponseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class VspTermidResponseVo extends BaseYunstResponseVo {
    private static final long serialVersionUID = 1210716083131354540L;

    private VspTermidVo signedValue;

    @Data
    public static class VspTermidVo {
        /**
         * 商户系统用户标识
         */
        private String bizUserId;

        /**
         * 绑定、查询收银宝终端号结果
         * 成功：OK
         * 失败：error
         */
        private String result;

        /**
         * 已绑定收银宝终端号列表
         */
        private List<VspTermid> vspTermidList;
    }

    @Data
    public static class VspTermid {
        /**
         * 收银宝集团商户号
         */
        private String vspMerchantid;

        /**
         * 收银宝商户号
         */
        private String vspCusid;

        /**
         * 收银宝终端号
         */
        private String vspTermid;

        /**
         * 绑定时间
         */
        private String setDate;
    }
}
