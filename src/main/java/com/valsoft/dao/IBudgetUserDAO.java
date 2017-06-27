package com.valsoft.dao;

import com.valsoft.model.BudgetUser;

import java.util.List;

/**
 * Created by Asus on 18.06.2017.
 */
public interface IBudgetUserDAO {
    BudgetUser findById(Long id);

    void saveBudgetUser(BudgetUser budgetUser);

    void deleteBudgetUserById(Long id);

    List<BudgetUser> findAllBudgetUsers();
}
