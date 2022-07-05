package com.yunst.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dudangman
 */
@Data
public abstract class BaseYunstResponseVo implements Serializable {

    private static final long serialVersionUID = -8908473610298609570L;
    /**
     * 服务调用是否成功，“OK”表示成功，“error”表示失败。
     */
    private String status;

    /**
     * 签名
     */
    private String sign;
    /**
     * 当请求失败时返回的错误代码，仅当 status=error 时有效。
     */

    private String errorCode;

    /**
     * 当请求失败时返回的错误信息，仅当 status=error 时有效。
     */
    private String message;
}
