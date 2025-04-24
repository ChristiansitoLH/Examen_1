package com.dfpm.course.mapper;

import com.dfpm.course.dto.CourseDTO;
import com.dfpm.course.dto.HorarioDTO;
import com.dfpm.course.entity.Course;
import com.dfpm.course.entity.CourseHorario;
import org.mapstruct.*;
import org.mapstruct.Mapping;
import org.springframework.web.bind.annotation.*;


@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course toEntity(CourseDTO dto);
    CourseDTO toDto(Course entity);

    CourseHorario toEntity(HorarioDTO dto);
    HorarioDTO toDto(CourseHorario entity);
}