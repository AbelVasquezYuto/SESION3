package com.galaxy.sesion3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    }

    @OnClick(R.id.Bt_Registrar)
    public void onViewClicked() {
        Toast.makeText(this,R.string.registro, Toast.LENGTH_SHORT).show();
    }
}
