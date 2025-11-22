package com.warehouse.repository;

import com.warehouse.entity.Gudang;

import java.util.List;

public interface GudangRepository {

    List<Gudang> findAll();

    Gudang findById(String id);

    Gudang add(Gudang gudang);

    void update(Gudang gudang);

    boolean deleteById(String id);
}
