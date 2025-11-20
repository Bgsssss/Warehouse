package com.warehouse.repository;

import com.warehouse.entity.Pemasok;

import java.util.List;

public interface PemasokRepository {

    void addPemasok(Pemasok pemasok);

    void update(Pemasok pemasok);

    boolean delete(String id);

    Pemasok findById(String idPemasok);

    List<Pemasok> findAll();
}
