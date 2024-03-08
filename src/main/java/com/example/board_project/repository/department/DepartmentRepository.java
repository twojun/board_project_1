package com.example.board_project.repository.department;

import com.example.board_project.domain.department.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
