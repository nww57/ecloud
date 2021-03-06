package com.sunesoft.ecloud.hibernate.sqlExcute;

import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.sqlBuilderTool.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author: Zhouzh
 * @Date: 2018/3/22
 */
public class GenericQuery {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    public <E> PagedResult<E> queryPaged(Integer pageIndex,Integer pegeSize, String sql, Map<String, Object> params, Class<E> clazz) {
        String pageSql = sql + " limit " + pageIndex * pegeSize + "," + pegeSize;
        List<E> result = namedJdbcTemplate.query(pageSql, params, new GenericListExtractor<List<E>>(clazz));
        int total = queryCount(sql, params);
        PagedResult<E> page = new PagedResult<E>(result, pageIndex,pegeSize, total);
        return page;
    }

    public <E> PagedResult<E> queryPaged(SqlBuilder<E> sqlBuilder) {
        //todo  sort  处理
        return queryPaged( sqlBuilder.getPageIndex(), sqlBuilder.getPageSize(), sqlBuilder.getQuerySql(), sqlBuilder.getParams(), sqlBuilder.getSelectClass());
    }

    public int queryCount(String sql, Map<String, Object> params) {
        String countSql = "";
        if (sql.toLowerCase().contains(" order ")) {
            sql = sql.substring(0, sql.toLowerCase().indexOf(" order "));
        }
        if (!sql.toLowerCase().contains(" group ")) {
            countSql = sql.substring(0, sql.toLowerCase().indexOf(" from "));
            if (null == countSql || countSql.trim().equals("")) {
                countSql = "select count(*) " + sql;
            } else {
                countSql = sql.replace(countSql, "select count(*) ");
            }
        } else {
            countSql = "select count(*) from (" + sql + ") t";
        }
        return this.namedJdbcTemplate.queryForObject(countSql.toString(), params, Integer.class);
    }

    private int queryCount(SqlBuilder sqlBuilder) {
        return queryCount(sqlBuilder.getQuerySql(), sqlBuilder.getParams());
    }

    public Boolean isExist(String sql, Map<String, Object> params) {
        return queryCount(sql, params) > 0;
    }

    public Boolean isExist(SqlBuilder sqlBuilder) {
        return queryCount(sqlBuilder) > 0;
    }

    public double getSumBySql(SqlBuilder sqlBuilder) {
        return getSumBySql(sqlBuilder.getQuerySql(), sqlBuilder.getParams());
    }


    public double getSumBySql(String sql, Map<String, Object> params) {
        return this.namedJdbcTemplate.queryForObject(sql.toString(), params, Double.class);
    }


    public List<Map<String, Object>> queryListMap(SqlBuilder sqlBuilder) {
        return queryListMap(sqlBuilder.getQuerySql(), sqlBuilder.getParams());
    }

    protected List<Map<String, Object>> queryListMap(String sql, Map<String, Object> params) {
        return namedJdbcTemplate.queryForList(sql, params);
    }


    public <E> List<E> queryList(String sql, Map<String, Object> params, Class<E> clazz) {
        return namedJdbcTemplate.query(sql, params, new GenericListExtractor<List<E>>(clazz));
    }


    protected <E> List<E> queryList(SqlBuilder<E> sqlBuilder) {
        return queryList(sqlBuilder.getQuerySql(), sqlBuilder.getParams(), sqlBuilder.getSelectClass());
    }


    protected <E> E queryForObject(SqlBuilder<E> sqlBuilder) {
        return queryForObject(sqlBuilder.getQuerySql(), sqlBuilder.getParams(), sqlBuilder.getSelectClass());

    }

    protected <E> E queryForObject(String sql, Map<String, Object> params, Class<E> clazz) {
        List<E> list = queryList(sql, params, clazz);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public NamedParameterJdbcTemplate getNamedJdbcTemplate() {
        return namedJdbcTemplate;
    }

    public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
        this.namedJdbcTemplate = namedJdbcTemplate;
    }
}
