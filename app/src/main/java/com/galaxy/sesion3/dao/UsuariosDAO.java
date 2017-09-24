package com.galaxy.sesion3.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.galaxy.sesion3.MySQLiteOpenHelper;
import com.galaxy.sesion3.model.Usuarios;

import java.util.List;

public class UsuariosDAO {

    private MySQLiteOpenHelper sqLiteOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    public UsuariosDAO(MySQLiteOpenHelper sqLiteOpenHelper){
        this.sqLiteOpenHelper=sqLiteOpenHelper;
        this.sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public long insertarUsuario(Usuarios usuarios){

        ContentValues valoresInsertar = new ContentValues();
        valoresInsertar.put(Usuarios.USUARIO_FIELD,usuarios.getUsuario());
        valoresInsertar.put(Usuarios.PASSWORD_FIELD,usuarios.getPassword());
        valoresInsertar.put(Usuarios.NPASSWORD_FIELD,usuarios.getNpassword());
        valoresInsertar.put(Usuarios.NOMBRES_FIELD,usuarios.getNombres());
        valoresInsertar.put(Usuarios.APELLIDOS_FIELD,usuarios.getApellidos());

        long result = sqLiteDatabase.insert(Usuarios.TABLE_NAME,null,valoresInsertar);

        return result;
    }

    public int actualizarUsuario(Usuarios usuarios){

        ContentValues valores = new ContentValues();
        valores.put(Usuarios.PASSWORD_FIELD,usuarios.getPassword());
        valores.put(Usuarios.NPASSWORD_FIELD,usuarios.getNpassword());
        valores.put(Usuarios.NOMBRES_FIELD,usuarios.getNombres());
        valores.put(Usuarios.APELLIDOS_FIELD,usuarios.getApellidos());

        String whereClause = Usuarios.USUARIO_FIELD+"=?";
        String [] whereArgs = {usuarios.getUsuario()};

        //retorna la cantidad de filas actualizadas
        //retorna 0 si no actualizo nada
        int result = sqLiteDatabase.update(Usuarios.TABLE_NAME,valores,whereClause,whereArgs);

        return result;
    }

    public int eliminarUsuario(Usuarios usuarios){

        ContentValues valoresEliminar = new ContentValues();
        valoresEliminar.put(Usuarios.PASSWORD_FIELD,usuarios.getPassword());
        valoresEliminar.put(Usuarios.NPASSWORD_FIELD,usuarios.getNpassword());
        valoresEliminar.put(Usuarios.NOMBRES_FIELD,usuarios.getNombres());
        valoresEliminar.put(Usuarios.APELLIDOS_FIELD,usuarios.getApellidos());

        String whereClause = Usuarios.USUARIO_FIELD+"=?";
        String [] whereArgs = {usuarios.getUsuario()};

        int result = sqLiteDatabase.delete(Usuarios.TABLE_NAME,whereClause,whereArgs);

        //retorna la cantidad de filas eliminadas
        //retorna 0 si no elimino nada
        return result;
    }

    public List<Usuarios> obtenerUsuarios(){

        String[] fields = {};

        return null;
    }
}
