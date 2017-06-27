package com.valsoft.service;

import com.valsoft.model.BudgetUser;

import java.util.List;

/**
 * Created by Asus on 19.06.2017.
 */
public interface IBudgetUserService {
    BudgetUser findById(Long id);

    void saveBudgetUser(BudgetUser budgetUser);

    void updateBudgetUser(BudgetUser budgetUser);

    void deleteBudgetUserById(Long id);

    List<BudgetUser> findAllBudgetUsers();
}
