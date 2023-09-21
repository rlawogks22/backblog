package com.example.backblog.repository;

import com.example.backblog.entitiy.Back;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BackRepository extends JpaRepository<Back, Long> {
}
