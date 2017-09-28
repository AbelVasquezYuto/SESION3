package com.galaxy.sesion3;

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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

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
        Log.v("MainActivity", "version sqlite = " + sqliteVersion);

    }

    @OnClick({R.id.Iv_Imagen, R.id.Bt_Registrar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Iv_Imagen:
                Toast.makeText(this, "!Registrese Ahora!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Bt_Registrar:
                Toast.makeText(this, "Se resgistro con exito :v", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
