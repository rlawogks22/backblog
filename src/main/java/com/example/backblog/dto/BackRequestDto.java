package com.example.backblog.dto;

import com.example.backblog.entitiy.Back;
import lombok.Getter;

@Getter
public class BackRequestDto {
    private String title; //제목
    private String name; // 이름
    private String pw; // 비밀번호
    private String contents; // 내용


}
