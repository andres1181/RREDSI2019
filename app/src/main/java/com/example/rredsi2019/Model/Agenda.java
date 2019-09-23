package com.example.rredsi2019.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Agenda {

    @SerializedName("agenda")
    @Expose
    private List<Agenda_> agenda = null;
    @SerializedName("count")
    @Expose
    private int count;

    public List<Agenda_> get_Agenda() {
        return agenda;
    }

    public void setAgenda(List<Agenda_> agenda) {
        this.agenda = agenda;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}