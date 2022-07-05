package com.yunst.request.member;

import com.yunst.enums.PicType;
import com.yunst.request.BaseMemberRequest;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class IdCardCollectRequest extends BaseMemberRequest {
    /**
     * 影印件核对结果异步通
     * 知地址
     */
    private String ocrComparisonResultBackUrl;

    /**
     * 影印件类型
     */
    private PicType picType;

    /**
     * 影印件图片
     */
    private String picture;

    @Builder
    public IdCardCollectRequest(String bizUserId, String ocrComparisonResultBackUrl, PicType picType, String picture) {
        super(bizUserId);
        this.ocrComparisonResultBackUrl = ocrComparisonResultBackUrl;
        this.picType = picType;
        this.picture = picture;
    }
}
