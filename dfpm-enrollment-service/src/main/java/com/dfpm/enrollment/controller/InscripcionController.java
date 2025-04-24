package com.dfpm.enrollment.controller;

import com.dfpm.enrollment.dto.InscripcionRequestDTO;
import com.dfpm.enrollment.dto.InscripcionResponseDTO;
import com.dfpm.enrollment.entity.Inscripcion;
import com.dfpm.enrollment.service.InscripcionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollment")
public class InscripcionController {

    private final InscripcionService inscripcionService;

    public InscripcionController(InscripcionService inscripcionService) {
        this.inscripcionService = inscripcionService;
    }

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody @Valid InscripcionRequestDTO request) {
        Inscripcion inscripcion = inscripcionService.registrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Inscripción registrada con ID: " + inscripcion.getId());
    }

    @GetMapping
    public ResponseEntity<List<InscripcionResponseDTO>> listar() {
        return ResponseEntity.ok(inscripcionService.listar());
    }
}
