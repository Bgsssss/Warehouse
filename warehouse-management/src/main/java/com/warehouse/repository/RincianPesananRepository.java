package com.warehouse.repository;

import com.warehouse.entity.RincianPesanan;

import java.util.List;

public interface RincianPesananRepository {

    void addRincianPesanan(RincianPesanan rincianPesanan);

    List<RincianPesanan> findByPesananId(Integer idPesanan);
}
