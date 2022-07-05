package com.yunst.annotation;

import java.lang.annotation.*;

/**
 * 加密
 * @author dudangman
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EncryptRsa {
}
