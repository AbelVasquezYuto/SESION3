package com.galaxy.sesion3.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.galaxy.sesion3.MySQLiteOpenHelper;
import com.galaxy.sesion3.model.UsuariosModel;

import java.util.ArrayList;
import java.util.List;

public class UsuariosDAO {

    private MySQLiteOpenHelper sqLiteOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    public UsuariosDAO(Context context){
        this.sqLiteOpenHelper=new MySQLiteOpenHelper(context);
        this.sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public long insertarUsuario(UsuariosModel usuariosModel){

        ContentValues valoresInsertar = new ContentValues();
        valoresInsertar.put(UsuariosModel.USUARIO_FIELD, usuariosModel.getUsuario());
        valoresInsertar.put(UsuariosModel.PASSWORD_FIELD, usuariosModel.getPassword());
        valoresInsertar.put(UsuariosModel.CORREO_FIELD, usuariosModel.getCorreo());
        valoresInsertar.put(UsuariosModel.NOMBRES_FIELD, usuariosModel.getNombres());
        valoresInsertar.put(UsuariosModel.APELLIDOS_FIELD, usuariosModel.getApellidos());

        long result = sqLiteDatabase.insert(UsuariosModel.TABLE_NAME,null,valoresInsertar);

        return result;
    }

    public int actualizarUsuario(UsuariosModel usuariosModel){

        ContentValues valores = new ContentValues();
        valores.put(UsuariosModel.PASSWORD_FIELD, usuariosModel.getPassword());
        valores.put(UsuariosModel.CORREO_FIELD, usuariosModel.getCorreo());
        valores.put(UsuariosModel.NOMBRES_FIELD, usuariosModel.getNombres());
        valores.put(UsuariosModel.APELLIDOS_FIELD, usuariosModel.getApellidos());

        String whereClause = UsuariosModel.USUARIO_FIELD+"=?";
        String [] whereArgs = {usuariosModel.getUsuario()};

        //retorna la cantidad de filas actualizadas
        //retorna 0 si no actualizo nada
        int resultado = sqLiteDatabase.update(UsuariosModel.TABLE_NAME,valores,whereClause,whereArgs);

        return resultado;
    }

    public int eliminarUsuario(String usuario){

        String whereClause = UsuariosModel.USUARIO_FIELD+"=?";
        String [] whereArgs = {usuario};

        int result = sqLiteDatabase.delete(UsuariosModel.TABLE_NAME,whereClause,whereArgs);

        //retorna la cantidad de filas eliminadas
        //retorna 0 si no elimino nada
        return result;
    }

    public List<UsuariosModel> obtenerUsuarios(){

        String[] fields = {
                UsuariosModel.USUARIO_FIELD,
                UsuariosModel.PASSWORD_FIELD,
                UsuariosModel.CORREO_FIELD,
                UsuariosModel.NOMBRES_FIELD,
                UsuariosModel.APELLIDOS_FIELD
        };

        Cursor cursor = sqLiteDatabase.query(UsuariosModel.TABLE_NAME,fields,null,null,null,null,null);

        return convertCursorToList(cursor);
    }

    private List<UsuariosModel> convertCursorToList(Cursor cursor){

        //creando un item de producto vacio
        List<UsuariosModel> arrList = new ArrayList<>();

        //recorriendo el cursor
        if(cursor.moveToFirst()){
            do{
                //creando un item de usuario vacio
                UsuariosModel model = new UsuariosModel();

                //añadiendo valor a los campos del item de producto
                model.setUsuario(cursor.getString(cursor.getColumnIndex(UsuariosModel.USUARIO_FIELD)));
                model.setPassword(cursor.getString(cursor.getColumnIndex(UsuariosModel.PASSWORD_FIELD)));
                model.setCorreo(cursor.getString(cursor.getColumnIndex(UsuariosModel.CORREO_FIELD)));
                model.setNombres(cursor.getString(cursor.getColumnIndex(UsuariosModel.NOMBRES_FIELD)));
                model.setApellidos(cursor.getString(cursor.getColumnIndex(UsuariosModel.APELLIDOS_FIELD)));

                //agregando el item de producto a la coleccion
                arrList.add(model);
            }while(cursor.moveToNext());
        }

        //retornando la coleccion de productos
        return arrList;
    }

}
