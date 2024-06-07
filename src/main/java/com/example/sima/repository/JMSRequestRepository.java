package com.example.sima.repository;

import com.example.sima.domain.JMSRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JMSRequestRepository extends JpaRepository<JMSRequest, Long> {
}
