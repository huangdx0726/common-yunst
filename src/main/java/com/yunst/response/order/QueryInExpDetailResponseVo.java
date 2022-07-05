package com.yunst.response.order;

import com.yunst.response.BaseYunstResponseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class QueryInExpDetailResponseVo extends BaseYunstResponseVo {
    private static final long serialVersionUID = 1524688113570499523L;

    private QueryInExpDetailVo signedValue;

    @Data
    public static class QueryInExpDetailVo {
        /**
         * 商户系统用户标识
         */
        private String bizUserId;
        /**
         * 该账户收支明细总条数
         */
        private Long totalNum;

        /**
         * 收支明细
         */
        private List<AccountDetail> inExpDetail;

        /**
         * 扩展参数
         */
        private String extendInfo;
    }
}
