package com.ismaeldev.integrador.service;

import com.ismaeldev.integrador.domain.Category;
import com.ismaeldev.integrador.dtos.CategoryDTOS;
import com.ismaeldev.integrador.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public List<Category> getAllCategory(){
        return this.repository.findAll();
    }
    public Category findCategoryById(Long id){
        return this.repository.findCategoriesByCategoryId(id).orElse(null);
    }

    public void createCategory(CategoryDTOS category){
        Category newCategory = new Category();
        newCategory.setCategory(category.category());
        newCategory.setDateInsert(LocalDateTime.now());
        this.repository.save(newCategory);
    }
}
