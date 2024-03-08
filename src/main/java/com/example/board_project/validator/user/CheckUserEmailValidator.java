package com.example.board_project.validator.user;

import com.example.board_project.dto.user.request.CreateUserAccountDto;
import com.example.board_project.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Slf4j
@Component
@RequiredArgsConstructor
public class CheckUserEmailValidator implements Validator {

    private final UserRepository userRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        try {
            doValidate((CreateUserAccountDto) target, errors);
        } catch (RuntimeException e) {
            log.error("중복 검증 에러", e);
            throw e;
        }
    }

    private void doValidate(CreateUserAccountDto target, Errors errors) {
        if (userRepository.existsByUserEmail(target.getUserEmail())) {
            errors.rejectValue("userEmail", "이메일 중복 오류", "이미 등록된 이메일입니다.");
        }
    }
}
