package com.valsoft.service;

import com.valsoft.dao.CategoryDAO;
import com.valsoft.dao.ICategoryDAO;
import com.valsoft.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Asus on 19.06.2017.
 */
@Service("categoryService")
@Transactional
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryDAO dao;

    @Override
    public Category findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public void saveCategory(Category category) {
        dao.saveCategory(category);
    }

    @Override
    public void updateCategory(Category category) {
        Category entity = dao.findById(category.getId());
        if (entity!=null){
            entity.setName(category.getName());
        }

    }

    @Override
    public void deleteCategoryById(Long id) {
        dao.deleteCategoryById(id);
    }

    @Override
    public List<Category> findAllCategories() {
        return dao.findAllCategories();
    }
}
