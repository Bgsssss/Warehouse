package service;

import entity.Persediaan;
import entity.Pesanan;
import entity.RincianPesanan;

import java.util.List;

public interface RincianPesananService{

    void tambahOrder(Pesanan pesanan, List<RincianPesanan> items);

    boolean deleteByPesananId(Integer id);

    List<RincianPesanan> findByPesananId(Integer idPesanan);

}
