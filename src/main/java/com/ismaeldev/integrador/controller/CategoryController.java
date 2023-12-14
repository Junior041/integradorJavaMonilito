package com.ismaeldev.integrador.controller;

import com.ismaeldev.integrador.domain.Category;
import com.ismaeldev.integrador.dtos.CategoryDTOS;
import com.ismaeldev.integrador.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> categories = this.categoryService.getAllCategory();
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDTOS category){
        categoryService.createCategory(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
