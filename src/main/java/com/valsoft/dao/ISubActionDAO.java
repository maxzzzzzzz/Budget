package com.valsoft.dao;

import com.valsoft.model.SubAction;

import java.util.List;

/**
 * Created by Asus on 18.06.2017.
 */
public interface ISubActionDAO {
    SubAction findById(Long id);

    void saveSubAction(SubAction subAction);

    void deleteSubActionById(Long id);

    List<SubAction> findAllSubActions();
}
