package com.example.board_project.service.faculty;

import com.example.board_project.dto.faculty.FacultyDto;
import com.example.board_project.repository.faculty.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public List<FacultyDto> getAllFaculties() {
        return facultyRepository.findAll().stream()
                .map(FacultyDto::new)
                .collect(Collectors.toList());
    }

//    public List<Faculty> getAllFaculties() {
//        return facultyRepository.findAll();
//    }
}

