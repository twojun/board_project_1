package com.example.board_project.repository.user;

import com.example.board_project.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // 학번 중복 검증
    boolean existsByUserNumber(String userNumber);

    // 이메일 중복 검증
    boolean existsByUserEmail(String email);

}
