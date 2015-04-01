package com.example.mysqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by malu on 4/1/15.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {
    public static final int mDataBaseVersion = 1;
    public final String CREATE_TABLE = "create table "+ TableData.TableInfo.TABLE_NAME+"("+ TableData.TableInfo.USER_NAME+" TEXT,"+ TableData.TableInfo.USER_PASS+" TEXT"+");";
    public MySQLiteHelper(Context context) {
        super(context, TableData.TableInfo.DATABASE_NAME, null, mDataBaseVersion);
        Log.d("MySQLiteHelper","create database");
    }

    //onCreate method excuted when new database is created
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertInfo(MySQLiteHelper helper, String user_name,String user_pass){
        SQLiteDatabase db = helper.getWritableDatabase();
        //build a row
        ContentValues cv = new ContentValues();
        cv.put(TableData.TableInfo.USER_NAME,user_name);
        cv.put(TableData.TableInfo.USER_PASS,user_pass);
        //insert a row
        long k = db.insert(TableData.TableInfo.TABLE_NAME,null,cv);
        Log.d("insertInfo", "a row inserted");
    }

    public Cursor queryInfo(MySQLiteHelper helper){
        SQLiteDatabase db = helper.getReadableDatabase();
        String[] columns = {TableData.TableInfo.USER_NAME, TableData.TableInfo.USER_PASS};
        Cursor cursor = db.query(TableData.TableInfo.TABLE_NAME, columns, null, null, null, null, null);
        return cursor;
    }
}
