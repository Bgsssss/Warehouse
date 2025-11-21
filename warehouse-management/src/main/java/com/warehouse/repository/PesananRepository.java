package com.warehouse.repository;

import com.warehouse.entity.Pesanan;

import java.util.List;

public interface PesananRepository {

    void addPesanan(Pesanan pesanan);

    void update(Pesanan pesanan);

    boolean delete(Integer id);

    Pesanan findById(Integer id);

    List<Pesanan> findAll();
}
