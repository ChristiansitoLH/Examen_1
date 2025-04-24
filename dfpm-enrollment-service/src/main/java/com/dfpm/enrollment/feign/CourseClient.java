package com.dfpm.enrollment.feign;

import com.dfpm.enrollment.dto.CourseResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "dfpm-course-service")
public interface CourseClient {

    @GetMapping("/course/{codigo}")
    CourseResponseDTO getCourseByCodigo(@PathVariable("codigo") String codigo);
}