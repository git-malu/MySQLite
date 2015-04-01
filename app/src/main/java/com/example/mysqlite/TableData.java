package com.example.mysqlite;

import android.provider.BaseColumns;

/**
 * Created by malu on 4/1/15.
 */
public class TableData {
    TableData(){}
    public static abstract class TableInfo implements BaseColumns {
        public static final String USER_NAME = "user_name";
        public static final String USER_PASS = "user_pass";
        public static final String DATABASE_NAME = "user_info";
        public static final String TABLE_NAME = "reg_info";

    }
}
