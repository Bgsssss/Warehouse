package com.warehouse.service;

import com.warehouse.entity.Persediaan;
import com.warehouse.entity.Pesanan;
import com.warehouse.entity.RincianPesanan;

import java.util.List;

public interface RincianPesananService{

    void tambahOrder(Pesanan pesanan, List<RincianPesanan> items);

    boolean deleteByPesananId(Integer id);

    List<RincianPesanan> findByPesananId(Integer idPesanan);

}
