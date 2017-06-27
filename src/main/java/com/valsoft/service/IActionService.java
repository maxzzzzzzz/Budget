package com.valsoft.service;

import com.valsoft.model.Action;

import java.util.List;

/**
 * Created by Asus on 19.06.2017.
 */
public interface IActionService {
    Action findById(Long id);

    void saveAction(Action action);

    void updateAction(Action action);

    void deleteActionById(Long id);

    List<Action> findAllActions();

}
