package com.dfpm.enrollment.dto;

import java.util.List;

public class CourseResponseDTO {
    private String codigo;
    private Integer capacidadMax;
    private Integer capacidadMin;
    private String cicloAcademico;
    private String nombre;
    private List<HorarioDTO> horarios;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(Integer capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    public Integer getCapacidadMin() {
        return capacidadMin;
    }

    public void setCapacidadMin(Integer capacidadMin) {
        this.capacidadMin = capacidadMin;
    }

    public String getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(String cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<HorarioDTO> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorarioDTO> horarios) {
        this.horarios = horarios;
    }
}