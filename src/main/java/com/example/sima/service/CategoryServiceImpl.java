package com.example.sima.service;

import com.example.sima.domain.Category;
import com.example.sima.domain.ConstantCategoryElement;
import com.example.sima.exception.SimaBusinessException;
import com.example.sima.exception.SimaResponseCodes;
import com.example.sima.repository.CategoryRepository;
import com.example.sima.repository.ConstantCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final ConstantCategoryRepository constantCategoryRepository;

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(ConstantCategoryRepository constantCategoryRepository, CategoryRepository categoryRepository) {
        this.constantCategoryRepository = constantCategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ConstantCategoryElement getCategoryElement(String code) throws SimaBusinessException {
        Optional<ConstantCategoryElement> elementOptional = constantCategoryRepository.findConstantCategoryElementByCode(code);
        if (elementOptional.isEmpty()) {
            throw new SimaBusinessException(SimaResponseCodes.CATEGORY_ELEMENT_NOT_FOUND);
        }
        return elementOptional.get();
    }

    @Override
    public Category findByName(String categoryName) throws SimaBusinessException {
        Optional<Category> optional = categoryRepository.findByName(categoryName);
        if (optional.isEmpty()) {
            throw new SimaBusinessException(SimaResponseCodes.CATEGORY_NOT_FOUND);
        }
        return optional.get();
    }
}
