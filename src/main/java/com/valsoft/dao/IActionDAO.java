package com.valsoft.dao;

import com.valsoft.model.Action;

import java.util.List;

/**
 * Created by Asus on 18.06.2017.
 */
public interface IActionDAO {
    Action findById(Long id);

    void saveAction(Action role);

    void deleteActionById(Long id);

    List<Action> findAllActions();
}

