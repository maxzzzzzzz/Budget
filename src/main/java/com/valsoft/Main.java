package com.valsoft;

import com.valsoft.dao.RoleDAO;
import com.valsoft.model.Role;

/**
 * Created by Asus on 19.06.2017.
 */
public class Main {
    public static void main(String[] args) {
        RoleDAO roleDAO = new RoleDAO();
        Role role = new Role();
        role.setName("klsfjdsl");
        roleDAO.saveRole(role);
    }
}
