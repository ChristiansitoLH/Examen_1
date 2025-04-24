package com.dfpm.enrollment.service.implement;

import com.dfpm.enrollment.dto.CourseResponseDTO;
import com.dfpm.enrollment.dto.InscripcionRequestDTO;
import com.dfpm.enrollment.dto.InscripcionResponseDTO;
import com.dfpm.enrollment.dto.StudentResponseDTO;
import com.dfpm.enrollment.entity.Inscripcion;
import com.dfpm.enrollment.entity.InscripcionCurso;
import com.dfpm.enrollment.feign.CourseClient;
import com.dfpm.enrollment.feign.StudentClient;
import com.dfpm.enrollment.repository.InscripcionRepository;
import com.dfpm.enrollment.service.InscripcionService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InscripcionServiceImpl implements InscripcionService {

    private final StudentClient studentClient;
    private final CourseClient courseClient;
    private final InscripcionRepository inscripcionRepository;

    public InscripcionServiceImpl(StudentClient studentClient, CourseClient courseClient, InscripcionRepository inscripcionRepository) {
        this.studentClient = studentClient;
        this.courseClient = courseClient;
        this.inscripcionRepository = inscripcionRepository;
    }

    @Override
    @Transactional
    public Inscripcion registrar(InscripcionRequestDTO request) {
        // Obtener estudiante
        StudentResponseDTO estudiante = studentClient.getStudentByDni(request.getDni());

        // Crear Inscripcion
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setDniEstudiante(estudiante.getDni());
        inscripcion.setCiclo(request.getCiclo());
        inscripcion.setFechaRegistro(LocalDate.now());

        // Obtener cursos y mapear
        for (String codigo : request.getCodigosCurso()) {
            CourseResponseDTO curso = courseClient.getCourseByCodigo(codigo);

            InscripcionCurso insCurso = new InscripcionCurso();
            insCurso.setCodigoCurso(curso.getCodigo());
            insCurso.setNombreCurso(curso.getNombre());
            insCurso.setInscripcion(inscripcion);

            inscripcion.getCursos().add(insCurso);
        }

        return inscripcionRepository.save(inscripcion);
    }



    @Override
    public List<InscripcionResponseDTO> listar() {
        List<Inscripcion> inscripciones = inscripcionRepository.findAll();

        return inscripciones.stream().map(inscripcion -> {
            StudentResponseDTO estudiante = studentClient.getStudentByDni(inscripcion.getDniEstudiante());

            List<CourseResponseDTO> cursos = inscripcion.getCursos().stream()
                    .map(ic -> courseClient.getCourseByCodigo(ic.getCodigoCurso()))
                    .toList();

            InscripcionResponseDTO dto = new InscripcionResponseDTO();
            dto.setDni(inscripcion.getDniEstudiante());
            dto.setEstudiante(estudiante);
            dto.setCiclo(inscripcion.getCiclo());
            dto.setFechaRegistro(inscripcion.getFechaRegistro());
            dto.setCursos(cursos);

            return dto;
        }).toList();
    }

}