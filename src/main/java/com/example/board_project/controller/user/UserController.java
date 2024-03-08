package com.example.board_project.controller.user;

import com.example.board_project.dto.user.request.CreateUserAccountDto;
import com.example.board_project.service.department.DepartmentService;
import com.example.board_project.service.faculty.FacultyService;
import com.example.board_project.service.user.UserService;
import com.example.board_project.service.user.UserValidateService;
import com.example.board_project.validator.user.CheckUserEmailValidator;
import com.example.board_project.validator.user.CheckUserNumberValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserValidateService userValidateService;
    private final FacultyService facultyService;
    private final DepartmentService departmentService;
    private final CheckUserNumberValidator checkUserNumberValidator;
    private final CheckUserEmailValidator checkUserEmailValidator;

    /** 컨트롤러 메서드 호출 전 모두 유효성 검사를 진행 */
    @InitBinder
    public void validatorBinder(WebDataBinder binder) {
        binder.addValidators(checkUserNumberValidator, checkUserEmailValidator);
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/user/new")
    public String createUserAccount(@Valid CreateUserAccountDto createUserAccountDto,
                                    Model model,
                                    Errors errors) {
        model.addAttribute("faculties", facultyService.getAllFaculties());
        model.addAttribute("departments", departmentService.getAllDepartments());

        if (errors.hasErrors()) {
            model.addAttribute("createUserAccountDto", createUserAccountDto);

            Map<String, String> validatorResult = userValidateService.validateHandling(errors);
            for (String errorKey : validatorResult.keySet()) {
                validatorResult.put(errorKey, validatorResult.get(errorKey));
            }

            return "redirect:/createUserAccountForm";
        }

        userService.createUserAccount(createUserAccountDto);
        return "redirect:/";
    }

    @GetMapping("/user/new")
    public String createUserAccountForm(Model model) {
        return "member/createUserAccountForm";
    }
}
