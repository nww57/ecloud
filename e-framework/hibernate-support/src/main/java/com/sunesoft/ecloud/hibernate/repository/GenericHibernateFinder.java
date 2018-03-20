//package com.sunesoft.ecloud.hibernate.repository;
//
//
//import com.sunesoft.ecloud.common.result.PagedResult;
//import com.sunesoft.ecloud.common.sqlBuilderTool.SqlBuilder;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.internal.TypeLocatorImpl;
//import org.hibernate.query.NativeQuery;
//import org.hibernate.query.Query;
//import org.hibernate.transform.Transformers;
//import org.hibernate.type.*;
//import org.hibernate.type.Type;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import java.lang.reflect.Field;
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.*;
//
///**
// * <p>基于 Hibernate 实现的 Query 框架中的查询器实现的基类，
// * 继承者可以通过该基类来简化仓库的实现代码。
// * </p>
// * <p><b>注意：目前的实现要求当前上下文中已经启用了事务管理。</b>
// * </p>
// *
// * @author zhouzh
// * @since 0.1
// */
//@SuppressWarnings("all")
//public class GenericHibernateFinder {
//
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//    /**
//     * <p>获取与当前仓库关联的 {@code Session} 对象。
//     * </p>
//     * <p><b>注意：目前的实现要求当前上下文中已经启用了事务管理。</b>
//     * </p>
//     *
//     * @return 返回当前的 {@code Session} 对象。
//     */
//    protected Session getSession() {
//        return sessionFactory.getCurrentSession();
//    }
//
//
//    public <E> PagedResult<E> pagingBySql(int pageIndex, int pageSize, Class<E> clazz, String sql, Map<String, Object> params) {
//        int totalCount = getCountBySql(sql, params);
//        NativeQuery query = getSession().createNativeQuery(sql);
//        setParams(query, params);
//        query.setFirstResult((pageIndex - 1) * pageSize);
//        query.setMaxResults(pageSize);
//        query.setResultTransformer(Transformers.aliasToBean(clazz));
//        this.addScalar(query, clazz);
//        List<E> results = query.list();
//        return new PagedResult<E>(results, pageIndex, pageSize, totalCount);
//    }
//
//    public int getCountBySql(String sql, Map<String, Object> params) {
//        String countSql = "";
//        if (sql.toLowerCase().contains(" order ")) {
//            sql = sql.substring(0, sql.toLowerCase().indexOf(" order "));
//        }
//        if (!sql.toLowerCase().contains(" group ")) {
//            countSql = sql.substring(0, sql.toLowerCase().indexOf(" from "));
//            if (null == countSql || countSql.trim().equals("")) {
//                countSql = "select count(*) " + sql;
//            } else {
//                countSql = sql.replace(countSql, "select count(*) ");
//            }
//
//        } else {
//            countSql = "select count(*) from (" + sql + ") t";
//        }
//        NativeQuery query = getSession().createNativeQuery(countSql);
//        setParams(query, params);
//        return Integer.parseInt(query.uniqueResult().toString());
//
//    }
//
//
//    public Boolean isExist(String sql, Map<String, Object> params) {
//        return getCountBySql(sql, params) > 0;
//    }
//
//
//    public Boolean isExist(SqlBuilder sqlBuilder) {
//        return getCountBySql(sqlBuilder) > 0;
//    }
//
//
//    private int getCountBySql(SqlBuilder sqlBuilder) {
//        return getCountBySql(sqlBuilder.getQuerySql(), sqlBuilder.getParams());
//    }
//
//
//    public double getSumBySql(SqlBuilder sqlBuilder) {
//        return getSumBySql(sqlBuilder.getQuerySql(), sqlBuilder.getParams());
//
//    }
//
//
//    public double getSumBySql(String sql, Map<String, Object> params) {
//        NativeQuery query = getSession().createNativeQuery(sql);
//        setParams(query, params);
//        Object o = query.uniqueResult();
//        if(o==null){
//            return 0;
//        }
//        return Double.parseDouble(query.uniqueResult().toString());
//
//    }
//
//
//    public  List<Map<String,Object>> queryAsMap(SqlBuilder sqlBuilder){
//        return queryForObjects(sqlBuilder.getQuerySql(), sqlBuilder.getParams());
//    }
//    protected  List<Map<String,Object>> queryForObjects(String sql, Map<String, Object> params) {
//        NativeQuery sqlQuery = getSession().createNativeQuery(sql);
//        setParams(sqlQuery, params);
//        sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
//        return sqlQuery.list();
//    }
//
//
//    protected <E> List<E> queryForObjects(SqlBuilder<E> sqlBuilder) {
//        return queryForObjects(sqlBuilder.getSelectClass(), sqlBuilder.getQuerySql(), sqlBuilder.getParams());
//    }
//
//
//    public <E> PagedResult<E> queryBySqlPaged(SqlBuilder<E> sqlBuilder) {
//        return pagingBySql(sqlBuilder.getPageIndex(), sqlBuilder.getPageSize(), sqlBuilder.getSelectClass(), sqlBuilder.getQuerySql(), sqlBuilder.getParams());
//    }
//
//
//    protected <E> List<E> queryForObjects(Class<E> clazz, String sql, Map<String, Object> params) {
//        NativeQuery sqlQuery = getSession().createNativeQuery(sql);
//        setParams(sqlQuery, params);
//        addScalar(sqlQuery, clazz);
//        sqlQuery.setResultTransformer(Transformers.aliasToBean(clazz));
//        return sqlQuery.list();
//    }
//
//    protected <E> E queryForObjectFirst(SqlBuilder<E> sqlBuilder) {
//        return queryForObjectFirst(sqlBuilder.getSelectClass(), sqlBuilder.getQuerySql(), sqlBuilder.getParams());
//
//    }
//
//    protected <E> E queryForObjectFirst(Class<E> clazz, String sql, Map<String, Object> params) {
//        NativeQuery sqlQuery = getSession().createNativeQuery(sql);
//        setParams(sqlQuery, params);
//        addScalar(sqlQuery, clazz);
//        sqlQuery.setResultTransformer(Transformers.aliasToBean(clazz));
//        List<E> list = sqlQuery.list();
//        if (list.size() > 0) {
//            return list.get(0);
//        }
//        return null;
//
//    }
//
//    private void setParams(NativeQuery query, Map<String, Object> params) {
//        if (params != null && params.size() > 0) {
//            for (Map.Entry<String, Object> param : params.entrySet()) {
//                if (param.getValue() instanceof Collection)
//                    query.setParameterList(param.getKey(), (Collection) param.getValue());
//                else
//                    query.setParameter(param.getKey(), param.getValue());
//            }
//        }
//    }
//
//
//    public <E> void addScalar(NativeQuery sqlQuery, Class<E> clazz) {
//        Field[] fields = clazz.getDeclaredFields();
//        for (Field field : fields) {
//            if ((field.getType() == long.class) || (field.getType() == Long.class)) {
//                sqlQuery.addScalar(field.getName(), new LongType());
//            } else if ((field.getType() == int.class) || (field.getType() == Integer.class)) {
//                sqlQuery.addScalar(field.getName(), new IntegerType());
//            } else if ((field.getType() == char.class) || (field.getType() == Character.class)) {
//                sqlQuery.addScalar(field.getName(), new CharacterType());
//            } else if (field.getType() == BigDecimal.class) {
//                sqlQuery.addScalar(field.getName(), BigDecimalType.INSTANCE);
//            } else if ((field.getType() == short.class) || (field.getType() == Short.class)) {
//                sqlQuery.addScalar(field.getName(), new ShortType());
//            } else if ((field.getType() == double.class) || (field.getType() == Double.class)) {
//                sqlQuery.addScalar(field.getName(), new DoubleType());
//            } else if ((field.getType() == float.class) || (field.getType() == Float.class)) {
//                sqlQuery.addScalar(field.getName(), new FloatType());
//            } else if ((field.getType() == boolean.class) || (field.getType() == Boolean.class)) {
//                sqlQuery.addScalar(field.getName(), new BooleanType());
//            } else if (field.getType() == String.class) {
//                sqlQuery.addScalar(field.getName(), new StringType());
//            } else if (field.getType() == Date.class) {
//                sqlQuery.addScalar(field.getName(), DateType.INSTANCE);
//            } else if (field.getType() == LocalDate.class) {
//                sqlQuery.addScalar(field.getName(), LocalDateType.INSTANCE);
//            } else if (field.getType() == LocalDateTime.class) {
//                sqlQuery.addScalar(field.getName(), LocalDateTimeType.INSTANCE);
//            } else if (field.getType() == UUID.class) {
//                sqlQuery.addScalar(field.getName(), UUIDCharType.INSTANCE);
//            } else if (field.getType().isEnum()) {
//                Properties params = new Properties();
//                params.put("enumClass", field.getType().getName());
//                params.put("type", "12"); /*type 12 instructs to use the String representation of enum value*/
//                Type myEnumType = new TypeLocatorImpl(new TypeResolver()).custom(EnumType.class, params);
//                sqlQuery.addScalar(field.getName(), myEnumType);
//            }
//        }
//    }
//}
