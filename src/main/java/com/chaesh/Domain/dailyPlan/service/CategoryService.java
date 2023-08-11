package com.chaesh.Domain.dailyPlan.service;

import com.chaesh.Domain.category.Category;
import com.chaesh.Domain.category.CategoryCode;
import com.chaesh.Domain.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional
    public Long save(Long memberId, CategoryCode code) throws RuntimeException{
        Category category = new Category();
        category.setCategoryType(code);
        return categoryRepository.save(category).getPk();
    }
}
