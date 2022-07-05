package com.yunst.response.member;

import com.yunst.response.BaseYunstResponseVo;
import lombok.*;

/**
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class CardBinInfoResponseVo extends BaseYunstResponseVo {
    private static final long serialVersionUID = 2601887008367279639L;

    private CardBinInfoVo signedValue;

    @Setter
    @Getter
    public static class CardBinInfoVo {
        private CardBinInfo cardBinInfo;
    }

    @Getter
    @Setter
    public static class CardBinInfo {
        /**
         * 卡 bin
         */
        private String cardBin;
        /**
         * 开类型
         * 1-借记卡 2- 信用卡
         */
        private Integer cardType;
        /**
         * 发卡行代码
         */
        private String bankCode;
        /**
         * 发卡行名称
         */
        private String bankName;
        /**
         * 卡名
         */
        private String cardName;
        /**
         *  卡片长度
         */
        private Long cardLenth;
        /**
         * 状态（1：有效；0：无效）
         */
        private Long cardState;
        /**
         * 卡种名称
         */
        private String cardTypeLabel;
    }
}
