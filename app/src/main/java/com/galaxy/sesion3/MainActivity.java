package com.galaxy.sesion3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.galaxy.sesion3.dao.UsuariosDAO;
import com.galaxy.sesion3.model.Usuarios;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.version;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.Iv_Facebook) ImageView IvFacebook;
    @BindView(R.id.Et_IngresarUsuario) EditText EtIngresarUsuario;
    @BindView(R.id.Et_IngresarPassword) EditText EtIngresarPassword;
    @BindView(R.id.Et_NIngresarPassword) EditText EtNIngresarPassword;
    @BindView(R.id.Et_ingresarNombres) EditText EtIngresarNombres;
    @BindView(R.id.Et_IngresarApellidos) EditText EtIngresarApellidos;
    @BindView(R.id.Bt_Registrar) Button BtRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        String query = "select sqlite_version() AS sqlite_version";
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(":memory:", null);
        Cursor cursor = db.rawQuery(query, null);
        String sqliteVersion = "";
        if (cursor.moveToNext()) {
            sqliteVersion = cursor.getString(0);
        }
        Log.v("MainActivity","version sqlite = "+sqliteVersion);


        MySQLiteOpenHelper mySQLiteOpenHelper = new MySQLiteOpenHelper(this);
        UsuariosDAO helper = new UsuariosDAO(mySQLiteOpenHelper);

        Usuarios usuario = new Usuarios();

    }

    @OnClick(R.id.Bt_Registrar)
    public void onViewClicked() {
        Toast.makeText(this,R.string.registro, Toast.LENGTH_SHORT).show();
    }
}
