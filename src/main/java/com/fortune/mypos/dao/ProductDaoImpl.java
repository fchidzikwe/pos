/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortune.mypos.dao;

import com.fortune.mypos.model.Product;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao {

    @Override
    public Product findById(int id) {
     return getByKey(id);
    }

    @Override
    public void saveProduct(Product product) {
        persist(product);
    }

    @Override
    public void deleteProductByCode(String productCode) {
        Query query = getSession().createSQLQuery("delete from Product where productCode = :productCode");
        query.setString("productCode", productCode);
        query.executeUpdate();
        
    }

    @Override
    public List<Product> findAllProducts() {
        Criteria criteria = createEntityCriteria();
        return (List<Product>) criteria.list();
    }

    @Override
    public Product findProductByCode(String productCode) {
           Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("productCode", productCode));
        return (Product) criteria.uniqueResult();
    }
    
}
