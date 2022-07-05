package com.yunst.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author dudangman
 */
@Data
@AllArgsConstructor
@Builder
public class Reciever implements Serializable {

    private static final long serialVersionUID = -2519302947162794249L;

    /**
     * 商户系统用户标识，商户系统中唯一编号。
     */
    private String bizUserId;

    /**
     * 商户系统用户标识，商户系统中唯一编号。
     */
    private Long amount;
}
