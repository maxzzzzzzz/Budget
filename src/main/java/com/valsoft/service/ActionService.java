package com.valsoft.service;

import com.valsoft.dao.ActionDAO;
import com.valsoft.dao.IActionDAO;
import com.valsoft.model.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Asus on 19.06.2017.
 */
@Service("actionService")
@Transactional
public class ActionService implements IActionService {

    @Autowired
    private IActionDAO dao;

    @Override
    public Action findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public void saveAction(Action action) {
        dao.saveAction(action);
    }

    @Override
    public void updateAction(Action action) {
        Action entity = dao.findById(action.getId());
        if(entity!=null){
            //entity.setBudgetUser(action.getBudgetUser());
            entity.setType(action.getType());
        }

    }

    @Override
    public void deleteActionById(Long id) {
        dao.deleteActionById(id);
    }

    @Override
    public List<Action> findAllActions() {
        return dao.findAllActions();
    }
}
