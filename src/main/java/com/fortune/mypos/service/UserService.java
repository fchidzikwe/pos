/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortune.mypos.service;

import com.fortune.mypos.model.Product;
import com.fortune.mypos.model.User;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface UserService {
       User findById(int id);
     
    void saveUser(User user);
     
    void updateUser(User user);
     
    void deleteUserById(int userId);
 
    List<User> findAllUsers(); 
     
    User findUserById(int userId);
 
    boolean isUserIdUnique(Integer id, String username);
}
