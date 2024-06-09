package com.example.nuevodaa;

public class respuestaCortaModelo {
    private String pregunta;
    private String respuestaCorta;

    public respuestaCortaModelo(String pregunta, String respuestaCorta) {
        this.pregunta = pregunta;
        this.respuestaCorta = respuestaCorta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuestaCorta() {
        return respuestaCorta;
    }

    public void setRespuestaCorta(String respuestaCorta) {
        this.respuestaCorta = respuestaCorta;
    }
}
