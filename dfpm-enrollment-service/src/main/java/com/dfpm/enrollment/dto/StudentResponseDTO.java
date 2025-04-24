package com.dfpm.enrollment.dto;

public class StudentResponseDTO {
    private String dni;
    private String nombre;
    private ProfessionResponseDTO carrera;
    private String estado;
    private String ciclo_actual;


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ProfessionResponseDTO getCarrera() {
        return carrera;
    }

    public void setCarrera(ProfessionResponseDTO carrera) {
        this.carrera = carrera;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiclo_actual() {
        return ciclo_actual;
    }

    public void setCiclo_actual(String ciclo_actual) {
        this.ciclo_actual = ciclo_actual;
    }
}