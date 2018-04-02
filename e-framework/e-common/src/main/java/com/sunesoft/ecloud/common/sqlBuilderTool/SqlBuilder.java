package com.sunesoft.ecloud.common.sqlBuilderTool;


import com.sunesoft.ecloud.common.sqlBuilderTool.annotations.AliasName;
import com.sunesoft.ecloud.common.utils.StringUtil;

import java.lang.reflect.ParameterizedType;
import java.util.*;

@SuppressWarnings("unchecked")
public abstract class SqlBuilder<T> {


      //    private Logger logger = LogManager.getLogger(SqlBuilder.class);
    private StringBuilder querySql = new StringBuilder("");
    private StringBuilder whereCondition;
    private StringBuilder groupBy = new StringBuilder("");
    private Map<String, String> selfDefineFeildValue = new HashMap<>();
    private Map<String, String> groupMathField = new HashMap<>();
    private String orderBy = "";
    private Boolean isHaveGroupBy = false;
    private SqlTable mainTable;
    private Class<T> selectClass;

    private StringBuilder selfDefineSelectField = new StringBuilder();

    private String selfWhere = "";
    private Map<String, Map<String, String>> columns = new HashMap<>();

    private Map<String, Object> whereMap = new HashMap<>();

    private Map<String, Object> params = new HashMap<>();

    private Map<String, String> tableNameMap = new HashMap<>();

    private List<String> joins = new ArrayList<>();


    private Integer pageSize = 20;

    private Integer pageIndex = 1;


    public String getQuerySql() {
        return getSql();
    }


    private String getSql() {
        StringBuilder sql = new StringBuilder("select ");
        groupBy = new StringBuilder(" group by ");
        if (selectClass == null && StringUtil.isEmpty(selfDefineSelectField)) {
            try {
                selectClass = (Class<T>) ((ParameterizedType) getClass()
                        .getGenericSuperclass()).getActualTypeArguments()[0];
            } catch (Exception ex) {
                throw new RuntimeException("Select class can not be null!!");
            }
        }
        if (!StringUtil.isEmpty(selfDefineSelectField.toString())) {
            sql.append(selfDefineSelectField);
        } else {
            Map<String, String> propertiesMap = SqlBuilderHelper.getSimplePropertieNames(selectClass);
            Set<String> properties = propertiesMap.keySet();
            StringBuilder cols = new StringBuilder();
            for (String property : properties) {
                String clname = property;
                String n = "";
                if (!StringUtil.isEmpty(selfDefineFeildValue.get(clname))) {
                    cols.append(selfDefineFeildValue.get(clname))
                            .append(" ")
                            .append(clname)
                            .append(",");
                    this.setGroupField(selfDefineFeildValue.get(clname));
                    continue;
                }
                if (!StringUtil.isEmpty(groupMathField.get(clname))) {
                    cols.append(groupMathField.get(clname))
                            .append(" ")
                            .append(clname)
                            .append(",");
                    continue;
                }
                String tname = getFeildTableName(clname);
                if (!StringUtil.isEmpty(tname)) {
                    n = tableNameMap.get(tname) + "." + clname;
                    cols.append(tableNameMap.get(tname))
                            .append(".")
                            .append(clname);
                    if (!property.equals(propertiesMap.get(property))) {
                        cols.append(" ");
                        cols.append(propertiesMap.get(property));
                    }
                    cols.append(",");

                } else {
                    if(property.equals("FieldWithoutCheck")){
                        cols.append(propertiesMap.get(property));
                        cols.append(",");
                        n = clname;

                    }else
                    if (!property.equals(propertiesMap.get(property))) {
                        cols.append(clname);
                        cols.append(" ");
                        cols.append(propertiesMap.get(property));
                        cols.append(",");
                        n = clname;
                    }  else {
                        cols.append(" null ");
                        cols.append(clname).append(",");
                        n = clname;
                    }
                }
                this.setGroupField(n);
            }

            sql.append(cols.substring(0, cols.length() - 1));
        }
        sql.append(querySql);
        if (joins.size() > 0) {
            for (String join : joins) {
                sql.append(join);
            }
        }
        sql.append(where());

        if (isHaveGroupBy) {
            sql.append(" ").append(groupBy);
        }
        sql.append(orderBy);
//        logger.info(sql);
        return sql.toString();

    }

