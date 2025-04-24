package com.dfpm.enrollment.service;

import com.dfpm.enrollment.dto.InscripcionRequestDTO;
import com.dfpm.enrollment.dto.InscripcionResponseDTO;
import com.dfpm.enrollment.entity.Inscripcion;

import java.util.List;

public interface InscripcionService {
    Inscripcion registrar(InscripcionRequestDTO request);
    List<InscripcionResponseDTO> listar();
}