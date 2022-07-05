package com.yunst.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dudangman
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseMemberRequest {
    /**
     * 商户系统用户标识，商户系统中唯一编号
     */
    public String bizUserId;
}
