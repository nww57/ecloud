package com.sunesoft.ecloud.common.sqlBuilderTool;

/**
 * @author: Zhouzh
 * @Date: 2017/11/26
 */
public class GroupByMath {


        public static String Count() {
            return  math("",GroupMath.Count);
        }


        public static String Sum(String dbField){
            return  math(dbField,GroupMath.Sum);
        }


        public static String Max(String dbField) {
            return  math(dbField,GroupMath.Max);
        }


        public static String Min(String dbField) {
            return  math(dbField,GroupMath.Min);
        }


        public static String Avg(String dbField) {

            return  math(dbField,GroupMath.Avg);
        }

        private static String math(String dbField,GroupMath mathField) {
            String extension = dbField;
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
            return extension;
        }



}
