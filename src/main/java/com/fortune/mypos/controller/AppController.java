/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortune.mypos.controller;

import com.fortune.mypos.model.Product;
import com.fortune.mypos.service.ProductService;
import java.util.List;
import java.util.Locale;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/")
public class AppController {
 
    @Autowired
   ProductService service;
     
    @Autowired
    MessageSource messageSource;
 
    /*
     * This method will list all existing employees.
     */
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listProducts(ModelMap model) {
 
        List<Product> products = service.findAllProducts();
        model.addAttribute("products", products);
        return "allproducts";
    }
 
    /*
     * This method will provide the medium to add a new employee.
     */
    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newProduct(ModelMap model) {
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("edit", false);
        return "registration";
    }
 
    /*
     * This method will be called on form submission, handling POST request for
     * saving employee in database. It also validates the user input
     */
    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveProduct(@Valid Product product, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
           return "registration";
        }
 
        /*
         * Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation 
         * and applying it on field [ssn] of Model class [Employee].
         * 
         * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
         * framework as well while still using internationalized messages.
         * 
         */
        if(!service.isProductCodeUnique(product.getProductId(), product.getProductCode())){
            FieldError codeError =new FieldError("product","productCode",messageSource.getMessage("non.unique.productCode", new String[]{product.getProductCode()}, Locale.getDefault()));
            result.addError(codeError);
            return "registration";
        }
         
        service.saveProduct(product);
 
        model.addAttribute("success", "Product " + product.getProductName() + " saved successfully");
        return "success";
    }
 
 
    /*
     * This method will provide the medium to update an existing employee.
     */
    @RequestMapping(value = { "/edit-{productCode}-product" }, method = RequestMethod.GET)
    public String editProduct(@PathVariable String productCode, ModelMap model) {
        Product product = service.findProductByCode(productCode);
        model.addAttribute("product", product);
        model.addAttribute("edit", true);
        return "registration";
    }
     
    /*
     * This method will be called on form submission, handling POST request for
     * updating employee in database. It also validates the user input
     */
    @RequestMapping(value = { "/edit-{productCode}-product" }, method = RequestMethod.POST)
    public String updateProduct(@Valid Product product, BindingResult result,
            ModelMap model, @PathVariable String productCode) {
 
        if (result.hasErrors()) {
            return "registration";
        }
 
        if(!service.isProductCodeUnique(product.getProductId(), product.getProductCode())){
            FieldError codeError =new FieldError("product","productCode",messageSource.getMessage("non.unique.productCode", new String[]{product.getProductCode()}, Locale.getDefault()));
            result.addError(codeError);
            return "registration";
        }
 
        service.updateProduct(product);
 
        model.addAttribute("success", "Product " + product.getProductName()  + " updated successfully");
        return "success";
    }
 
     
    /*
     * This method will delete an employee by it's SSN value.
     */
    @RequestMapping(value = { "/delete-{productCode}-product" }, method = RequestMethod.GET)
    public String deleteProduct(@PathVariable String productCode) {
        service.deleteProductByCode(productCode);
        return "redirect:/list";
    }
 
}
