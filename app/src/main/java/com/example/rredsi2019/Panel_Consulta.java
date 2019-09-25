package com.example.rredsi2019;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.rredsi2019.Interface.RredsiApi;
import com.example.rredsi2019.Model.Agenda;
import com.example.rredsi2019.Model.Agenda_;
import com.example.rredsi2019.Model.Autores;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Panel_Consulta extends AppCompatActivity {


    private RadioGroup tipo_proyect;
    private RadioButton radio_Button_En_Curso;
    private RadioButton radioButtonEnTerminado;
    private RadioButton radioButtonEnPoster;
    private EditText ies;
    private EditText name_proyect;
    private String getTitulo;
    private String getIes;
    private String getTipo;
    private String dataP[];
    private boolean existen;
    Agenda listAgenda;
    ArrayList<String> autoresList = new ArrayList<String>();


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel__consulta);

        tipo_proyect = findViewById(R.id.radioGroup2);
        radioButtonEnPoster = findViewById(R.id.radio_poster);
        radioButtonEnTerminado = findViewById(R.id.radio_terminado);
        radio_Button_En_Curso = findViewById(R.id.radio_curso);

        dataP = new String[7];

        existen = false;

        listAgenda = new Agenda();

        ies = findViewById(R.id.input_ies);
        name_proyect = findViewById(R.id.input_name_project);

        getAgenda();
    }

    public void validarDatos(){

        getTitulo = name_proyect.getText().toString();
        getIes = ies.getText().toString();
        int idDeRadioButton = tipo_proyect.getCheckedRadioButtonId();
        if (idDeRadioButton == radioButtonEnTerminado.getId()) {
            getTipo = "PROYECTO TERMINADO";
        } else if (idDeRadioButton == radio_Button_En_Curso.getId()) {
            getTipo = "PROYECTO EN CURSO";
        } else if (idDeRadioButton == radioButtonEnPoster.getId()) {
            getTipo = "POSTER";
        }
        System.out.println(getTipo);
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
                listAgenda = response.body();
            }

            @Override
            public void onFailure(Call<Agenda> call, Throwable t) {

                Log.d("Error: ", "  " + t.getMessage());

            }
        });

    }


    //Sebuscan los datos en el JSON generado en la funcion getAgenda()
    public void buscarDatos(){
        validarDatos();

        String nombreJson;
        String institucionJson;
        for(Agenda_ agenda : listAgenda.get_Agenda()){

            nombreJson = agenda.getTrabajo().getTitulo();
            nombreJson = nombreJson.toUpperCase();

            institucionJson = agenda.getTrabajo().getSede();
            institucionJson = institucionJson.toUpperCase();

            getIes = getIes.toUpperCase();
            getTitulo = getTitulo.toUpperCase();

            if (nombreJson.equals(getTitulo)&&institucionJson.equals(getIes)&&agenda.getTrabajo().getTipo().equals(getTipo)) {

                //
                dataP[0]=agenda.getHora();


                dataP[1]=agenda.getCampus();
                dataP[2]=agenda.getEspacio();

                dataP[3]=agenda.getTrabajo().getTitulo();
                dataP[4]= agenda.getTrabajo().getSemillero();

                dataP[5]= agenda.getTrabajo().getSede();
                dataP[6]= String.valueOf(agenda.getTrabajo().getIdTrabajo());


                for(Autores autores : agenda.getAutores()){
                    String persona = autores.getNombres() + " " + autores.getApellidos();
                    System.out.println("Una Personita: " + persona);
                    autoresList.add(persona);
                }

                existen = true;

            }else if (!nombreJson.equals(getTitulo)&&!institucionJson.equals(getIes)&&!agenda.getTrabajo().getTipo().equals(getTipo)) {
                System.out.println("Errorcito: No coinciden los datos");
                existen = false;
            }
        }
        System.out.println(dataP[0]);
        System.out.println(dataP[1]);
        System.out.println(dataP[2]);
        System.out.println(dataP[3]);
        System.out.println(dataP[4]);
        System.out.println(dataP[5]);
        System.out.println("Unas Personitas: " + autoresList);
    }

    public void mostrarDialogo(){
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Importante");
        dialogo1.setMessage("Verifique que los datos ingresados sean correctos");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                dialogo1.dismiss();;
            }
        });
        dialogo1.show();
    }

    public void validarConsulta(View view) {
        buscarDatos();

        if((!ies.getText().toString().isEmpty()||!name_proyect.getText().toString().isEmpty())&&existen){

            System.out.println("Horirita" + dataP[0]);
            System.out.println("Ubicacion:" + dataP[1] + " - " + dataP[2]);

            Intent intent = new Intent(this, Lista_Datos.class);

            intent.putExtra("autor1", autoresList.get(0));
            intent.putExtra("autor2", autoresList.get(1));

            System.out.println("Hora:" + dataP[0]);
            intent.putExtra("hora", dataP[0]);

            System.out.println("Ubicacion:" + dataP[1] + " - " + dataP[2]);
            intent.putExtra("ubicacion", "Campus " + dataP[1] + " - " + dataP[2]);

            System.out.println("Titulo:" + dataP[3]);
            intent.putExtra("titulo",  dataP[3]);

            System.out.println("Semillero:" + dataP[4]);
            intent.putExtra("semillero", dataP[4]);

            System.out.println("institucion:" + dataP[5]);
            intent.putExtra("institucion", dataP[5] );

            System.out.println("Codigo:" + dataP[6]);
            intent.putExtra("codigo", dataP[6] );

            startActivity(intent);

        }else{
            mostrarDialogo();

        }






    }
}
