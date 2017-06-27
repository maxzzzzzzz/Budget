package com.valsoft.service;

import com.valsoft.model.SubAction;

import java.util.List;

/**
 * Created by Asus on 19.06.2017.
 */
public interface ISubActionService {
    SubAction findById(Long id);

    void saveSubAction(SubAction subAction);

    void updateSubAction(SubAction subAction);

    void deleteSubActionById(Long id);

    List<SubAction> findAllSubActions();
}
