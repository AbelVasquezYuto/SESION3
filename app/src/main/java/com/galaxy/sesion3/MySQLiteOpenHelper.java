package com.galaxy.sesion3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.galaxy.sesion3.model.UsuariosModel;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String TAG = "mYSQLiteOpenHelper";

    public static final String NOMBRE_DB = "mydb.db";
    public static final Integer VERSION_DB = 1;

    private static StringBuilder sbCreateTableProductoSQL = new StringBuilder()
            .append("CREATE TABLE "+ UsuariosModel.TABLE_NAME+"(")
            .append(UsuariosModel.USUARIO_FIELD+" TEXT PRIMARY KEY,")
            .append(UsuariosModel.PASSWORD_FIELD+" TEXT,")
            .append(UsuariosModel.CORREO_FIELD+" TEXT,")
            .append(UsuariosModel.NOMBRES_FIELD+" TEXT,")
            .append(UsuariosModel.APELLIDOS_FIELD+" TEXT) ");

    public MySQLiteOpenHelper(Context context) {
        super(context, NOMBRE_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(TAG,"onCreate(database)");
        sqLiteDatabase.execSQL(sbCreateTableProductoSQL.toString());
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
