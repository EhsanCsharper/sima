package com.example.sima.controller;

import com.example.sima.DTO.management.customer.CustomerManagementSearchDTO;
import com.example.sima.DTO.request.SimaCustomerRequestDTO;
import com.example.sima.SimaCodes;
import com.example.sima.exception.SimaBusinessException;
import com.example.sima.repository.SimaCustomerRepository;
import com.example.sima.service.CategoryService;
import com.example.sima.service.SimaCustomerService;
import com.example.sima.service.SimaFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private final SimaCustomerRepository customerRepository;
    private final CategoryService categoryService;
    private final SimaFacade simaFacade;

    private final SimaCustomerService simaCustomerService;

    public CustomerController(SimaCustomerRepository customerRepository, CategoryService categoryService, SimaFacade simaFacade, SimaCustomerService simaCustomerService) {
        this.customerRepository = customerRepository;
        this.categoryService = categoryService;
        this.simaFacade = simaFacade;
        this.simaCustomerService = simaCustomerService;
    }

    @GetMapping("/customers")
    public String searchCustomer(@ModelAttribute("customerManagementSearchDTO") CustomerManagementSearchDTO searchDTO,
                                 Model model) throws SimaBusinessException {
        model.addAttribute("identificationTypes", categoryService.findByName(SimaCodes.SIMA_CUSTOMER_IDENTIFIER_TYPE).getPossibleValues());
        model.addAttribute("customerStatusTypes", categoryService.findByName(SimaCodes.SIMA_CUSTOMER_STATUS).getPossibleValues());
        model.addAttribute("searchDTO", searchDTO);
        model.addAttribute("searchResult", customerRepository.search(searchDTO));
        model.addAttribute("hasPermissionToBlockCustomer", simaFacade.hasUserPermissionInAuthorizedOperations("انسداد مشتری سیما").hasUserPermission());
        model.addAttribute("hasPermissionToUnBlockCustomer", simaFacade.hasUserPermissionInAuthorizedOperations("رفع انسداد مشتری سیما").hasUserPermission());
        return "customer/customer-management";
    }

    @PostMapping("/customers/isPartyBlocked")
    public long isPartyBlocked(@ModelAttribute("simaCustomerRequestDTO") SimaCustomerRequestDTO simaCustomerRequestDTO) throws SimaBusinessException {
        return simaCustomerService.sendIsPartyBlockedRequest(simaCustomerRequestDTO);
    }
}
