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
    private ArrayList<CustomPath.PathAction> actions = new ArrayList<CustomPath.PathAction>();

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

    public ArrayList<CustomPath.PathAction> getActions() {
        return actions;
    }

    public void setActions(ArrayList<CustomPath.PathAction> actions) {
        this.actions = actions;
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

