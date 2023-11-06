package com.example.backblog.controller;

import com.example.backblog.dto.BackRequestDto;
import com.example.backblog.dto.BackResponseDto;
import com.example.backblog.service.BackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gesi")
@RequiredArgsConstructor // Lombook
public class BackContrller {

    private final BackService backService;//1.변수명, 2.타입

    @PostMapping("/apis")
    public BackResponseDto savePost(@RequestBody BackRequestDto requestDto) {
        return backService.saveApis(requestDto);
    }

    @GetMapping("/api")
    public List<BackResponseDto> getPosts(){
        return backService.getApi();
    }

    @PutMapping("/api/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody BackRequestDto requestDto){
        return backService.updateApis(id,requestDto);
    }

    @DeleteMapping("/api")
    public void deletePost(@RequestParam Long id, @RequestBody BackRequestDto requestDto){
        backService.deleteApis(id,requestDto);
    }

}