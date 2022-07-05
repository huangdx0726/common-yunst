package com.yunst.request.member;

import com.yunst.enums.OperationType;
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
public class VspTermIdServiceRequest extends BaseMemberRequest {
    /**
     * 操作
     */
    private OperationType operationType;

    /**
     * 收银宝集团商户号
     */
    private String vspMerchantid;

    /**
     * 收银宝商户号
     */
    private String vspCusid;

    /**
     * 收银宝分配的appid
     */
    private String appid;

    /**
     * 收银宝当面付二维码编号/POS 终端号
     */
    private String vspTermid;

    @Builder
    public VspTermIdServiceRequest(String bizUserId, OperationType operationType, String vspMerchantid, String appid, String vspTermid) {
        super(bizUserId);
        this.operationType = operationType;
        this.vspMerchantid = vspMerchantid;
        this.appid = appid;
        this.vspTermid = vspTermid;
    }
}
