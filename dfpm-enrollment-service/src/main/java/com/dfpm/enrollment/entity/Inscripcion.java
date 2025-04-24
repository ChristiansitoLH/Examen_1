package com.dfpm.enrollment.entity;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "inscripciones")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dniEstudiante;

    private String ciclo;

    private LocalDate fechaRegistro;

    @OneToMany(mappedBy = "inscripcion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InscripcionCurso> cursos = new ArrayList<>();


    public Inscripcion(Long id, String dniEstudiante, String ciclo, LocalDate fechaRegistro, List<InscripcionCurso> cursos) {
        this.id = id;
        this.dniEstudiante = dniEstudiante;
        this.ciclo = ciclo;
        this.fechaRegistro = fechaRegistro;
        this.cursos = cursos;
    }

    public Inscripcion() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDniEstudiante() {
        return dniEstudiante;
    }

    public void setDniEstudiante(String dniEstudiante) {
        this.dniEstudiante = dniEstudiante;
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

    public List<InscripcionCurso> getCursos() {
        return cursos;
    }

    public void setCursos(List<InscripcionCurso> cursos) {
        this.cursos = cursos;
    }
}