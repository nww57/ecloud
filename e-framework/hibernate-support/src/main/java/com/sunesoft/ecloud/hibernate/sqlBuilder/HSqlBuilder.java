package com.sunesoft.ecloud.hibernate.sqlBuilder;


import com.sunesoft.ecloud.common.sqlBuilderTool.SqlBuilder;

import javax.persistence.Table;

@SuppressWarnings("all")
public class HSqlBuilder<T> extends SqlBuilder<T> {
    @Override
    public String getTable(Class<?> clazz) {
        String tableName = clazz.getSimpleName();
        Table annotation = (Table) clazz.getAnnotation(Table.class);
        if (annotation != null) {
            tableName = annotation.name();
        }
        return tableName;
    }


    public static  SqlBuilder  hFrom(Class<?> clazz,String aliseName){
        HSqlBuilder bulder = new HSqlBuilder();
        bulder.from(clazz,aliseName);
        return bulder;
    }


}
