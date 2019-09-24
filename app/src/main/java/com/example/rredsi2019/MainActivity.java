package com.example.rredsi2019;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void buscar(View view) {
        Intent intent = new Intent(this, Panel_Consulta.class);
        startActivity(intent);

    }

    public void iniciar_google(View view) {
    }
}