    public String getPageSql(int pageIndex, int pageSize) {
        String sql = this.getSql();
        return getPageSql(sql, pageIndex, pageSize);
    }

    public String getPageSql(String sql, int pageIndex, int pageSize) {
        sql += " limit " + (pageIndex - 1) * pageSize + "," + pageSize;
        return sql;
    }


    private void setGroupField(String filedName) {

        if (groupMathField.get(filedName) == null) {
            if (groupBy.toString().trim().equals("group by")) {
                groupBy.append(filedName);
            } else {
                groupBy.append(",").append(filedName);
            }
        }
    }

    /**
     * 修改查询语句的字段  直接使用别名替换
     *
     * @param filedName
     * @param aliseName
     * @return
     */
    public SqlBuilder setFieldValue(String filedName, String aliseName) {
        this.selfDefineFeildValue.put(filedName, aliseName);
        return this;
    }

    private String where() {
        whereCondition = new StringBuilder("");
        whereCondition.append(" where ")
                .append(mainTable.getAliseName())
                .append(".")
                .append("is_active=1 ");
        for (String str : whereMap.keySet()) {
            String field = str.trim();
            if (str.indexOf(".") > 0) {
                whereCondition.append(" and ")
                        .append(str);
                field = str.replace(".", "").trim();


            } else {
                String tableName = getFeildTableName(str);
                if (!StringUtil.isEmpty(tableName)) {
                    whereCondition.append(" and ")
                            .append(tableNameMap.get(tableName))
                            .append(".")
                            .append(str);
                } else {
                    whereCondition.append(" and ")
                            .append("$$")
                            .append(str);
                }
            }
            Object wobj = whereMap.get(str);
            if (wobj instanceof Collection) {
                whereCondition.append(" in ( ")
                        .append(":")
                        .append(field)
                        .append(")");
            } else if (wobj instanceof String) {
                if (wobj.toString().indexOf("%") >= 0) {
                    whereCondition.append(" like ")
                            .append(":")
                            .append(field);
                } else {
                    whereCondition.append(" =")
                            .append(":")
                            .append(field);
                }
            } else {
                whereCondition.append(" =")
                        .append(":")
                        .append(field);
            }
            if (wobj instanceof UUID) {
                params.put(field, wobj.toString());
            } else if (wobj.getClass().isEnum()) {
                params.put(field, wobj.toString());
            } else {
                params.put(field, wobj);
            }
        }
        if (!StringUtil.isEmpty(selfWhere)) {
            whereCondition.append(" ").append(selfWhere);
        }
        return whereCondition.toString();
    }

    public String getFeildTableName(String field) {
        String table = "";
        Map<String, String> tableColumns = columns.get(mainTable.getTableName());
        if (tableColumns.get(field) != null) {
            table = mainTable.getTableName();
        } else {
            for (String tableName : columns.keySet()) {
                if (columns.get(tableName).get(field) != null) {
                    table = tableName;
                    break;
                }
            }
        }
        return table;
    }


    public Map<String, Object> getParams() {
        return params;
    }

    @Deprecated
    public SqlBuilder from(Class<?> tClass) {
        String tableName = getTable(tClass);
        mainTable = new SqlTable(tableName, tableName);
        tableNameMap.put(tableName, tableName);
        querySql.append(" from ");
        querySql.append(mainTable.getTableName());
        querySql.append(" ");
        querySql.append(tableName);
        querySql.append(" ");
        this.getColumn(tClass, tableName);
        return this;
    }

    @SuppressWarnings("unchecked")
    public SqlBuilder from(Class<?> tClass, String aliseName) {
        String tableName = getTable(tClass);
        mainTable = new SqlTable(tableName, aliseName);
        tableNameMap.put(tableName, aliseName);
        querySql.append(" from ");
        querySql.append(mainTable.getTableName());
        querySql.append(" ");
        querySql.append(aliseName);
        querySql.append(" ");
        this.getColumn(tClass, tableName);
        return this;
    }

