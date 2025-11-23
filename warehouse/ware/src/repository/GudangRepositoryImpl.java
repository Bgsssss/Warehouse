package repository;

import java.util.List;

import entity.Gudang;

public class GudangRepositoryImpl implements GudangRepository{

    //struktur kodenya bisa lihat di class PemasokRepositoryImpl

    @Override
    public List<Gudang> findAll() {
        return List.of();
    }

    @Override
    public Gudang findById(String id) {
        return null;
    }

    @Override
    public Gudang add(Gudang gudang) {
        return gudang.add();
    }

    @Override
    public void update(Gudang gudang) {
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }


}
