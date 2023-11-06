package com.example.backblog.entitiy;

import com.example.backblog.dto.BackRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "back")
@Entity//JPA 매핑
@NoArgsConstructor
public class Back extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "contents", nullable = false, length = 500)
    private String contents;
    @Column(name = "pw", nullable = false)
    private String pw;//비밀번호


    public Back(BackRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.name = requestDto.getName();
        this.pw = requestDto.getPw();
        this.contents = requestDto.getContents();
    }

    public void update(BackRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.name = requestDto.getName();
        this.contents = requestDto.getContents();
    }

}
