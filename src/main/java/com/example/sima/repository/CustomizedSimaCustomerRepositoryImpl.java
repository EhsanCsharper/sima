package com.example.sima.repository;

import com.example.sima.DTO.management.PagingDTO;
import com.example.sima.DTO.management.SearchResult;
import com.example.sima.DTO.management.customer.CustomerDTO;
import com.example.sima.DTO.management.customer.CustomerManagementSearchDTO;
import com.example.sima.DTO.share.SharedCustomerDTO;
import com.example.sima.domain.SimaCustomer;
import com.example.sima.service.SimaFacade;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomizedSimaCustomerRepositoryImpl implements CustomizedSimaCustomerRepository {

    private final EntityManager entityManager;
    private final SimaFacade simaFacade;

    public CustomizedSimaCustomerRepositoryImpl(EntityManager entityManager, SimaFacade simaFacade) {
        this.entityManager = entityManager;
        this.simaFacade = simaFacade;
    }

    @Override
    public SearchResult<CustomerDTO> search(CustomerManagementSearchDTO searchDTO) {
        PageRequest pageable = PageRequest.of(CustomerManagementSearchDTO.DEFAULT_PAGE_INDEX,
                CustomerManagementSearchDTO.DEFAULT_PAGE_SIZE,
                Sort.by(CustomerManagementSearchDTO.DEFAULT_ORDER_BY));
        if (pagingParamsIsNotNull(searchDTO)) {
            pageable  =PageRequest.of(searchDTO.getPageIndex(), searchDTO.getPageSize(), Sort.by(searchDTO.getOrderBy()));
        }
        return getCustomerDTOSearchResult(searchDTO, pageable);
    }

    private SearchResult<CustomerDTO> getCustomerDTOSearchResult(CustomerManagementSearchDTO searchDTO, PageRequest pageable) {
        SearchResult<CustomerDTO> searchResult = new SearchResult<>();
        searchResult.setPageNumber(pageable.getPageNumber());

        int totalCount = getCustomerCount(searchDTO);
        searchResult.setTotalCount(totalCount);

        searchResult.setPageSize(pageable.getPageSize());
        searchResult.setPageCount((int) Math.ceil(totalCount / (double) pageable.getPageSize()));

        List<SimaCustomer> foodList = getcustomerList(searchDTO, pageable);
        searchResult.setResult(mapCustomerToCustomerDTO(foodList));
        return searchResult;
    }


    //  ============================================================================================================================================================================================
    //  UTILITIES
    //  ============================================================================================================================================================================================

    private List<CustomerDTO> mapCustomerToCustomerDTO(List<SimaCustomer> customers) {
        if (customers.isEmpty())
            return new ArrayList<>();

        return customers.stream().map(customer -> {
            SharedCustomerDTO sharedCustomerDTO = simaFacade.loadCustomer(customer.getCustomer());
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setId(customer.getId());
            customerDTO.setIdentifier(customer.getIdentifier());
            customerDTO.setIdentifierType(customer.getIdentifierType());
            customerDTO.setStatus(customer.getStatus());
            customerDTO.setCreationDateTime(customer.getCreationDateTime());
            customerDTO.setLastModifiedDateTime(customer.getLastModifiedDateTime());
            customerDTO.setCustomerNumber(sharedCustomerDTO.getCustomerNumber());
            customerDTO.setReal(sharedCustomerDTO.isReal());
            customerDTO.setName(sharedCustomerDTO.getTitle());
            return customerDTO;
        }).collect(Collectors.toList());
    }

    private List<SimaCustomer> getcustomerList(CustomerManagementSearchDTO searchDTO, PageRequest pageable) {
        Query query = entityManager.createQuery(createCustomerSearchQuery(searchDTO, pageable, false));
        setSearchCustomerParams(query, searchDTO);
        query.setMaxResults(pageable.getPageSize());
        query.setFirstResult((int) pageable.getOffset());
        return query.getResultList();
    }

    private int getCustomerCount(CustomerManagementSearchDTO searchDTO) {
        Query query = entityManager.createQuery(createCustomerSearchQuery(searchDTO, null, true));
        setSearchCustomerParams(query, searchDTO);
        return ((Long) query.getSingleResult()).intValue();
    }

    private void setSearchCustomerParams(Query query, CustomerManagementSearchDTO searchDTO) {
        if (searchDTO != null && StringUtils.hasText(searchDTO.getIdentifierTypeCode()) && !searchDTO.getIdentifierTypeCode().equalsIgnoreCase("0")) {
            query.setParameter("identifierTypeCode", searchDTO.getIdentifierTypeCode());
        }

        if (searchDTO != null && StringUtils.hasText(searchDTO.getStatusCode()) && !searchDTO.getStatusCode().equalsIgnoreCase("0")) {
            query.setParameter("statusCode", searchDTO.getStatusCode());
        }
        if (searchDTO != null && StringUtils.hasText(searchDTO.getIdentifier())) {
            query.setParameter("identifier", searchDTO.getIdentifier());
        }

        if (searchDTO != null && StringUtils.hasText(searchDTO.getCustomerNumber())) {
            query.setParameter("customer", searchDTO.getCustomerNumber());
        }
    }

    private String createCustomerSearchQuery(CustomerManagementSearchDTO searchDTO, Pageable pageable, boolean isGettingCount) {
        String queryString = isGettingCount ? "select count(simaCustomer) from SimaCustomer simaCustomer where 1=1 " : "select simaCustomer from SimaCustomer simaCustomer where 1=1 ";
        String orderByQuery = isGettingCount ? " " : " order by simaCustomer.identifier asc";

        if (searchDTO != null && StringUtils.hasText(searchDTO.getIdentifierTypeCode()) && !searchDTO.getIdentifierTypeCode().equalsIgnoreCase("0")) {
            queryString += "and simaCustomer.identifierType.code = :identifierTypeCode ";
        }

        if (searchDTO != null && StringUtils.hasText(searchDTO.getStatusCode()) && !searchDTO.getStatusCode().equalsIgnoreCase("0")) {
            queryString += "and simaCustomer.status.code = :statusCode ";
        }
        if (searchDTO != null && StringUtils.hasText(searchDTO.getIdentifier())) {
            queryString += "and simaCustomer.identifier = :identifier ";
        }

        if (searchDTO != null && StringUtils.hasText(searchDTO.getCustomerNumber())) {
            queryString += "and simaCustomer.customer = :customerNumber ";
        }

        if (!isGettingCount) {
            Sort.Order orderBy = pageable.getSort().iterator().next();
            if (!orderBy.getProperty().isEmpty()) {
                orderByQuery = "order by simaCustomer." + orderBy.getProperty() + " " + orderBy.getDirection();
            }
        }

        queryString += orderByQuery;
        return queryString;
    }

    private boolean pagingParamsIsNotNull(PagingDTO pagingDTO) {
        return pagingDTO != null && pagingDTO.getPageSize() > 0 && StringUtils.hasText(pagingDTO.getOrderBy());
    }
}
