package com.warehouse.repository;

import com.warehouse.entity.Pengiriman;

import java.util.List;

public interface PengirimanRepository {

    void add(Pengiriman pengiriman);

    void update(Pengiriman pengiriman);

    Pengiriman findById(Integer id);

    List<Pengiriman> findAll();

}
