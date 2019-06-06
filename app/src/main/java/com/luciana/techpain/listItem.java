package com.luciana.techpain;

public class listItem {
    private String Nome;
    private String Comentario;

    public listItem(String nome, String comentario) {
        Nome = nome;
        Comentario = comentario;
    }

    public String getNomeDisciplina() {
        return Nome;
    }

    public String getComentario() {
        return Comentario;
    }
}