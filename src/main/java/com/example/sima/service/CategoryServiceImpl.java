package com.example.sima.service;

import com.example.sima.domain.ConstantCategoryElement;
import com.example.sima.exception.SimaBusinessException;
import com.example.sima.exception.SimaResponseCodes;
import com.example.sima.repository.ConstantCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final ConstantCategoryRepository constantCategoryRepository;

    public CategoryServiceImpl(ConstantCategoryRepository constantCategoryRepository) {
        this.constantCategoryRepository = constantCategoryRepository;
    }

    @Override
    public ConstantCategoryElement getCategoryElement(String code) throws SimaBusinessException {
        Optional<ConstantCategoryElement> elementOptional = constantCategoryRepository.findConstantCategoryElementByCode(code);
        if (elementOptional.isEmpty()) {
            throw new SimaBusinessException(SimaResponseCodes.CATEGORY_ELEMENT_NOT_FOUND);
        }
        return elementOptional.get();
    }
}
