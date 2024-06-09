package com.example.nuevodaa;

public class vfModelo {
    String pregunta;
    boolean verdadero;

    public vfModelo(String pregunta, boolean verdadero) {
        this.pregunta = pregunta;
        this.verdadero = verdadero;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public boolean isVerdadero() {
        return verdadero;
    }

    public void setVerdadero(boolean verdadero) {
        this.verdadero = verdadero;
    }
}
