package com.sunesoft.ecloud.common.sqlBuilderTool;

public class SqlTable {
        private String tableName;

        private String aliseName;

        public SqlTable(String tname,String aName){
            this.tableName = tname;
            this.aliseName = aName;
        }

        private String joinColumn;

        public String getTableName() {
            return tableName;
        }

        public void setTableName(String tableName) {
            this.tableName = tableName;
        }

        public String getAliseName() {
            return aliseName;
        }

        public void setAliseName(String aliseName) {
            this.aliseName = aliseName;
        }
    }