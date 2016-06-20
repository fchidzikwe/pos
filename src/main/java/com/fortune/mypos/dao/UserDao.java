/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortune.mypos.dao;

import com.fortune.mypos.model.User;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface UserDao  {
    
    public List<User> listUsers();
    
    public User getUser(int id);
    
    public void saveUser(User user);
    
    public void deleteUser(int id);
    
    
}
