package com.luciana.techpain;

import android.util.Pair;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Mirror {

    int idMirror;
    Date dtCriacao;
    Double ampere;
    //List<Pair<Double, Double>> brush;
    private ArrayList<CustomPath.PathAction> actions_frente = new ArrayList<CustomPath.PathAction>();
    private ArrayList<CustomPath.PathAction> actions_tras = new ArrayList<CustomPath.PathAction>();

    public Mirror() {
        //brush = new ArrayList<Pair<Double, Double>>();
        dtCriacao = Calendar.getInstance().getTime();
    }

    public int getIdMirror() {
        return idMirror;
    }

    public void setIdMirror(int idMirror) {
        this.idMirror = idMirror;
    }

    public ArrayList<CustomPath.PathAction> getActions_frente() {
        return actions_frente;
    }

    public void setActions_frente(ArrayList<CustomPath.PathAction> actions_frente) {
        this.actions_frente = actions_frente;
    }

    public ArrayList<CustomPath.PathAction> getActions_tras() {
        return actions_tras;
    }

    public void setActions_tras(ArrayList<CustomPath.PathAction> actions_tras) {
        this.actions_tras = actions_tras;
    }

    public Date getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(Date dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    /*public List<Pair<Double, Double>> getBrush() {
        return brush;
    }

    public void setBrush(List<Pair<Double, Double>> brush) {
        this.brush = brush;
    }*/

}

