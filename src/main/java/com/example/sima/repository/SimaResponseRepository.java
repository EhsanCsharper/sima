package com.example.sima.repository;

import com.example.sima.domain.SimaResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SimaResponseRepository extends JpaRepository<SimaResponse, Long> {
    Optional<SimaResponse> findByCheckSUM(String checkSum);
}
