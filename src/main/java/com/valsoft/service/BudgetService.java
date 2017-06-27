package com.valsoft.service;

import com.valsoft.dao.BudgetDAO;
import com.valsoft.dao.IBudgetDAO;
import com.valsoft.model.Budget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Asus on 19.06.2017.
 */
@Service("budgetService")
@Transactional
public class BudgetService implements IBudgetService {

    @Autowired
    private IBudgetDAO dao;

    @Override
    public Budget findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public void saveBudget(Budget budget) {
        dao.saveBudget(budget);
    }

    @Override
    public void updateBudget(Budget budget) {
        Budget entity = dao.findById(budget.getId());
        if (entity!=null){
            entity.setName(budget.getName());
            entity.setDescription(budget.getDescription());
            entity.setCreationDate(budget.getCreationDate());
          //  entity.setUser(budget.getUser());
        }
    }

    @Override
    public void deleteBudgetById(Long id) {
        dao.deleteBudgetById(id);
    }

    @Override
    public List<Budget> findAllBudgets() {
        return dao.findAllBudgets();
    }
}
