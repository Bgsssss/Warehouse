package com.warehouse.service;

import com.warehouse.entity.Persediaan;
import com.warehouse.entity.Pesanan;
import com.warehouse.entity.RincianPesanan;
import com.warehouse.repository.PersediaanRepository;
import com.warehouse.repository.PesananRepository;
import com.warehouse.repository.ProdukRepository;
import com.warehouse.repository.RincianPesananRepository;

import java.util.List;

public class RincianPesananServiceImpl implements RincianPesananService{

    private PesananRepository pesananRepository;
    private RincianPesananRepository rincianPesananRepository;
    private ProdukRepository produkRepository;
    private PersediaanRepository persediaanRepository;

    public RincianPesananServiceImpl(PesananRepository pesananRepository, RincianPesananRepository rincianPesananRepository,
                                     ProdukRepository produkRepository, PersediaanRepository persediaanRepository) {
        this.pesananRepository = pesananRepository;
        this.rincianPesananRepository = rincianPesananRepository;
        this.produkRepository = produkRepository;
        this.persediaanRepository = persediaanRepository;
    }

    @Override
    public void tambahOrder(Pesanan pesanan, List<RincianPesanan> items) {
        if (pesanan == null) {
            throw new IllegalArgumentException("Pesanan tidak boleh null");
        }
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Pesanan harus memiliki minimal 1 item");
        }

        int total = 0;
        for (RincianPesanan d : items) {
            if (d.getJumlah() <= 0) throw new IllegalArgumentException("Jumlah item harus > 0");
            if (d.getHarga() <= 0) throw new IllegalArgumentException("Harga item harus > 0");

            total += d.getJumlah() * d.getHarga();
        }
        pesanan.setJumlahTotal(total);

        pesananRepository.addPesanan(pesanan);

        for (RincianPesanan d : items) {
            d.setIdPesanan(pesanan.getId());
            d.setHarga(produkRepository.getHargaById(d.getIdProduk()));
            rincianPesananRepository.addRincianPesanan(d);

            List<Persediaan> persediaanList = persediaanRepository.findByProduk(d.getIdProduk());
            int sisa = d.getJumlah();
            for (Persediaan p : persediaanList) {
                if (sisa <= 0) break;
                if (p.getJumlah() >= sisa) {
                    persediaanRepository.updateStokById(p.getIdProduk(), sisa, p.getIdGudang());
                    sisa = 0;
                } else {
                    persediaanRepository.updateStokById(p.getIdProduk(), p.getJumlah(), p.getIdGudang());
                    sisa -= p.getJumlah();
                }
            }
            if (sisa > 0) {
                throw new IllegalStateException("Stok tidak cukup untuk produk " + d.getIdProduk());
            }
        }
    }
}
