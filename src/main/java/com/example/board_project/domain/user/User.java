package com.example.board_project.domain.user;

import com.example.board_project.domain.department.Department;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_number", nullable = false, unique = true)
    private String userNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "user_email", nullable = false, unique = true)
    private String userEmail;

    @Column(nullable = false)
    private String password;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Builder
    public User(String userNumber, String userEmail, String password, String userName) {
        this.userNumber = userNumber;
        this.userEmail = userEmail;
        this.password = password;
        this.userName = userName;
    }
}
