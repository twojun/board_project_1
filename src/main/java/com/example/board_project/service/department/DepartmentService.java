package com.example.board_project.service.department;

import com.example.board_project.dto.department.DepartmentDto;
import com.example.board_project.repository.department.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<DepartmentDto> getAllDepartments() {
        return departmentRepository.findAll().stream()
                .map(DepartmentDto::new)
                .collect(Collectors.toList());
    }

//    public List<Department> getAllDepartments() {
//        return departmentRepository.findAll();
//    }
}
