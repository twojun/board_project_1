package com.example.board_project.domain.faculty;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Faculty {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faculty_id")
    private Long id;

    @Column(name = "faculty_name", nullable = false)
    private String facultyName;
}
