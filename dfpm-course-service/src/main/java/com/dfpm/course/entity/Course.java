package com.dfpm.course.entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;

import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String codigo;

    @Column(name = "cap_max")
    private Integer capacidadMax;

    @Column(name = "cap_min")
    private Integer capacidadMin;

    @Pattern(regexp = "^\\d{4}-[1-2]$", message = "Formato debe ser YYYY-T (ej: 2024-1)")
    @Column(name = "period")
    private String cicloAcademico;

    private String nombre;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CourseHorario> horarios;





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public @Pattern(regexp = "^\\d{4}-[1-2]$", message = "Formato debe ser YYYY-T (ej: 2024-1)") String getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(@Pattern(regexp = "^\\d{4}-[1-2]$", message = "Formato debe ser YYYY-T (ej: 2024-1)") String cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<CourseHorario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<CourseHorario> horarios) {
        this.horarios = horarios;
    }
}
