package com.warehouse.repository;

import com.warehouse.entity.RincianPesanan;

import java.util.List;

public interface RincianPesananRepository {

    void addRincianPesanan(RincianPesanan rincianPesanan);

    boolean deleteByPesananId(Integer id);

    List<RincianPesanan> findByPesananId(Integer idPesanan);
}
