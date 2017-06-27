package com.valsoft.dao;

import com.valsoft.model.User;

import java.util.List;

/**
 * Created by Asus on 18.06.2017.
 */
public interface IUserDAO {

    User findById(Long id);

    void saveUser(User user);

    void deleteUserById(Long id);

    List<User> findAllUsers();

}