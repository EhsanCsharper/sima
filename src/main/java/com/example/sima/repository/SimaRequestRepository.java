package com.example.sima.repository;

import com.example.sima.domain.SimaRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SimaRequestRepository extends JpaRepository<SimaRequest, Long> {

    @Query("select simaRequest from SimaRequest simaRequest " +
            "where simaRequest.jmsRequest.messageId = :messageId")
    SimaRequest findByMessageId(String messageId);
}
