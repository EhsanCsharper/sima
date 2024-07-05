package com.example.sima.repository;

import com.example.sima.DTO.management.SearchResult;
import com.example.sima.DTO.management.customer.CustomerDTO;
import com.example.sima.DTO.management.customer.CustomerManagementSearchDTO;

public interface CustomizedSimaCustomerRepository {
    SearchResult<CustomerDTO> search(CustomerManagementSearchDTO searchDTO);
}
