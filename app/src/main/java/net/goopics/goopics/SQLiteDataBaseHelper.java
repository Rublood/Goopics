package net.goopics.goopics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Rublood on 14/03/2018.
 */

public class SQLiteDataBaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "data.db";
    public static final String TABLE_NAME = "data";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "URL";
    public static final String COL_3 = "LAT";
    public static final String COL_4 = "LONGI";

    public SQLiteDataBaseHelper(Context context) {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE table "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,URL TEXT,LAT FLOAT,LONGI FLOAT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE "+TABLE_NAME);
        onCreate(db);
    }
    public Boolean insertdata(String url,double lat,double longi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,url);
        contentValues.put(COL_3,lat);
        contentValues.put(COL_4,longi);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
    public ArrayList<String> getallurl(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor  result=db.rawQuery("select * from "+TABLE_NAME,null);
        ArrayList<String> mArrayList = new ArrayList<String>();
        result.moveToFirst();
        while(!result.isAfterLast()) {
            mArrayList.add(result.getString(1));
            result.moveToNext();
        }
        result.close();
        return mArrayList;
    }
    public ArrayList<Double> getalllat(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor  result=db.rawQuery("select * from "+TABLE_NAME,null);
        ArrayList<Double> mArrayList = new ArrayList<Double>();
        result.moveToFirst();
        while(!result.isAfterLast()) {
            mArrayList.add(result.getDouble(2));
            result.moveToNext();
        }
        result.close();
        return mArrayList;
    }
    public ArrayList<Double> getalllongi(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor  result=db.rawQuery("select * from "+TABLE_NAME,null);
        ArrayList<Double> mArrayList = new ArrayList<Double>();
        result.moveToFirst();
        while(!result.isAfterLast()) {
            mArrayList.add(result.getDouble(3));
            result.moveToNext();
        }
        result.close();
        return mArrayList;
    }
}
