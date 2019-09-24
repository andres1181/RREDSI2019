package com.example.rredsi2019;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.rredsi2019.R.*;

public class Lista_Datos extends AppCompatActivity {

    private TextView horaT;
    private  TextView ubiT;
    private  TextView tituloT;
    private  TextView semT;
    private  TextView iesT;
 //   String valorHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_lista__datos);

        horaT = findViewById(id.view_hora);
        ubiT = findViewById(id.view_ubi);
        tituloT = findViewById(id.view_titulo);
        semT = findViewById(id.view_semillero);
        iesT = findViewById(id.view_ies);

        mostrarDatos();
    }



    public void mostrarDatos(){
        Bundle extras= getIntent().getExtras();
        String valorHora = extras.getString("hora");
        System.out.println("Valor Hora:" + valorHora);
        horaT.setText(valorHora);

        String valorTitulo = extras.getString("titulo");
        System.out.println("Valor titulo:" + valorTitulo);
        tituloT.setText(valorTitulo);

        String valorUbi = extras.getString("ubicacion");
        System.out.println("Valor Hora:" + valorUbi);
        ubiT.setText(valorUbi);

        String valorSem = extras.getString("semillero");
        System.out.println("Valor Hora:" + valorSem);
        semT.setText(valorSem);

        String valorIes = extras.getString("institucion");
        System.out.println("Valor Hora:" + valorIes);
        iesT.setText(valorIes);



    }
}
