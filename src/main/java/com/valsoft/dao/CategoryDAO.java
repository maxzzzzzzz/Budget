package com.valsoft.dao;

import com.valsoft.model.Category;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Asus on 18.06.2017.
 */
@Repository
public class CategoryDAO extends AbstractDAO<Long, Category> implements ICategoryDAO {
    @Override
    public Category findById(Long id) {
        return getByKey(id);
    }

    @Override
    public void saveCategory(Category category) {
        persist(category);
    }

    @Override
    public void deleteCategoryById(Long id) {
        Query query = getSession().createSQLQuery("delete from CATEGORY where CATEGORY_ID = :id");
        query.setLong("CATEGORY_ID",id);
        query.executeUpdate();
    }

    @Override
    public List<Category> findAllCategories() {
        Criteria criteria = createEntityCriteria();
        return (List<Category>) criteria.list();
    }
}
