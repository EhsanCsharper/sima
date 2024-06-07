package com.example.sima.repository;

import com.example.sima.domain.log.EntityGeneralLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityGeneralLogRepository extends JpaRepository<EntityGeneralLog, Long> {
}
