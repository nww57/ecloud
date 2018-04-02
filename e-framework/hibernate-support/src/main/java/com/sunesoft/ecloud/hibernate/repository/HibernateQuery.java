package com.sunesoft.ecloud.hibernate.repository;

import org.hibernate.SQLQuery;
import org.hibernate.internal.TypeLocatorImpl;
import org.hibernate.transform.Transformers;
import org.hibernate.type.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author: Zhouzh
 * @Date: 2018/4/2
 */
public abstract class HibernateQuery {
    @Autowired
    protected EntityManager em;

    /**
     * 创建一个基于 HQL 语句的查询对象。
     *
     * @param hql    HQL 查询语句。
     * @param params HQL 查询语句使用的参数。
     * @return 返回创建的查询对象。
     */
    protected  Query createQuery(String hql, Object... params) {
        Query q = em.createQuery(hql);
        int idx = 0;
        for (Object obj : params) {
            q.setParameter(idx++, obj);
        }
        return q;
    }

    /**
     * 创建一个基于 HQL 语句的查询对象。
     *
     * @param hql    HQL 查询语句。
     * @param params HQL 查询语句使用的命名参数。
     * @return 返回创建的查询对象。
     */
    protected  Query createQuery(String hql, Map<String, Object> params) {
         Query q = em.createQuery(hql);
        for (String key : params.keySet()) {
            q.setParameter(key, params.get(key));
        }
        return q;
    }

    public int getCountBySql(String sql, Map<String, Object> params) {
        String countSql = sql.substring(0, sql.toLowerCase().indexOf("from "));
        if (null == countSql || countSql.trim().equals("")) {
            countSql = "select count(*) " + sql;
        } else {
            countSql = sql.replace(countSql, "select count(*) ");
        }
        if (countSql.toLowerCase().contains(" order ")) {
            countSql = countSql.substring(0, countSql.toLowerCase().indexOf("order"));
        }
        Query query = em.createNativeQuery(countSql);
        setParams(query, params);
        return query.getFirstResult() ;
    }

    protected <E> List<E> queryForObjects(Class<E> clazz, String sql, Map<String, Object> params) {
        Query query = em.createNativeQuery(sql);
        setParams(query, params);
        SQLQuery sqlQuery = addScalar(query, clazz);
        sqlQuery.setResultTransformer(Transformers.aliasToBean(clazz));
        return sqlQuery.list();
    }

    private void setParams(Query query, Map<String, Object> params) {
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (param.getValue() instanceof Collection)
                    query.setParameter(param.getKey(), (Collection) param.getValue());
                else
                    query.setParameter(param.getKey(), param.getValue());
            }
        }
    }


    public <E> SQLQuery addScalar(Query query, Class<E> clazz) {
        SQLQuery sqlQuery = query.unwrap(SQLQuery.class);
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if ((field.getType() == long.class) || (field.getType() == Long.class)) {
                sqlQuery.addScalar(field.getName(), new LongType());
            } else if ((field.getType() == int.class) || (field.getType() == Integer.class)) {
                sqlQuery.addScalar(field.getName(), new IntegerType());
            } else if ((field.getType() == char.class) || (field.getType() == Character.class)) {
                sqlQuery.addScalar(field.getName(), new CharacterType());
            } else if (field.getType() == BigDecimal.class) {
                sqlQuery.addScalar(field.getName(), BigDecimalType.INSTANCE);
            } else if ((field.getType() == short.class) || (field.getType() == Short.class)) {
                sqlQuery.addScalar(field.getName(), new ShortType());
            } else if ((field.getType() == double.class) || (field.getType() == Double.class)) {
                sqlQuery.addScalar(field.getName(), new DoubleType());
            } else if ((field.getType() == float.class) || (field.getType() == Float.class)) {
                sqlQuery.addScalar(field.getName(), new FloatType());
            } else if ((field.getType() == boolean.class) || (field.getType() == Boolean.class)) {
                sqlQuery.addScalar(field.getName(), new BooleanType());
            } else if (field.getType() == String.class) {
                sqlQuery.addScalar(field.getName(), new StringType());
            } else if (field.getType() == Date.class) {
                sqlQuery.addScalar(field.getName(), DateType.INSTANCE);
            } else if (field.getType() == UUID.class) {
                sqlQuery.addScalar(field.getName(), UUIDCharType.INSTANCE);
            } else if (field.getType().isEnum()) {
                Properties params = new Properties();
                params.put("enumClass", field.getType().getName());
                params.put("type", "12"); /*type 12 instructs to use the String representation of enum value*/
                Type myEnumType = new TypeLocatorImpl(new TypeResolver()).custom(EnumType.class, params);
                sqlQuery.addScalar(field.getName(), myEnumType);
            }
        }

        return sqlQuery;
    }



}
