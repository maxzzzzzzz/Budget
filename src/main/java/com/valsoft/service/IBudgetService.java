package com.valsoft.service;

import com.valsoft.model.Budget;

import java.util.List;

/**
 * Created by Asus on 19.06.2017.
 */
public interface IBudgetService {
    Budget findById(Long id);

    void saveBudget(Budget budget);

    void updateBudget(Budget budget);

    void deleteBudgetById(Long id);

    List<Budget> findAllBudgets();
}
