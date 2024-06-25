package com.example.sima.controller.v1;

import com.example.sima.DTO.request.SimaCustomerRequestDTO;
import com.example.sima.api.v1.model.GeneralDTO;
import com.example.sima.config.log.CorrelationIDHelper;
import com.example.sima.exception.SimaBusinessException;
import com.example.sima.exception.SimaResponseCodes;
import com.example.sima.feature.SimaFeature;
import com.example.sima.service.SimaCustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    public static final String BASE_URL = "/api/sima/v1/customer";
    private final SimaCustomerService simaCustomerService;
    private final CorrelationIDHelper correlationIDHelper;

    public CustomerController(SimaCustomerService simaCustomerService, CorrelationIDHelper correlationIDHelper) {
        this.simaCustomerService = simaCustomerService;
        this.correlationIDHelper = correlationIDHelper;
    }

    @GetMapping("/isPartyBlocked/{identifierTypeCode}/{identifier}")
    @PreAuthorize("hasAnyAuthority('read', 'admin')")
    public GeneralDTO isPartyBlocked(@PathVariable String identifierTypeCode, @PathVariable String identifier) throws SimaBusinessException {
        SimaCustomerRequestDTO requestDTO = new SimaCustomerRequestDTO();
        requestDTO.setIdentifier(identifier);
        requestDTO.setIdentifierTypeCode(identifierTypeCode);
        simaCustomerService.sendIsPartyBlockedRequest(requestDTO);
        return new GeneralDTO(SimaResponseCodes.SIMA_SUCCESS.getCode(), "درخواست شما با موفقیت ارسال شد", BASE_URL + "/getCustomerInfo/" + requestDTO.getIdentifierTypeCode() + "/" + requestDTO.getIdentifier(), correlationIDHelper.getCorrelationID());
    }
}
