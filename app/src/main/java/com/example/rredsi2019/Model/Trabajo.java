package com.example.rredsi2019.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Trabajo {

    @SerializedName("id_trabajo")
    @Expose
    private int idTrabajo;
    @SerializedName("id_tipo")
    @Expose
    private int idTipo;
    @SerializedName("tipo")
    @Expose
    private String tipo;
    @SerializedName("titulo")
    @Expose
    private String titulo;
    @SerializedName("id_sede")
    @Expose
    private int idSede;
    @SerializedName("sede")
    @Expose
    private String sede;
    @SerializedName("id_semillero")
    @Expose
    private int idSemillero;
    @SerializedName("semillero")
    @Expose
    private String semillero;

    public int getIdTrabajo() {
        return idTrabajo;
    }

    public void setIdTrabajo(int idTrabajo) {
        this.idTrabajo = idTrabajo;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIdSede() {
        return idSede;
    }

    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public int getIdSemillero() {
        return idSemillero;
    }

    public void setIdSemillero(int idSemillero) {
        this.idSemillero = idSemillero;
    }

    public String getSemillero() {
        return semillero;
    }

    public void setSemillero(String semillero) {
        this.semillero = semillero;
    }

}