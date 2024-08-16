package com.test.test.controller;

import com.test.test.dto.DepartmentDTO;
import com.test.test.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping
    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAllTopLevelDepartments().stream()
                .map(DepartmentDTO::new)
                .collect(Collectors.toList());
    }
}

