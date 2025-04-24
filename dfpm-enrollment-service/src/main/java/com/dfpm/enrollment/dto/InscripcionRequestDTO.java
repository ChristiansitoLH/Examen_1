package com.dfpm.enrollment.dto;

import java.util.List;

public class InscripcionRequestDTO {
    private String dni;
    private String ciclo;
    private List<String> codigosCurso;


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public List<String> getCodigosCurso() {
        return codigosCurso;
    }

    public void setCodigosCurso(List<String> codigosCurso) {
        this.codigosCurso = codigosCurso;
    }
}