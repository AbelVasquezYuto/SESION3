package com.galaxy.sesion3;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.galaxy.sesion3.model.Usuarios;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String TAG = "mYSQLiteOpenHelper";

    public static final String NOMBRE_DB = "mydb.db";
    public static final Integer VERSION_DB = 1;

    private static StringBuilder sbCreateTableProductoSQL = new StringBuilder()
            .append("CREATE TABLE"+ Usuarios.TABLE_NAME+"{")
            .append(Usuarios.USUARIO_FIELD+"TEXT PRIMARY KEY, ")
            .append(Usuarios.PASSWORD_FIELD+"TEXT, ")
            .append(Usuarios.NPASSWORD_FIELD+"TEXT, ")
            .append(Usuarios.NOMBRES_FIELD+"TEXT, ")
            .append(Usuarios.APELLIDOS_FIELD+"TEXT } ");

    public MySQLiteOpenHelper(Context context) {
        super(context, NOMBRE_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(TAG,"onCreate(database)");
        sqLiteDatabase.execSQL(sbCreateTableProductoSQL.toString());


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
