package com.valsoft.service;

import com.valsoft.model.Category;

import java.util.List;

/**
 * Created by Asus on 19.06.2017.
 */
public interface ICategoryService {
    Category findById(Long id);

    void saveCategory(Category category);

    void updateCategory(Category category);

    void deleteCategoryById(Long id);

    List<Category> findAllCategories();
}
