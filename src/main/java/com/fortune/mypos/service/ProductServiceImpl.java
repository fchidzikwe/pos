/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortune.mypos.service;

import com.fortune.mypos.dao.ProductDao;
import com.fortune.mypos.model.Product;
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

public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public Product findById(int id) {
        return productDao.findById(id);
    }

    @Override
    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        Product entity = productDao.findById(product.getProductId());
        if (entity != null) {
            entity.setProductName(product.getProductName());
            entity.setProductCategory(product.getProductCategory());
            entity.setProductPrice(product.getProductPrice());
            entity.setProductCode(product.getProductCode());
        }
    }

    @Override
    public void deleteProductByCode(String productCode) {
        productDao.deleteProductByCode(productCode);
    }

    @Override
    public List<Product> findAllProducts() {
        return productDao.findAllProducts();
    }

    @Override
    public Product findProductByCode(String productCode) {
        return productDao.findProductByCode(productCode);
    }

    @Override
    public boolean isProductCodeUnique(Integer id, String productCode) {
        Product product = findProductByCode(productCode);
        return (product == null || ((id != null) && (product.getProductId() == id)));

    }

}
