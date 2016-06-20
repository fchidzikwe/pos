/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortune.mypos.service;

import com.fortune.mypos.dao.UserDao;
import com.fortune.mypos.model.Product;
import com.fortune.mypos.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */

@Service
@Transactional
public class UserServiceImpl  implements UserService{
    @Autowired
    UserDao userDao;

    @Override
    public User findById(int id) {
       return userDao.getUser(id);
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
          User entity = userDao.getUser(user.getUserId());
        if (entity != null) {
         entity.setFirstname(user.getFirstname());
         entity.setSurname(user.getSurname());
         entity.setEmail(user.getEmail());
         entity.setUsername(user.getUsername());
         entity.setPassword(user.getPassword());
        }
    }

    @Override
    public void deleteUserById(int userId) {
       userDao.deleteUser(userId);
    }

    @Override
    public List<User> findAllUsers() {
       return  userDao.listUsers();
    }

    @Override
    public User findUserById(int userId) {
        return userDao.getUser(userId);
    }

    @Override
    public boolean isUserIdUnique(Integer id, String username) {
         User user = findById(id);
        return (user == null || ((id != null) && (user.getUserId() == id)));
    }
    
    
    
}
