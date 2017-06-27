package com.valsoft.service;


import com.valsoft.dao.IRoleDAO;
import com.valsoft.dao.RoleDAO;
import com.valsoft.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Asus on 19.06.2017.
 */
@Service
@Transactional
public class RoleService implements IRoleService {

    @Autowired
    private IRoleDAO dao;

    @Override
    public Role findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public void saveRole(Role role) {
        dao.saveRole(role);
    }

    @Override
    public void updateRole(Role role) {
        Role entity = dao.findById(role.getId());
        if(entity!=null){
            entity.setName(role.getName());
        }
    }

    @Override
    public void deleteRoleById(Long id) {
        dao.deleteRoleById(id);
    }

    @Override
    public List<Role> findAllRoles() {
        return dao.findAllRoles();
    }
}
