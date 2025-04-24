package com.dfpm.enrollment.feign;

import com.dfpm.enrollment.dto.StudentResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "dfpm-student-service")
public interface StudentClient {

    @GetMapping("/student/{dni}")
    StudentResponseDTO getStudentByDni(@PathVariable("dni") String dni);
}