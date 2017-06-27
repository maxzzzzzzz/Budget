package com.valsoft.service;

import com.valsoft.dao.BudgetUserDAO;
import com.valsoft.dao.IBudgetUserDAO;
import com.valsoft.model.BudgetUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Asus on 19.06.2017.
 */
@Service("budgetUserService")
@Transactional
public class BudgetUserService implements IBudgetUserService {

    @Autowired
    private IBudgetUserDAO dao;
    @Override
    public BudgetUser findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public void saveBudgetUser(BudgetUser budgetUser) {
        dao.saveBudgetUser(budgetUser);
    }

    @Override
    public void updateBudgetUser(BudgetUser budgetUser) {
        BudgetUser entity = dao.findById(budgetUser.getId());
        if (entity!=null){
       //     entity.setBudget(budgetUser.getBudget());
        //    entity.setUser(budgetUser.getUser());
        }
    }

    @Override
    public void deleteBudgetUserById(Long id) {
        dao.deleteBudgetUserById(id);
    }

    @Override
    public List<BudgetUser> findAllBudgetUsers() {
        return dao.findAllBudgetUsers();
    }
}
