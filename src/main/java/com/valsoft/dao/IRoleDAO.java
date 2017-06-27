package com.valsoft.dao;

import com.valsoft.model.Role;


import java.util.List;

/**
 * Created by Asus on 18.06.2017.
 */
public interface IRoleDAO {
    Role findById(Long id);

    void saveRole(Role role);

    void deleteRoleById(Long id);

    List<Role> findAllRoles();
}
