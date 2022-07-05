package com.yunst.annotation;


import java.lang.annotation.*;

/**
 * 标记为获取枚举值的方法
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnumValue {

}
