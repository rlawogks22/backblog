package com.example.backblog.service;

import com.example.backblog.dto.BackRequestDto;
import com.example.backblog.dto.BackResponseDto;
import com.example.backblog.entitiy.Back;
import com.example.backblog.repository.BackRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BackService {
    private final BackRepository backRepository;

    public BackService(BackRepository backRepository){
        this.backRepository = backRepository;
    }

    public BackResponseDto saveApis(BackRequestDto requestDto){
        //  > Entity
        Back back = new Back(requestDto);
        Back saveBack = backRepository.save(back);
        BackResponseDto backResponseDto = new BackResponseDto(back);
        return backResponseDto;
    }


    public List<BackResponseDto> getApi() {
        return backRepository.findAll().stream().map(BackResponseDto::new).toList();
    }


    public Long updateApis(Long id, BackRequestDto requestDto) {
        Back back = findBack(id);

        back.update(requestDto);
        return id;
    }

    public void deleteApis(Long id) {
        Back back = findBack(id);
        backRepository.delete(back);
    }

    private Back findBack(Long id){
        return backRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 글은 존재하지 않습니다.")
        );
    }
}
