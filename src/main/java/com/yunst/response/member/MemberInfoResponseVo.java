package com.yunst.response.member;

import cn.hutool.json.JSONUtil;
import com.allinpay.yunst.sdk.YunClient;
import com.yunst.response.BaseYunstResponseVo;
import com.yunst.utils.RsaUtils;
import lombok.*;

/**
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class MemberInfoResponseVo extends BaseYunstResponseVo {
    private static final long serialVersionUID = 3928145514418933465L;

    /**
     * θΏεη»ζ
     */
    private MemberInfoVo signedValue;

    @Getter
    @Setter
    public abstract static class MemberInfoVo {
        protected String bizUserId;

        protected Integer memberType;

        protected MemberInfo memberInfo;
    }

    public abstract static class MemberInfo {

    }
}
