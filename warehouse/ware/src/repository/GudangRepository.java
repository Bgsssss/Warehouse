package repository;

import java.util.List;

import entity.Gudang;

public interface GudangRepository {

    List<Gudang> findAll();

    Gudang findById(String id);

    Gudang add(Gudang gudang);

    void update(Gudang gudang);

    boolean deleteById(String id);
}
