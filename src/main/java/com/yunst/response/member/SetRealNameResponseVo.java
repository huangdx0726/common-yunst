package com.yunst.response.member;

import com.yunst.annotation.DecryptRsa;
import com.yunst.response.BaseYunstResponseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 个人实名响应报文
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class SetRealNameResponseVo extends BaseYunstResponseVo {
    private static final long serialVersionUID = 4480532627423268665L;

    private SetRealNameVo signedValue;

    @Data
    public static class SetRealNameVo {
        /**
         * 姓名
         */
        private String name;

        /**
         * 商户系统用户标识，商户 系统中唯一编号。
         */
        private String bizUserId;

        /**
         * 证件类型
         */
        private String identityType;

        /**
         * 证件号码
         */
        @DecryptRsa
        private String identityNo;

        /**
         * 证件有效开始日期
         */
        private String identityBeginDate;

        /**
         * 证件有效截止日期
         */
        private String identityEndDate;

        /**
         * 住所地或者工作单位地址
         */
        private String address;

        /**
         * 职业
         */
        private String professionNo;

        /**
         * 联系电话
         */
        private String telephone;
    }
}
