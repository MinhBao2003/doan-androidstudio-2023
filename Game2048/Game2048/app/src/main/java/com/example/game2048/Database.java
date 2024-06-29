package com.example.game2048;

import android.app.admin.DelegatedAdminReceiver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context) {

        super(context, "Database.SQLite", null, 1);
        try{
            SQLiteDatabase database = getWritableDatabase();
            database.execSQL("INSERT INTO Game2048 VALUES('hang1','2','0','0','0','0')");
            database.execSQL("INSERT INTO Game2048 VALUES('hang2','0','0','0','0','0')");
            database.execSQL("INSERT INTO Game2048 VALUES('hang3','0','0','2','0','0')");
            database.execSQL("INSERT INTO Game2048 VALUES('hang4','0','0','0','0','0')");
            database.close();
        }catch (Exception e)
        {
        }
    }
    public Cursor getData(String sql)
    {
        SQLiteDatabase database = getReadableDatabase();
        return  database.rawQuery(sql, null);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS Game2048(hang text primary key, cot1 TEXT, cot2 text,cot3 text,cot4 text,diemcao text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public String getDiemcao2048(Context context)
    {
        Cursor cursor = new Database(context).getData("SELECT *FROM Game2048");
        cursor.move(1);
        return cursor.getString(5);
    }
    public void setDiemcao2048(int diemcao)
    {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL("UPDATE Game2048 SET diemcao ='" +diemcao +"' WHERE hang='hang1'");
        database.close();
    }
    public String getDiemHT2048(Context context)
    {
        Cursor cursor = new Database(context).getData("SELECT *FROM Game2048");
        cursor.move(2);
        return cursor.getString(5);
    }

    public void setDiemHT2048(int diemcao)
    {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL("UPDATE Game2048 SET diemcao ='" +diemcao +"' WHERE hang='hang2'");
        database.close();
    }
    public void setQuatrinh(int matrix[][])
    {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL("UPDATE Game2048 SET cot1 ='" +matrix[1][1] +"' WHERE hang='hang1'");
        database.execSQL("UPDATE Game2048 SET cot2 ='" +matrix[1][2] +"' WHERE hang='hang1'");
        database.execSQL("UPDATE Game2048 SET cot3 ='" +matrix[1][3] +"' WHERE hang='hang1'");
        database.execSQL("UPDATE Game2048 SET cot4 ='" +matrix[1][4] +"' WHERE hang='hang1'");

        database.execSQL("UPDATE Game2048 SET cot1 ='" +matrix[2][1] +"' WHERE hang='hang2'");
        database.execSQL("UPDATE Game2048 SET cot2 ='" +matrix[2][2] +"' WHERE hang='hang2'");
        database.execSQL("UPDATE Game2048 SET cot3 ='" +matrix[2][3] +"' WHERE hang='hang2'");
        database.execSQL("UPDATE Game2048 SET cot4 ='" +matrix[2][4] +"' WHERE hang='hang2'");

        database.execSQL("UPDATE Game2048 SET cot1 ='" +matrix[3][1] +"' WHERE hang='hang3'");
        database.execSQL("UPDATE Game2048 SET cot2 ='" +matrix[3][2] +"' WHERE hang='hang3'");
        database.execSQL("UPDATE Game2048 SET cot3 ='" +matrix[3][3] +"' WHERE hang='hang3'");
        database.execSQL("UPDATE Game2048 SET cot4 ='" +matrix[3][4] +"' WHERE hang='hang3'");

        database.execSQL("UPDATE Game2048 SET cot1 ='" +matrix[4][1] +"' WHERE hang='hang4'");
        database.execSQL("UPDATE Game2048 SET cot2 ='" +matrix[4][2] +"' WHERE hang='hang4'");
        database.execSQL("UPDATE Game2048 SET cot3 ='" +matrix[4][3] +"' WHERE hang='hang4'");
        database.execSQL("UPDATE Game2048 SET cot4 ='" +matrix[4][4] +"' WHERE hang='hang4'");

    }
    public int[][]  getQuatrinh(Context context){
        int a[][]= new int[5][5];
        Cursor cursor = new Database(context).getData("SELECT *FROM Game2048");
        for(int i=1;i<5;i++)
        {
            cursor.moveToPosition(i-1);
            for(int j=1;j<5;j++) a[i][j] = Integer.valueOf(cursor.getString(j));
        }
        return a;
    }
}
