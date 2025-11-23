package service;

import entity.Pengiriman;
import entity.Persediaan;
import entity.Pesanan;
import entity.RincianPesanan;
import repository.*;

import java.util.List;

public class RincianPesananServiceImpl implements RincianPesananService{

    private PesananRepository pesananRepository;
    private RincianPesananRepository rincianPesananRepository;
    private ProdukRepository produkRepository;
    private PersediaanRepository persediaanRepository;
    private PengirimanRepository pengirimanRepository;

    public RincianPesananServiceImpl(PesananRepository pesananRepository, RincianPesananRepository rincianPesananRepository,
                                     ProdukRepository produkRepository, PersediaanRepository persediaanRepository,
                                     PengirimanRepository pengirimanRepository) {
        this.pesananRepository = pesananRepository;
        this.rincianPesananRepository = rincianPesananRepository;
        this.produkRepository = produkRepository;
        this.persediaanRepository = persediaanRepository;
        this.pengirimanRepository = pengirimanRepository;
    }

    @Override
    public boolean deleteByPesananId(Integer id) {
        if (id == null || id.describeConstable().isEmpty()){
            throw new IllegalArgumentException("ID tidak boleh kosong");
        }
        return pesananRepository.deleteByPesananId(id);
    }


    @Override
    public List<RincianPesanan> findByPesananId(Integer idPesanan) {
        return List.of();
    }

    private Persediaan updateStokDanPilihGudang(RincianPesanan rincianPesanan) {
        List<Persediaan> persediaanList = persediaanRepository.findByProduk(rincianPesanan.getIdProduk());
        int jumlahPesanan = rincianPesanan.getJumlah();
        Persediaan gudangDipilih = null;
        for (Persediaan p : persediaanList) {
            if (jumlahPesanan <= 0) break;
            if (p.getJumlah() >= jumlahPesanan) {
                persediaanRepository.updateStokById(p.getIdProduk(), jumlahPesanan, p.getIdGudang());
                if (gudangDipilih == null) gudangDipilih = p;
                jumlahPesanan = 0;
            } else {
                persediaanRepository.updateStokById(p.getIdProduk(), p.getJumlah(), p.getIdGudang());
                if (gudangDipilih == null) gudangDipilih = p;
                jumlahPesanan -= p.getJumlah();
            }
        }
        if (jumlahPesanan > 0) {
            throw new IllegalStateException("Stok tidak cukup untuk produk " + rincianPesanan.getIdProduk());
        }
        return gudangDipilih;
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

        for (RincianPesanan rincianPesanan : items) {
            rincianPesanan.setIdPesanan(pesanan.getId());
            rincianPesanan.setHarga(produkRepository.getHargaById(rincianPesanan.getIdProduk()));
            rincianPesananRepository.addRincianPesanan(rincianPesanan);

            Persediaan gudangDipilih = updateStokDanPilihGudang(rincianPesanan);

            Pengiriman pengiriman = new Pengiriman();
            pengiriman.setIdPesanan(pesanan.getId());
            pengiriman.setIdGudang(gudangDipilih.getIdGudang());
            pengiriman.setStatus("DIPROSES");
            pengiriman.setTanggalPengiriman(null);
            pengirimanRepository.add(pengiriman);
        }
    }
}
