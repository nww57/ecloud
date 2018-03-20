package com.sunesoft.ecloud.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class ObjectUtl {
    private ObjectUtl() {
    }

    public static boolean equals(Object a, Object b) {
        return Objects.equals(a, b);
    }

    public static <E> E copy(E object) throws RuntimeException {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(object);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (E)ois.readObject();
        } catch (Exception var5) {
            throw new RuntimeException(var5);
        }
    }

    public static <E> E easyCopy(E object) throws RuntimeException {
        try {
            Method method = object.getClass().getDeclaredMethod("clone");
            E objectResult =(E) method.invoke(object);
            return objectResult;
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException var3) {
            throw new RuntimeException(var3);
        }
    }

    public static <E> E create(Class<E> clazz) throws RuntimeException {
        if (clazz == null) {
            return null;
        } else if (clazz.getClass().isArray()) {
            throw new RuntimeException("not support array...");
        } else if (!Object.class.isAssignableFrom(clazz)) {
            throw new RuntimeException("class must be object...");
        } else {
            Object obj = null;

            try {
                obj = clazz.newInstance();
                return (E)obj;
            } catch (Exception var3) {
                throw new RuntimeException(var3);
            }
        }
    }

    public static boolean isObject(Class<?> clazz) {
        if (clazz == null) {
            return false;
        } else if (clazz.getClass().isArray()) {
            return false;
        } else {
            return Object.class.isAssignableFrom(clazz);
        }
    }
}