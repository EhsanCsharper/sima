package com.example.sima.service;

import com.example.sima.domain.Category;
import com.example.sima.domain.ConstantCategoryElement;
import com.example.sima.exception.SimaBusinessException;
import org.apache.tomcat.util.bcel.Const;

import java.util.List;

public interface CategoryService {
    ConstantCategoryElement getCategoryElement(String code) throws SimaBusinessException;

    Category findByName(String categoryName) throws SimaBusinessException;
}
