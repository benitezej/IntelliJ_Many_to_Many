package com.test.test.repository;

import com.test.test.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query("SELECT e FROM Department e WHERE e.parent IS NULL")
    List<Department> findAllTopLevelDepartments();
}

