package com.example.sima.service;

import com.example.sima.exception.SimaBusinessException;

public interface SimaJMSService {
    void sendMessage(String message) throws SimaBusinessException;
}
