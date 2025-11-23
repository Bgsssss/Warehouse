package service;

import entity.Produk;
import repository.ProdukRepository;

import java.util.List;

public class ProdukServiceImpl implements ProdukService{

    ProdukRepository produkRepository;

    public ProdukServiceImpl(ProdukRepository produkRepository) {
        this.produkRepository = produkRepository;
    }

    @Override
    public Integer getHargaById(String idProduk) {
        return produkRepository.getHargaById(idProduk);
    }

    @Override
    public void addProduct(Produk produk) {

    }

    @Override
    public void update(Produk produk) {

    }

    @Override
    public void delete(String idProduk) {

    }

    @Override
    public Produk findById(String idProduk) {
        return null;
    }

    @Override
    public List<Produk> findAll() {
        return List.of();
    }
}
