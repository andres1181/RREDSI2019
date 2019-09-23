package com.example.rredsi2019;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rredsi2019.Interface.RredsiApi;
import com.example.rredsi2019.Model.Agenda;
import com.example.rredsi2019.Model.Agenda_;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void getAgenda(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RredsiApi rredsiApi = retrofit.create(RredsiApi.class);

        Call<Agenda> call = rredsiApi.getAgenda();

        call.enqueue(new Callback<Agenda>() {
            @Override
            public void onResponse(Call<Agenda> call, Response<Agenda> response) {

                if (!response.isSuccessful()){
                    Log.d("Código: ", "  " + response.code());
                    return;
                }
                System.out.println("onResponse");
                System.out.println(response.body().toString());
                Agenda listAgenda = response.body();
                System.out.println(listAgenda.get_Agenda());


                 for(Agenda_ agenda: listAgenda.get_Agenda()){
                    String content = "";
                   content += "id_agenda: " + agenda.getIdAgenda() + "\n";
                   content += "campus: " + agenda.getCampus() + "\n";
                   content += "espacio: " + agenda.getEspacio() + "\n";
                   content += "hora: " + agenda.getHora() + "\n\n";

             //      content += "autores" + agenda.getAutores() + "\n";
                   content += "Titulo: " + agenda.getTrabajo().getTitulo();

                   System.out.println(content);
                }

            }

            @Override
            public void onFailure(Call<Agenda> call, Throwable t) {

                Log.d("Error: ", "  " + t.getMessage());

            }
        });
    }

    public void buscar(View view) {
        Intent intent = new Intent(this, Panel_Consulta.class);
        startActivity(intent);
        getAgenda();
    }

    public void iniciar_google(View view) {
    }
}
