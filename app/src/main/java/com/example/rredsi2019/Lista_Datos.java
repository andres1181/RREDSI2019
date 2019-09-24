package com.example.rredsi2019;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TabWidget;
import android.widget.TextView;

import static com.example.rredsi2019.R.*;

public class Lista_Datos extends AppCompatActivity {

    private TextView horaT;
    private TextView ubiT;
    private TextView tituloT;
    private TextView semT;
    private TextView iesT;
    private TextView autor1T;
    private TextView autor2T;
    private TextView codigoT;
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
        autor1T = findViewById(id.view_autor1);
        autor2T = findViewById(id.view_autor2);
        codigoT = findViewById(id.view_codigo);

        mostrarDatos();
    }



    public void mostrarDatos(){
        Bundle extras= getIntent().getExtras();

        String valorAutor1 = extras.getString("autor1");
        System.out.println("Valor autor1:" + valorAutor1);
        autor1T.setText(valorAutor1);

        String valorAutor2 = extras.getString("autor2");
        System.out.println("Valor autor2:" + valorAutor2);
        autor2T.setText(valorAutor2);

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

        String valorCod = extras.getString("codigo");
        System.out.println("Valor Hora:" + valorCod);
        codigoT.setText(valorCod);



    }
}
