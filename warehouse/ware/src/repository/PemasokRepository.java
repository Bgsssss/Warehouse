package repository;

import java.util.List;

import entity.Pemasok;

public interface PemasokRepository {

    void addPemasok(Pemasok pemasok);

    void update(Pemasok pemasok);

    boolean delete(String id);

    Pemasok findById(String idPemasok);

    List<Pemasok> findAll();
}
