package com.warehouse.repository;

import com.warehouse.entity.Pelanggan;

import java.util.List;

public interface PelangganRepository {

    void add(Pelanggan pelanggan);
    void update(Pelanggan pelanggan);
    boolean delete(Integer id);
    Pelanggan findById(Integer id);
    List<Pelanggan> findAll();
}
