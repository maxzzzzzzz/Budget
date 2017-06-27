package com.valsoft.service;


import com.valsoft.model.User;

import java.util.List;

/**
 * Created by Asus on 19.06.2017.
 */
public interface IUserService {
    User findById(Long id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(Long id);

    List<User> findAllUsers();
}
