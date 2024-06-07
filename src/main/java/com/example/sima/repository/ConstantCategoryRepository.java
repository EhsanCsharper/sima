package com.example.sima.repository;

import com.example.sima.domain.ConstantCategoryElement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConstantCategoryRepository extends JpaRepository<ConstantCategoryElement, Long> {
    Optional<ConstantCategoryElement> findConstantCategoryElementByCode(String code);

    Optional<ConstantCategoryElement> findByCode(String code);

}
