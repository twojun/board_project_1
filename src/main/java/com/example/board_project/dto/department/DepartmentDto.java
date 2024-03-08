package com.example.board_project.dto.department;

import com.example.board_project.domain.department.Department;
import lombok.Builder;
import lombok.Data;

@Data
public class DepartmentDto {

    private String departmentName;

    @Builder
    public DepartmentDto(Department department) {
        this.departmentName = department.getDepartmentName();
    }
}
