package com.example.myflags;
import android.database.Cursor;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Mabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="flag";
    private static  final  int DATABASE_VERSION=1;
    private  static  final String ID="id";
    private  static  final String TABLE_NAME="utilisateurs";
    private  static  final String NUMERO="numero";
    private  static  final String FILIERE="filiere";
    private  static  final String NIVO="niveau";
    private  static  final String LANGUE="langue";

    public Mabase(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String cretable="CREATE TABLE"+TABLE_NAME+"("+ID+"INTEGER PRIMARY KEY AUTOINCREMENT,"+NUMERO+"TEXT,"+FILIERE+"TEXT,"+NIVO+"TEXT,"+LANGUE+"TEXT"+")";
        db.execSQL(cretable);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion){
        String dropTableQuerry="DROP TABLE IF EXISTS users";
        db.execSQL((dropTableQuerry));
        onCreate(db);
    }
    public boolean isUser(String numeros,String filiere,String nivo,String langue){
        SQLiteDatabase db=this.getReadableDatabase();
        String[] colums ={NUMERO,FILIERE,NUMERO,LANGUE};
    String selection=NUMERO+"=? AND"+FILIERE+"=? AND"+NIVO+"=? AND"+LANGUE+"=?";
    String[] selectionArgs={numeros,filiere,nivo,langue};
    Cursor cursor=db.query(TABLE_NAME,colums,selection,selectionArgs,null,null,null);
    int count= cursor.getCount();
    cursor.close();
    db.close();
    return count>0;
    }
}
