package com.example.backblog.entitiy;

import com.example.backblog.dto.BackRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class Back extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private BackRoleEnum role;



    public Back(String username, String password, String email, BackRoleEnum role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

//    public void update(BackRequestDto requestDto) {
//        this.title = requestDto.getTitle();
//        this.name = requestDto.getName();
//        this.contents = requestDto.getContents();
//    }
}
