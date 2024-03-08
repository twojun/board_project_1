package com.example.board_project.domain.department;

import com.example.board_project.domain.faculty.Faculty;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Department {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long id;

    @Column(name = "department_name", nullable = false)
    private String departmentName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;


}
