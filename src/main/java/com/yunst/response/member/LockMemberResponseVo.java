package com.yunst.response.member;

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
public class LockMemberResponseVo extends BaseYunstResponseVo {
    private static final long serialVersionUID = -3959811206060507978L;

    private LockMemberVo signedValue;

    @Data
    public static class LockMemberVo {
        private String bizUserId;
    }
}
