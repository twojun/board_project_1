package com.example.board_project.dto.user.request;

import com.example.board_project.domain.department.Department;
import com.example.board_project.domain.faculty.Faculty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreateUserAccountDto {

    @NotBlank(message = "학번은 필수 입력 사항입니다.")
    @Size(min = 8, max = 8, message = "본인의 고유 학번은 8자리입니다.")
    private String userNumber;

//    private List<Faculty> faculties = new ArrayList<>();
//    private List<Department> departments = new ArrayList<>();

    @NotBlank(message = "이메일은 필수 입력 사항입니다.")
    @Email(message = "올바른 형식의 메일 주소를 입력해 주세요.")
    private String userEmail;

    @NotBlank(message = "비밀번호를 입력해 주세요.")
    @Size(min = 8, max = 20, message = "비밀번호는 8~20자 이내로 입력해 주세요.")
    private String password;

    @NotBlank(message = "이름을 입력해 주세요.")
    @Size(min = 2, max = 20, message = "이름은 2~20자 사이로 입력해 주세요.")
    private String userName;

}
