package service;

import entity.Persediaan;
import repository.PersediaanRepository;

public class PersediaanServiceImpl implements PersediaanService{

    private PersediaanRepository persediaanRepository;

    public PersediaanServiceImpl(PersediaanRepository persediaanRepository) {
        this.persediaanRepository = persediaanRepository;
    }

    @Override
    public void updateStokById(String idProduk, int jumlahDipesan, String idGudang) {
        Persediaan p = persediaanRepository.findByProdukAndGudang(idProduk, idGudang);

        if (p == null) {
            throw new IllegalArgumentException("Produk tidak ditemukan di gudang tersebut");
        }

        if (p.getJumlah() < jumlahDipesan) {
            throw new IllegalArgumentException("Stok tidak mencukupi");
        }

        persediaanRepository.updateStokById(idProduk, jumlahDipesan, idGudang);
    }

    @Override
    public Persediaan findByProdukAndGudang(String idProduk, String idGudang) {
        return null;
    }
}
