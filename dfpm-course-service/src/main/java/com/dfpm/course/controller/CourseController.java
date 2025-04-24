package com.dfpm.course.controller;

import com.dfpm.course.dto.CourseDTO;
import com.dfpm.course.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<CourseDTO> registrarCurso(@RequestBody @Valid CourseDTO dto) {
        return ResponseEntity.ok(courseService.registrarCurso(dto));
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> listarCursos() {
        return ResponseEntity.ok(courseService.listarCursos());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<CourseDTO> buscarPorCodigo(@PathVariable String codigo) {
        return ResponseEntity.ok(courseService.buscarPorCodigo(codigo));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<CourseDTO> actualizarCurso(@PathVariable String codigo, @RequestBody @Valid CourseDTO dto) {
        return ResponseEntity.ok(courseService.actualizarCurso(codigo, dto));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable String codigo) {
        courseService.eliminarCurso(codigo);
        return ResponseEntity.noContent().build();
    }
}
