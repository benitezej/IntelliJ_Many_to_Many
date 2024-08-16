package com.test.test.dto;

import com.test.test.entity.Department;
import java.util.List;
import java.util.stream.Collectors;

public class DepartmentDTO {
    private Long id;
    private String name;
    private List<EmployeeDTO> employees;  // Declaration of the employees list
    private List<DepartmentDTO> subDepartments;

    public DepartmentDTO(Department department) {
        this.id = department.getId();
        this.name = department.getName();
        this.employees = department.getEmployees().stream()
                .map(EmployeeDTO::new) // Convert Employee to EmployeeDTO!!!!!
                .collect(Collectors.toList());
        this.subDepartments = department.getSubDepartments().stream()
                .map(DepartmentDTO::new)
                .collect(Collectors.toList());
    }

    /*
    Getters and Setters
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees;
    }

    public List<DepartmentDTO> getSubDepartments() {
        return subDepartments;
    }

    public void setSubDepartments(List<DepartmentDTO> subDepartments) {
        this.subDepartments = subDepartments;
    }
}
