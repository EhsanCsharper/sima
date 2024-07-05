package com.example.sima.repository;

import com.example.sima.DTO.management.SearchResult;
import com.example.sima.DTO.management.customer.CustomerDTO;
import com.example.sima.DTO.management.customer.CustomerManagementSearchDTO;
import com.example.sima.domain.SimaCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SimaCustomerRepository extends JpaRepository<SimaCustomer, Long>, CustomizedSimaCustomerRepository {

    @Query("select simaCustomer from SimaCustomer simaCustomer " +
            "inner join ConstantCategoryElement categloryElement on simaCustomer.identifierType.id = categloryElement.id and categloryElement.code = :identifierTypeCode " +
            "where simaCustomer.identifier = :identifier")
    Optional<SimaCustomer> findByIdentifierAndIdentifierType(String identifier, String identifierTypeCode);

    //@Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<SimaCustomer> findById(Long id);

    @Query("select customerLog.simaCustomer from SimaCustomerLog customerLog " +
            "where customerLog.simaRequest.id = :requestId")
    SimaCustomer findByRequestId(long requestId);

}
