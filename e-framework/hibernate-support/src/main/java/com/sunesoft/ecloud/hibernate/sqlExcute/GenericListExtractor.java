package com.sunesoft.ecloud.hibernate.sqlExcute;

import org.springframework.cglib.beans.BeanMap;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author: Zhouzh
 * @Date: 2018/3/22
 */
public class GenericListExtractor<T extends Collection> implements ResultSetExtractor<T> {
    protected Class<?> clazz;

    public GenericListExtractor(Class<?> clazz) {
        this.clazz = clazz;
    }

    //使用 cglib 的BeanMap
    @Override
    public T extractData(ResultSet rs) throws SQLException, DataAccessException {

        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取结果集的元素个数
            int colCount = rsmd.getColumnCount();
            List list = new ArrayList();
            while (rs.next()) {//对每一条记录进行操作
                Object obj = clazz.newInstance();
                BeanMap beanMap = BeanMap.create(obj);
                //将每一个字段取出进行赋值
                for (int i = 1; i <= colCount; i++) {
                    if (beanMap.getPropertyType(rsmd.getColumnLabel(i)) != null) {
                        beanMap.put(rsmd.getColumnLabel(i), getObject(beanMap.getPropertyType(rsmd.getColumnLabel(i)), rs, i));
                    }
                }
                list.add(obj);
            }
            return (T) list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


//使用 反射

    private T reflect(ResultSet rs) throws Exception {
        ResultSetMetaData rsmd = rs.getMetaData();
        //获取结果集的元素个数
        int colCount = rsmd.getColumnCount();

        //返回结果的列表集合
        List list = new ArrayList();
        //业务对象的属性数组
        List<Field> fieldList = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        if (fields.length > 0)
            fieldList.addAll(Arrays.asList(fields));
        Class<?> cls = clazz;
        while (cls != null) {//当父类为null的时候说明到达了最上层的父类(Object类).
            Field[] f = cls.getDeclaredFields();
            if (f.length > 0)
                fieldList.addAll(Arrays.asList(f));
            cls = cls.getSuperclass(); //得到父类,然后赋给自己
        }
        while (rs.next()) {//对每一条记录进行操作
            Object obj = null;//构造业务对象实体
            try {
                obj = clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            //将每一个字段取出进行赋值
            for (int i = 1; i <= colCount; i++) {

                //寻找该列对应的对象属性
                for (int j = 0; j < fieldList.size(); j++) {
                    Field f = fieldList.get(j);
                    //如果匹配进行赋值
                    if (f.getName().equalsIgnoreCase(rsmd.getColumnName(i))) {
                        boolean flag = f.isAccessible();
                        f.setAccessible(true);
                        try {
                            f.set(obj, getObject(f.getType(), rs, i));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        f.setAccessible(flag);
                    }
                }
            }
            list.add(obj);
        }
        return (T) list;


    }


    public Object getObject(Class<?> filedType, ResultSet rs, int i) throws SQLException {
        if ((filedType == long.class) || (filedType == Long.class)) {
            return rs.getLong(i);
        } else if ((filedType == int.class) || (filedType == Integer.class)) {
            return rs.getInt(i);
        } else if ((filedType == char.class) || (filedType == Character.class)) {
            return rs.getString(i);
        } else if (filedType == BigDecimal.class) {
            return rs.getBigDecimal(i);
        } else if ((filedType == short.class) || (filedType == Short.class)) {
            return rs.getShort(i);
        } else if ((filedType == double.class) || (filedType == Double.class)) {
            return rs.getDouble(i);
        } else if ((filedType == float.class) || (filedType == Float.class)) {
            return rs.getFloat(i);
        } else if ((filedType == boolean.class) || (filedType == Boolean.class)) {
            return rs.getBoolean(i);
        } else if (filedType == String.class) {
            return rs.getString(i);
        } else if (filedType == Date.class) {
            return rs.getTimestamp(i);
        } else if (filedType == LocalDate.class) {
            //todo
            return null==rs.getDate(i)?null:rs.getDate(i).toLocalDate();
        } else if (filedType == LocalDateTime.class) {
            //todo
            return null==rs.getTimestamp(i)?null:rs.getTimestamp(i).toLocalDateTime();
        } else if (filedType == UUID.class) {
            if (rs.getString(i) != null)
                return UUID.fromString(rs.getString(i));
        } else if (filedType.isEnum()) {
            if (rs.getString(i) != null)
                return Enum.valueOf((Class) filedType, rs.getString(i));
        }
        return null;
    }
}

