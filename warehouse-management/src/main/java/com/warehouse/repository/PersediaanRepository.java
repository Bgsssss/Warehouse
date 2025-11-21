package com.warehouse.repository;

import com.warehouse.entity.Pemasok;
import com.warehouse.entity.Persediaan;

import java.util.List;

public interface PersediaanRepository {

    void updateStokById(String idProduk,int jumlahDipesan, String idGudang);
    Persediaan findByProdukAndGudang(String idProduk, String idGudang);
    List<Persediaan> findByProduk(String idProduk);
}
