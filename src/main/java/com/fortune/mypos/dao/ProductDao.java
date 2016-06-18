/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortune.mypos.dao;

import com.fortune.mypos.model.Product;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface ProductDao {
    
    
    
     Product findById(int id);
 
    void saveProduct(Product product);
     
    void deleteProductByCode(String code);
     
    List<Product> findAllProducts();
 
    Product findProductByCode(String code);
    
}
