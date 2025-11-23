package repository;

import java.util.List;

import entity.Persediaan;

public interface PersediaanRepository {

    void updateStokById(String idProduk,int jumlahDipesan, String idGudang);
    Persediaan findByProdukAndGudang(String idProduk, String idGudang);
    List<Persediaan> findByProduk(String idProduk);
}
