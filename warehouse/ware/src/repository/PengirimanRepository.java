package repository;

import java.util.List;

import entity.Pengiriman;

public interface PengirimanRepository {

    void add(Pengiriman pengiriman);

    void update(Pengiriman pengiriman);

    Pengiriman findById(Integer id);

    List<Pengiriman> findAll();

}
