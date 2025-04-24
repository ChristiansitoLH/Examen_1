package com.dfpm.enrollment.dto;

import java.time.LocalDateTime;


import java.time.LocalDate;
import java.util.List;

public class InscripcionResponseDTO {
    private String dni;
    private StudentResponseDTO estudiante;
    private String ciclo;
    private LocalDate fechaRegistro;
    private List<CourseResponseDTO> cursos;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public StudentResponseDTO getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(StudentResponseDTO estudiante) {
        this.estudiante = estudiante;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<CourseResponseDTO> getCursos() {
        return cursos;
    }

    public void setCursos(List<CourseResponseDTO> cursos) {
        this.cursos = cursos;
    }
}