package com.example.sima.repository;

import com.example.sima.domain.Category;
import com.example.sima.domain.ConstantCategoryElement;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
}
