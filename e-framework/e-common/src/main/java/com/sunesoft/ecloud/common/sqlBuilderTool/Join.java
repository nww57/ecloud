package com.sunesoft.ecloud.common.sqlBuilderTool;

public class Join {

    private SqlTable sqlTable;

    private JoinType joinType= JoinType.InnerJoin;

    private SqlBuilder sqlBuilder;


    Join(SqlBuilder sqlBuilder, SqlTable sqlTable){

        this.sqlBuilder = sqlBuilder;
        this.sqlTable = sqlTable;
    }
    Join(SqlBuilder sqlBuilder, SqlTable sqlTable, JoinType joinType){
        this.sqlBuilder = sqlBuilder;
        this.sqlTable = sqlTable;
        this.joinType = joinType;
    }



    public SqlBuilder on(String onCondition){

        StringBuilder builder = new StringBuilder();
        if(joinType==JoinType.LeftJoin){
            builder.append(" left ");
        }
        builder.append(" join ");
        builder.append(sqlTable.getTableName());
        builder.append(" ");
        builder.append(sqlTable.getAliseName());
        builder.append(" on ");
        builder.append(onCondition);
        builder.append(" ");

        sqlBuilder.addJoinStr(builder.toString());
        return sqlBuilder;
    }



    public void setSqlBuilder(SqlBuilder sqlBuilder) {
        this.sqlBuilder = sqlBuilder;
    }


}
