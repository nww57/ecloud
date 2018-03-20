package com.sunesoft.ecloud.common.sqlBuilderTool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Zhouzh
 * @Date: 2017/11/26
 */
public class GroupBy {

    private Map<String, Map<String, String>> groupBy = new HashMap<>();

    private  List<String> groupMathFields = new ArrayList<>();

    private SqlBuilder sqlBuilder;

    private String currentField;

    public GroupBy(SqlBuilder sqlBuilder) {
        this.sqlBuilder = sqlBuilder;
    }


    public GroupBy groupField(String field){
        currentField=field;
        return this;
    }

    public SqlBuilder groupByMathField(String dbField,GroupMath mathField){
        groupMathFields.add(dbField);
        String extension = dbField;
        if(mathField!=null) {
            switch (mathField) {
                case Count:
                    extension = " count(*) ";
                    break;
                case Sum:
                    extension = " sum(" + dbField + ") ";
                    break;
                case Max:
                    extension = " max(" + dbField + ") ";
                    break;
                case Min:
                    extension = " min(" + dbField + ") ";
                    break;
                case Avg:
                    extension = " avg(" + dbField + ") ";
                    break;
                default:
                    break;
            }
        }
        Map<String,String> map = new HashMap<>();
        map.put(currentField,extension);
        sqlBuilder.setGroupMapStr(map);
        return sqlBuilder;
    }




}
