package com.example.rredsi2019.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Agenda_ {

    @SerializedName("id_agenda")
    @Expose
    private int idAgenda;
    @SerializedName("id_campus")
    @Expose
    private int idCampus;
    @SerializedName("id_espacio")
    @Expose
    private int idEspacio;
    @SerializedName("campus")
    @Expose
    private String campus;
    @SerializedName("espacio")
    @Expose
    private String espacio;
    @SerializedName("autores")
    @Expose
    private List<Autores> autores = null;
    @SerializedName("trabajo")
    @Expose
    private Trabajo trabajo;
    @SerializedName("hora")
    @Expose
    private String hora;

    public int getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    public int getIdCampus() {
        return idCampus;
    }

    public void setIdCampus(int idCampus) {
        this.idCampus = idCampus;
    }

    public int getIdEspacio() {
        return idEspacio;
    }

    public void setIdEspacio(int idEspacio) {
        this.idEspacio = idEspacio;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getEspacio() {
        return espacio;
    }

    public void setEspacio(String espacio) {
        this.espacio = espacio;
    }

    public List<Autores> getAutores() {
        return autores;
    }

    public void setAutores(List<Autores> autores) {
        this.autores = autores;
    }

    public Trabajo getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(Trabajo trabajo) {
        this.trabajo = trabajo;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

}