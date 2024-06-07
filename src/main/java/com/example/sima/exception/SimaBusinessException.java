package com.example.sima.exception;

public class SimaBusinessException extends Exception {
    String exceptionCode;

    public SimaBusinessException() {
    }

    public SimaBusinessException(String message) {
        super(message);
    }

    public SimaBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public SimaBusinessException(Throwable cause) {
        super(cause);
    }

    public SimaBusinessException(SimaResponseCodes simaErrors, Object... args) {
        super(String.format(simaErrors.getMessage(), args));
        setExceptionCode(simaErrors.getCode());
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }
}
