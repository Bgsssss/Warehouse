package com.warehouse.repository;

import java.util.List;

import com.warehouse.entity.Product;

public interface ProductRepository {

    void addProduct(Product product);
    Product findById(String productId);
    List<Product> findAll();
    void update(Product product);
    void delete(String productId);
    List<Product> findBySupplier(String supplierId);
    Integer checkStock(String productId);
    List<Product> findByCategory();
}
