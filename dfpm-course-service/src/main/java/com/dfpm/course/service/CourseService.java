package com.dfpm.course.service;

import com.dfpm.course.dto.CourseDTO;
import java.util.List;

public interface CourseService {
    CourseDTO registrarCurso(CourseDTO dto);
    List<CourseDTO> listarCursos();
    CourseDTO buscarPorCodigo(String codigo);
    CourseDTO actualizarCurso(String codigo, CourseDTO dto);
    void eliminarCurso(String codigo);
}
