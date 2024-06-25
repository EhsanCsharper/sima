package com.example.sima.controller.v1;

import com.example.sima.SharedCodes;
import com.example.sima.api.v1.model.GeneralDTO;
import com.example.sima.config.log.CorrelationIDHelper;
import com.example.sima.exception.SimaBusinessException;
import com.example.sima.exception.SimaResponseCodes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Objects;

@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    private final CorrelationIDHelper correlationIDHandler;

    public ResponseExceptionHandler(CorrelationIDHelper correlationIDHandler) {
        this.correlationIDHandler = correlationIDHandler;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleBusinessException(Exception exception, WebRequest request) {
        GeneralDTO generalDTO = new GeneralDTO();
        generalDTO.setCorrelationId(correlationIDHandler.getCorrelationID());
        if (exception instanceof SimaBusinessException businessException) {
            generalDTO.setRsCode(Objects.isNull(businessException.getExceptionCode()) ? SimaResponseCodes.SIMA_UNKNOWN_ERROR.getCode() : businessException.getExceptionCode());
            generalDTO.setErrorMessage(businessException.getMessage());
            return new ResponseEntity<>(generalDTO, new HttpHeaders(), HttpStatus.OK);
        } else if (exception instanceof AccessDeniedException accessDeniedException){
            return new ResponseEntity<>("access denied", new HttpHeaders(), HttpStatus.FORBIDDEN);
        } else {
            generalDTO.setRsCode(SimaResponseCodes.SIMA_INVALID_EXCEPTION_TYPE.getCode());
            generalDTO.setErrorMessage(SharedCodes.EMPTY_STRING);
            return new ResponseEntity<>(generalDTO, new HttpHeaders(), HttpStatus.OK);
        }
    }
}
