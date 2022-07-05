package com.yunst.response.order;

import com.yunst.response.BaseYunstResponseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class QueryBalanceResponseVo extends BaseYunstResponseVo {
    private static final long serialVersionUID = -553599492612861465L;

    private QueryBalanceVo signedValue;

    @Data
    public static class QueryBalanceVo {
        /**
         * 总额
         */
        private Long allAmount;

        /**
         * 冻结额
         */
        private Long freezenAmount;
    }
}
