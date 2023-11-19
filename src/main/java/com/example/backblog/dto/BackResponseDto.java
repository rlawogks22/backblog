//package com.example.backblog.dto;
//
//import com.example.backblog.entitiy.Back;
//import lombok.Getter;
//
//import java.time.LocalDateTime;
//
//@Getter
//public class BackResponseDto {
//    private Long id;
//    private String title;
//    private String name;
//    private String contents;
//    private LocalDateTime createAt;
//    private LocalDateTime modifiedAT;
//
//    private String msg;
//
//    public BackResponseDto(Back back) {
//        this.id = back.getId();
//        this.title = back.getTitle();
//        this.name = back.getName();
//        this.contents = back.getContents();
//        this.createAt = back.getCreatedAt();
//        this.modifiedAT = back.getModifiedAt();
//    }
//
//    public BackResponseDto(String msg){
//        this.msg = msg;
//    }
//
//}
