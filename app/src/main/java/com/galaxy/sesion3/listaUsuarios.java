package com.galaxy.sesion3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class listaUsuarios extends AppCompatActivity {

    @BindView(R.id.Tv_anterior)
    TextView TvAnterior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.Tv_anterior)
    public void onViewClicked() {
        Intent intent = new Intent(listaUsuarios.this,MainActivity.class);
        startActivity(intent);
    }
}
