package repository;

import java.util.List;

import entity.Produk;

public interface ProdukRepository {

    void addProduct(Produk produk);

    void update(Produk produk);

    void delete(String idProduk);

    Integer getHargaById(String idProduk);

    Produk findById(String idProduk);

    List<Produk> findAll();

}
