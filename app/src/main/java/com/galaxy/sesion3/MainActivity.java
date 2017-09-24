package com.galaxy.sesion3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    /*private EditText mEt_IngresarUsuario;
    private EditText mEt_IngresarPassword;
    private EditText mEt_NIngresarPassword;
    private EditText mEt_IngresarNombres;
    private EditText mEt_IngresarApellidos;
    private Button mBt_Registrar;*/

    @BindView(R.id.Et_IngresarUsuario) EditText mEt_IngresarUsuario;
    @BindView(R.id.Et_IngresarPassword) EditText mEt_IngresarPassword;
    @BindView(R.id.Et_NIngresarPassword) EditText mEt_NIngresarPassword;
    @BindView(R.id.Et_ingresarNombres) EditText mEt_IngresarNombres;
    @BindView(R.id.Et_IngresarApellidos) EditText mEt_IngresarApellidos;
    @BindView(R.id.Bt_Registrar) Button mBt_Registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Paso 1
        ButterKnife.bind(this);

        /*mEt_IngresarUsuario = (EditText) findViewById(R.id.Et_IngresarUsuario);
        mEt_IngresarPassword = (EditText) findViewById(R.id.Et_IngresarPassword);
        mEt_NIngresarPassword = (EditText) findViewById(R.id.Et_NIngresarPassword);
        mEt_IngresarNombres = (EditText) findViewById(R.id.Et_ingresarNombres);
        mEt_IngresarApellidos = (EditText) findViewById(R.id.Et_IngresarApellidos);
        mBt_Registrar = (Button) findViewById(R.id.Bt_Registrar);

        mBt_Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, R.string.registro, Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    //Paso 3
    @OnClick(R.id.Bt_Registrar) public void onButtonClick(){
        Toast.makeText(this,R.string.registro, Toast.LENGTH_SHORT).show();
    }
}