    private void getColumn(Class<?> clazz, String tableName) {
        Map<String, String> properties = SqlBuilderHelper.getSimplePropertieNames(clazz);
        Map<String, String> cm = new HashMap<>();
        for (String clname : properties.keySet()) {
            if (columns.get(clname) == null) {
                cm.put(clname, properties.get(clname));
            }
        }
        if (columns.get(tableName) == null) {
            columns.put(tableName, cm);
        }
    }

    public String getTable(Class<?> clazz) {
        String tableName = clazz.getSimpleName();
        AliasName annotation = (AliasName) clazz.getAnnotation(AliasName.class);
        if (annotation != null) {
            tableName = annotation.value();
        }
        return tableName;
    }

    public SqlBuilder where(Map<String, Object> mapCondition) {
        whereMap.putAll(mapCondition);
        return this;
    }

    public SqlBuilder where(String key, Object valus) {
        this.whereMap.put(key, valus);
        return this;
    }

    public SqlBuilder where(String where) {
        this.selfWhere = " and " + where;
        return this;
    }

    public SqlBuilder and(String where) {
        this.selfWhere = " and " + where;
        return this;
    }

    public SqlBuilder and(String key, Object valus) {
        this.whereMap.put(key, valus);
        return this;
    }

    public SqlBuilder select(Class<T> tClass) {
        this.selectClass = tClass;
        return this;
    }


    public Join join(Class<?> clazz, String aliseName) {
        String tablename = getTable(clazz);
        SqlTable table = new SqlTable(tablename, aliseName);
        tableNameMap.put(tablename, aliseName);
        whereMap.put(aliseName + "." + "is_active", 1);
        this.getColumn(clazz, tablename);
        Join join = new Join(this, table);
        return join;
    }

    public Join leftJoin(Class<?> clazz, String aliseName) {
        String tablename = getTable(clazz);
        tableNameMap.put(tablename, aliseName);
        SqlTable table = new SqlTable(tablename, aliseName);
        this.getColumn(clazz, tablename);
        Join join = new Join(this, table, JoinType.LeftJoin);
        return join;
    }

    public SqlBuilder orderBy(String order, OrderType orderType) {
        String orderStr = order;
        if (order.indexOf(".") < 0) {
            String feildTableName = getFeildTableName(order);
            if (!StringUtil.isEmpty(feildTableName)) {
                orderStr = tableNameMap.get(feildTableName) + "." + order;
            }
        }
        if (StringUtil.isEmpty(orderBy)) {
            this.orderBy = " order by " + orderStr + " " + orderType.toString();
        } else {
            this.orderBy += "," + orderStr + " " + orderType.toString();
        }
        return this;
    }

    public SqlBuilder groupByMathField(String dtoField, String extension) {
        this.isHaveGroupBy = true;
        Map<String, String> map = new HashMap<>();
        map.put(dtoField, extension);
        this.setGroupMapStr(map);
        return this;
    }


    public SqlBuilder selectField(String sumField, String aliseName) {
        if (!StringUtil.isEmpty(selfDefineSelectField.toString())) {
            selfDefineSelectField
                    .append(",")
                    .append(sumField)
                    .append(" ")
                    .append(aliseName);

        } else {
            selfDefineSelectField
                    .append(sumField)
                    .append(" ")
                    .append(aliseName);
        }
        return this;
    }

    public void setGroupMapStr(Map<String, String> map) {
        this.groupMathField.putAll(map);
    }


    public String countSql() {
        String sql = getQuerySql();
        String countSql = sql.substring(0, sql.toLowerCase().indexOf("from "));
        if (null == countSql || countSql.trim().equals("")) {
            countSql = "select count(*) " + sql;
        } else {
            countSql = sql.replace(countSql, "select count(*) ");
        }
        if (countSql.toLowerCase().contains(" order ")) {
            countSql = countSql.substring(0, countSql.toLowerCase().indexOf("order"));
        }
        return countSql;//(int) DatabaseExecuter.queryNumber(getQuerySql(), whereMap);
    }

    public void addJoinStr(String joinStr) {
        joins.add(joinStr);
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public SqlBuilder pagging(Integer pageIndex, Integer pageSize) {
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
        return this;
    }

    public Class<T> getSelectClass() {
        return selectClass;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }


}
