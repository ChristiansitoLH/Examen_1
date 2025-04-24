package com.dfpm.course.service.implement;

import com.dfpm.course.dto.CourseDTO;
import com.dfpm.course.dto.HorarioDTO;
import com.dfpm.course.entity.Course;
import com.dfpm.course.entity.CourseHorario;
import com.dfpm.course.mapper.CourseMapper;
import com.dfpm.course.repository.CourseRepository;
import com.dfpm.course.service.CourseService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepo;
    private final CourseMapper courseMapper;
    public CourseServiceImpl(CourseRepository courseRepo, CourseMapper courseMapper) {
        this.courseRepo = courseRepo;
        this.courseMapper = courseMapper;
    }

    @Override
    @Transactional
    public CourseDTO registrarCurso(CourseDTO dto) {
        Course course = courseMapper.toEntity(dto);

        if (dto.getHorarios() != null) {
            for (CourseHorario h : course.getHorarios()) {
                h.setCurso(course);
            }
        }

        return courseMapper.toDto(courseRepo.save(course));
    }

    @Override
    public List<CourseDTO> listarCursos() {
        return courseRepo.findAll().stream()
                .map(courseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO buscarPorCodigo(String codigo) {
        Course course = courseRepo.findByCodigo(codigo)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        return courseMapper.toDto(course);
    }

    @Override
    @Transactional
    public CourseDTO actualizarCurso(String codigo, CourseDTO dto) {
        Course course = courseRepo.findByCodigo(codigo)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        // Actualizamos campos
        course.setNombre(dto.getNombre());
        course.setCodigo(dto.getCodigo());
        course.setCapacidadMax(dto.getCapacidadMax());
        course.setCapacidadMin(dto.getCapacidadMin());
        course.setCicloAcademico(dto.getCicloAcademico());

        // Actualizamos horarios
        course.getHorarios().clear();
        if (dto.getHorarios() != null) {
            for (HorarioDTO horarioDTO : dto.getHorarios()) {
                CourseHorario horario = courseMapper.toEntity(horarioDTO);
                horario.setCurso(course);
                course.getHorarios().add(horario);
            }
        }

        return courseMapper.toDto(courseRepo.save(course));
    }

    @Override
    @Transactional
    public void eliminarCurso(String codigo) {
        Course course = courseRepo.findByCodigo(codigo)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        courseRepo.delete(course);
    }
}
