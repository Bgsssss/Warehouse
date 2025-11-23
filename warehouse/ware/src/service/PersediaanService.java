package service;

import entity.Persediaan;

public interface PersediaanService {

    void updateStokById(String idProduk,int jumlahDipesan, String idGudang);
    Persediaan findByProdukAndGudang(String idProduk, String idGudang);
}
