package com.valsoft.service;

import com.valsoft.model.Role;

import java.util.List;

/**
 * Created by Asus on 19.06.2017.
 */
public interface IRoleService {
    Role findById(Long id);

    void saveRole(Role role);

    void updateRole(Role role);

    void deleteRoleById(Long id);

    List<Role> findAllRoles();
}
