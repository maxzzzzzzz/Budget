package com.valsoft.dao;

import com.valsoft.model.Category;

import java.util.List;

/**
 * Created by Asus on 18.06.2017.
 */
public interface ICategoryDAO {
    Category findById(Long id);

    void saveCategory(Category category);

    void deleteCategoryById(Long id);

    List<Category> findAllCategories();
}
