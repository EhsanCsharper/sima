package com.example.sima.service;

import com.example.sima.domain.ConstantCategoryElement;
import com.example.sima.exception.SimaBusinessException;

public interface CategoryService {
    ConstantCategoryElement getCategoryElement(String code) throws SimaBusinessException;
}
