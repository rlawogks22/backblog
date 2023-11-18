package com.example.backblog.service;


import com.example.backblog.dto.SignupRequestDto;
import com.example.backblog.entitiy.Back;
import com.example.backblog.entitiy.BackRoleEnum;
import com.example.backblog.jwt.JwtUtil;
import com.example.backblog.repository.BackRepository;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.Optional;

@Service
public class BackService {
    private final BackRepository backRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    private final String ADMIN_TOKEN = "AAABnvxRVklrnYxKZ0aHgTBcXukeZygoC";

    public BackService(BackRepository backRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.backRepository = backRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public void signup(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        String password = passwordEncoder.encode(requestDto.getPassword());

        // 회원 중복 확인
        Optional<Back> checkUsername = backRepository.findByUsername(username);
        if (checkUsername.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }

        // email 중복확인
        String email = requestDto.getEmail();
        Optional<Back> checkEmail = backRepository.findByEmail(email);
        if (checkEmail.isPresent()) {
            throw new IllegalArgumentException("중복된 Email 입니다.");
        }

        // 사용자 ROLE 확인
        BackRoleEnum role = BackRoleEnum.USER;
        if (requestDto.isAdmin()) {
            if (!ADMIN_TOKEN.equals(requestDto.getAdminToken())) {
                throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
            }
            role = BackRoleEnum.ADMIN;
        }

        // 사용자 등록
        Back back = new Back(username, password, email, role);
        backRepository.save(back);
    }

}
//
//    public BackResponseDto saveApis(BackRequestDto requestDto){
//        Back back = new Back(requestDto);         //  > Entity
//        Back saveBack = backRepository.save(back); //DB저장
//        return new BackResponseDto(saveBack);
//    }
//
//    public List<BackResponseDto> getApiList() {
//        return backRepository.findAll().stream().map(BackResponseDto::new).toList();
//    }
//
//    public BackResponseDto getBack(Long id){
//        Back back = backRepository.findById(id).orElseThrow(
//                () ->new IllegalArgumentException("아이디가 없습니다.")
//        );
//        return new BackResponseDto(back);
//    }
//
//    @Transactional
//    public BackResponseDto updateApis(Long id, BackRequestDto requestDto) {
//        Back back = findBack(id);
//
//        if(back.getPw().equals(requestDto.getPw())){
//            back.update(requestDto);
//        } else{
//            return new BackResponseDto("비밀번호가 일치하지 않습니다.");
//        }
//        return new BackResponseDto(back);
//    }
//
//    public BackResponseDto deleteApis(Long id,BackRequestDto requestDto) {
//        Back back = findBack(id);
//        if(back.getPw().equals(requestDto.getPw())){
//            backRepository.delete(back);
//        } else{
//            return new BackResponseDto("비밀번호가 일치하지 않습니다.");
//        }
//;        return new BackResponseDto("계시글을 삭제했습니다.");
//    }
//
//    private Back findBack(Long id){
//        return backRepository.findById(id).orElseThrow(() ->
//                new IllegalArgumentException("선택한 글은 존재하지 않습니다.")
//        );
//    }
//}
