package com.warehouse.repository;

import java.util.List;

import com.warehouse.entity.Produk;

public class ProductRespositoryImpl implements ProductRepository{

    @Override
    public void addProduct(Produk produk) {

    }

    @Override
    public void update(Produk produk) {

    }

    @Override
    public void delete(String productId) {

    }

    @Override
    public Produk findById(String productId) {
        return null;
    }

    @Override
    public List<Produk> findAll() {
        return List.of();
    }
}
