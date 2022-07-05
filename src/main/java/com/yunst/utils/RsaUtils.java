package com.yunst.utils;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.exceptions.UtilException;
import com.allinpay.yunst.sdk.YunClient;
import com.yunst.annotation.DecryptRsa;
import com.yunst.annotation.EncryptRsa;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * rsa 加解密
 * @author dudangman
 */
public class RsaUtils {
    enum Type {
        /**
         * 加密
         */
        ENCRYPT,
        /**
         * 解密
         */
        DECRYPT
    }

    /**
     * 加密
     * @param object obj
     */
    public static void encrypt(Object object) {
        if (object == null) {
            return;
        }
        List<Field> fields = getFields(object, EncryptRsa.class);
        setValue(fields, Type.ENCRYPT, object);
    }

    /**
     * 解密
     * @param object obj
     */
    public static void decrypt(Object object) {
        if (object == null) {
            return;
        }
        List<Field> fields = getFields(object, DecryptRsa.class);
        setValue(fields, Type.DECRYPT, object);
    }

    public static <T> void decryptList(List<T> objects) {
        if (CollectionUtil.isEmpty(objects)){
            return;
        }
        objects.forEach(RsaUtils::decrypt);
    }

    private static void setValue(List<Field> fields, Type type, Object object) {
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldValue = (String) field.get(object);
                if (Type.ENCRYPT.equals(type)) {
                    field.set(object, YunClient.encrypt(fieldValue));
                } else if (Type.DECRYPT.equals(type)) {
                    field.set(object, YunClient.decrypt(fieldValue));
                }
                field.setAccessible(false);
            }
        }catch (Exception ex) {
            throw new UtilException("参数加/解密异常", ex);
        }
    }

    private static List<Field> getFields (Object object, Class<? extends Annotation> annotationClass) {
        if (object == null) {
            return Collections.emptyList();
        }
        Field[] fields = object.getClass().getDeclaredFields();
        return Arrays.stream(fields)
                .filter(field -> field.getAnnotation(annotationClass) != null)
                .collect(Collectors.toList());
    }
}
