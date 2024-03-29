package com.example.board_project.validator;

import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.Errors;

@Slf4j
public abstract class AbstractValidator<T> implements Validator {

    public boolean supports(Class<T> clazz) {
        return true;
    }

    @SuppressWarnings("unchecked")
    public void validate(Object target, Errors errors) {
        try {
            doValidate((T) target, errors);
        } catch (RuntimeException e) {
            log.error("중복 검증 에러");
            throw e;
        }
    }

    protected abstract void doValidate(final T dto, final Errors errors);
}
