package com.yunst.annotation;

import java.lang.annotation.*;

/**
 * 解密
 * @author dudangman
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DecryptRsa {
}
