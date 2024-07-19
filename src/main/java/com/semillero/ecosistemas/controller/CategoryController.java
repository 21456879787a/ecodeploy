package com.semillero.ecosistemas.controller;

import com.semillero.ecosistemas.model.Category;
import com.semillero.ecosistemas.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

    //Create
    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category category){
        Category newCategory = categoryService.saveCategory(category);
        return ResponseEntity.ok(newCategory);
    }

    //Read
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

}