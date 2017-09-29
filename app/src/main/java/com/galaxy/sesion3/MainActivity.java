package com.galaxy.sesion3;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.galaxy.sesion3.dao.UsuariosDAO;
import com.galaxy.sesion3.model.UsuariosModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static  final String TAG = "MainActivity";

    @BindView(R.id.Et_IngresarUsuario)
    EditText EtIngresarUsuario;
    @BindView(R.id.Et_IngresarPassword)
    EditText EtIngresarPassword;
    @BindView(R.id.Et_IngresarCorreo)
    EditText EtIngresarCorreo;
    @BindView(R.id.Et_ingresarNombres)
    EditText EtIngresarNombres;
    @BindView(R.id.Et_IngresarApellidos)
    EditText EtIngresarApellidos;
    @BindView(R.id.Iv_Imagen)
    ImageView IvImagen;
    @BindView(R.id.Bt_Registrar)
    Button BtRegistrar;

    private UsuariosDAO usuariosDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        usuariosDAO = new UsuariosDAO(this);

        String query = "select sqlite_version() AS sqlite_version";
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(":memory:", null);
        Cursor cursor = db.rawQuery(query, null);
        String sqliteVersion = "";
        if (cursor.moveToNext()) {
            sqliteVersion = cursor.getString(0);
        }
        Log.v("MainActivity", "version sqlite = " + sqliteVersion);

    }

    @OnClick({R.id.Iv_Imagen, R.id.Bt_Registrar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Iv_Imagen:
                Toast.makeText(this,R.string.mensaje_imagen, Toast.LENGTH_SHORT).show();
                break;
            case R.id.Bt_Registrar:

                String usuario = EtIngresarUsuario.getText().toString();
                String password = EtIngresarPassword.getText().toString();
                String correo = EtIngresarCorreo.getText().toString();
                String nombre = EtIngresarNombres.getText().toString();
                String apellidos = EtIngresarApellidos.getText().toString();

                UsuariosModel usuariosModel = new UsuariosModel();

                usuariosModel.setUsuario(usuario);
                usuariosModel.setPassword(password);
                usuariosModel.setCorreo(correo);
                usuariosModel.setNombres(nombre);
                usuariosModel.setApellidos(apellidos);

                long result = usuariosDAO.insertarUsuario(usuariosModel);

                if (result!=-1){
                    Toast.makeText(this,R.string.registro, Toast.LENGTH_SHORT).show();
                    List<UsuariosModel> usuariosModels = usuariosDAO.obtenerUsuarios();
                    for (UsuariosModel e:usuariosModels){
                        Log.i(TAG,e.toString());
                    }

                    Intent intent = new Intent(MainActivity.this,listaUsuarios.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(this, "Ocurrió un problema al registrar", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
