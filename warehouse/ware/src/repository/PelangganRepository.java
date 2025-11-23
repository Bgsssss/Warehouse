package repository;

import java.util.List;

import entity.Pelanggan;

public interface PelangganRepository {

    void add(Pelanggan pelanggan);
    void update(Pelanggan pelanggan);
    boolean delete(Integer id);
    Pelanggan findById(Integer id);
    List<Pelanggan> findAll();
}
