package com.example.board_project.dto.faculty;

import com.example.board_project.domain.faculty.Faculty;
import lombok.Builder;
import lombok.Data;

@Data
public class FacultyDto {

    private String facultyName;

    @Builder
    public FacultyDto(Faculty faculty) {
        this.facultyName = faculty.getFacultyName();
    }
}
