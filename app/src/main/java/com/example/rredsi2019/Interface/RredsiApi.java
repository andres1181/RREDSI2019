package com.example.rredsi2019.Interface;

import com.example.rredsi2019.Model.Agenda;
import com.example.rredsi2019.Model.Agenda_;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RredsiApi {


    @GET("v2/5d6addff3100006000d2077c")
    Call<Agenda> getAgenda();
}
