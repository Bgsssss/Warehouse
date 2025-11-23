package repository;

import entity.Pesanan;

import java.util.List;

public interface PesananRepository {

    void addPesanan(Pesanan pesanan);

    void update(Pesanan pesanan);

    boolean deleteByPesananId(Integer id);

    Pesanan findById(Integer id);

    List<Pesanan> findAll();
}
