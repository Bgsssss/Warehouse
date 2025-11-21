package com.warehouse.service;

import com.warehouse.entity.Produk;

import java.util.List;

public interface ProdukService {

    Integer getHargaById(String idProduk);

    void addProduct(Produk produk);

    void update(Produk produk);

    void delete(String idProduk);

    Produk findById(String idProduk);

    List<Produk> findAll();
}
