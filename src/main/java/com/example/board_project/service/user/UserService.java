package com.example.board_project.service.user;

import com.example.board_project.domain.user.User;
import com.example.board_project.dto.user.request.CreateUserAccountDto;
import com.example.board_project.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void createUserAccount(CreateUserAccountDto createUserAccountDto) {
        User user = User.builder()
                .userName(createUserAccountDto.getUserName())
                .userNumber(createUserAccountDto.getUserNumber())
                .userEmail(createUserAccountDto.getUserEmail())
                .password(createUserAccountDto.getPassword())
                .build();

        userRepository.save(user);
    }

}
