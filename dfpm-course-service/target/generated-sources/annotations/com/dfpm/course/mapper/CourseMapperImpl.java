package com.dfpm.course.mapper;

import com.dfpm.course.dto.CourseDTO;
import com.dfpm.course.dto.HorarioDTO;
import com.dfpm.course.entity.Course;
import com.dfpm.course.entity.CourseHorario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-23T23:41:41-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.15 (Microsoft)"
)
@Component
public class CourseMapperImpl implements CourseMapper {

    @Override
    public Course toEntity(CourseDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Course course = new Course();

        course.setCodigo( dto.getCodigo() );
        course.setCapacidadMax( dto.getCapacidadMax() );
        course.setCapacidadMin( dto.getCapacidadMin() );
        course.setCicloAcademico( dto.getCicloAcademico() );
        course.setNombre( dto.getNombre() );
        course.setHorarios( horarioDTOListToCourseHorarioList( dto.getHorarios() ) );

        return course;
    }

    @Override
    public CourseDTO toDto(Course entity) {
        if ( entity == null ) {
            return null;
        }

        CourseDTO courseDTO = new CourseDTO();

        courseDTO.setCodigo( entity.getCodigo() );
        courseDTO.setCapacidadMax( entity.getCapacidadMax() );
        courseDTO.setCapacidadMin( entity.getCapacidadMin() );
        courseDTO.setCicloAcademico( entity.getCicloAcademico() );
        courseDTO.setNombre( entity.getNombre() );
        courseDTO.setHorarios( courseHorarioListToHorarioDTOList( entity.getHorarios() ) );

        return courseDTO;
    }

    @Override
    public CourseHorario toEntity(HorarioDTO dto) {
        if ( dto == null ) {
            return null;
        }

        CourseHorario courseHorario = new CourseHorario();

        courseHorario.setDia( dto.getDia() );
        courseHorario.setHoraInicio( dto.getHoraInicio() );
        courseHorario.setHoraFin( dto.getHoraFin() );

        return courseHorario;
    }

    @Override
    public HorarioDTO toDto(CourseHorario entity) {
        if ( entity == null ) {
            return null;
        }

        HorarioDTO horarioDTO = new HorarioDTO();

        horarioDTO.setDia( entity.getDia() );
        horarioDTO.setHoraInicio( entity.getHoraInicio() );
        horarioDTO.setHoraFin( entity.getHoraFin() );

        return horarioDTO;
    }

    protected List<CourseHorario> horarioDTOListToCourseHorarioList(List<HorarioDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<CourseHorario> list1 = new ArrayList<CourseHorario>( list.size() );
        for ( HorarioDTO horarioDTO : list ) {
            list1.add( toEntity( horarioDTO ) );
        }

        return list1;
    }

    protected List<HorarioDTO> courseHorarioListToHorarioDTOList(List<CourseHorario> list) {
        if ( list == null ) {
            return null;
        }

        List<HorarioDTO> list1 = new ArrayList<HorarioDTO>( list.size() );
        for ( CourseHorario courseHorario : list ) {
            list1.add( toDto( courseHorario ) );
        }

        return list1;
    }
}
