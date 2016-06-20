/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortune.mypos.dao;

import com.fortune.mypos.model.User;
import static java.util.Collections.list;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */
@Repository
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao{

    @Override
    public List<User> listUsers() {
        Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
    }

    @Override
    public User getUser(int id) {
         return getByKey(id);
    }

    @Override
    public void saveUser(User user) {     
        persist(user);
    }

    @Override
    public void deleteUser(int userId) {
        Query query = getSession().createSQLQuery("delete from User where userId = :userId");
        query.setInteger("userId", userId);
        query.executeUpdate();
    }
    
}
