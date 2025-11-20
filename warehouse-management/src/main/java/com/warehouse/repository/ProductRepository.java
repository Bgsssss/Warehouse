package com.warehouse.repository;

import java.util.List;

import com.warehouse.entity.Produk;

public interface ProductRepository {

    void addProduct(Produk produk);

    void update(Produk produk);

    void delete(String idProduk);

    Produk findById(String idProduk);

    List<Produk> findAll();

}
