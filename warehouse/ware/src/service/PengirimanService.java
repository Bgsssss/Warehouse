package service;

import entity.Pengiriman;

import java.util.List;

public interface PengirimanService {

    void updateStatusPengiriman(Integer id, String status);

    List<Pengiriman> getAllPengiriman();

    Pengiriman getPengirimanById(Integer id);
}
