package com.example.backblog.repository;

import com.example.backblog.entitiy.Back;
import org.hibernate.engine.jdbc.batch.spi.BatchKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BackRepository extends JpaRepository<Back, Long> {
    List<Back> findAllByOrderByModifiedAtDesc();

    Optional<Back> findByUsername(String username);
    Optional<Back> findByEmail(String email);
}
