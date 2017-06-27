package com.valsoft.service;

import com.valsoft.dao.IUserDAO;
import com.valsoft.dao.UserDAO;
import com.valsoft.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Asus on 19.06.2017.
 */
@Service("userService")
@Transactional
public class UserService implements IUserService {

    @Autowired
    private IUserDAO dao;

    @Override
    public User findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public void saveUser(User user) {
        dao.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        User entity = dao.findById(user.getId());
        if(entity!=null){
           entity.setNickName(user.getNickName());
           entity.setPassword(user.getPassword());
           entity.setEmail(user.getEmail());
           entity.setFirstName(user.getFirstName());
           entity.setSecondName(user.getSecondName());
        //   entity.setRole(user.getRole());
           entity.setImage(user.getImage());
        }
    }

    @Override
    public void deleteUserById(Long id) {
        dao.deleteUserById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }
}
