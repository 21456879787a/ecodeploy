package com.semillero.ecosistemas.service;

import com.semillero.ecosistemas.model.Category;

import java.util.List;

public interface ICategoryService {
    //Create
    public Category saveCategory(Category category);

    //Read
    public Category findCategoryById(Long id);

    //Get All
    public List<Category> getAllCategories();

    //Update
    public Category uptadeCategory(Long id, Category category);

    //Delete
    public void deleteCategoryById(Long id);
}
