package com.sunesoft.ecloud.common.sqlBuilderTool;



import com.sunesoft.ecloud.common.sqlBuilderTool.annotations.FieldWithoutCheck;
import com.sunesoft.ecloud.common.sqlBuilderTool.annotations.AliasName;
import com.sunesoft.ecloud.common.sqlBuilderTool.annotations.SqlIgnore;
import com.sunesoft.ecloud.common.sqlBuilderTool.annotations.TableName;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import com.sunesoft.ecloud.common.utils.ReflectionUtil;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SqlBuilderHelper {

    public static String getTableNameForClass(Class<?> clazz) {
        String tableName;
        TableName table = clazz.getAnnotation(TableName.class) ;
        if(null != table){
            tableName = table.value() ;
            if("".equalsIgnoreCase(tableName)){
                tableName = clazz.getSimpleName() ;
            }
        }else{
            tableName = clazz.getSimpleName() ;
        }
        return tableName;
    }



    public static Map<String,String> getSimplePropertieNames(Class<?> clazz) {
        Map<String,String>  names = new HashMap<>();
        Class<?> cls = clazz;
        while (cls != null) {//当父类为null的时候说明到达了最上层的父类(Object类).
            names.putAll(getPropertieNames(cls));
            cls = cls.getSuperclass(); //得到父类,然后赋给自己
        }
        return names;
    }
    private static Map<String,String>  getPropertieNames(Class<?> clazz) {
        Map<String,String>  names = new HashMap<>();
        PropertyDescriptor[] propertyDescriptors = BeanUtil.getPropertyDescriptors(clazz);
        PropertyDescriptor[] var7 = propertyDescriptors;
        int var6 = propertyDescriptors.length;

        for(int var5 = 0; var5 < var6; ++var5) {
            PropertyDescriptor property = var7[var5];
            String key = property.getName();
            String name = key;
            String aliseName = key;

            try {
                Field field = ReflectionUtil.findField(clazz, key);

                if("class".equals(key)) {
                    continue;
                }
                if (field == null || !isFieldIgnore(field) ) {
                    continue;
                }
                AliasName annotation = (AliasName)field.getAnnotation(AliasName.class);
                if (annotation != null) {
                    name = annotation.value();
                    aliseName = property.getName();
                }
                FieldWithoutCheck fieldWithoutCheck = (FieldWithoutCheck)field.getAnnotation(FieldWithoutCheck.class);
                if (fieldWithoutCheck != null) {
                    name = "FieldWithoutCheck";
                    aliseName = property.getName();
                }
            } catch (Exception var13) {
                continue;
            }
            names.put(name,aliseName);
        }

        return names;
    }
    public static boolean isFieldIgnore(Field field){


        if (field.getAnnotation(SqlIgnore.class) != null) {
            return false;
        }else {
            Class<?> type = field.getType();
            return isSimpleProperty(type);
        }

    }

    private static boolean isSimpleProperty(Class<?> type){
        if (!type.isArray() && !Collection.class.isAssignableFrom(type) && !Map.class.isAssignableFrom(type)) {
            if (BeanUtil.isSimpleProperty(type)) {
                return true;
            } else {
                return  (UUID.class == type||Boolean.class==type||LocalDate.class==type||LocalDateTime.class==type);
            }
        } else {
            return false;
        }
    }


}
