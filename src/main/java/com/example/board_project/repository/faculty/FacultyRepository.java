package com.example.board_project.repository.faculty;

import com.example.board_project.domain.faculty.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
