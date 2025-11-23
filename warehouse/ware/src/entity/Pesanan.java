package entity;

import java.time.LocalDateTime;

public class Pesanan {

    private Integer id;

    private Integer idPelanggan;

    private LocalDateTime tanggalPemesanan;

    private Integer jumlahTotal;

    public Pesanan() {
    }

    public Pesanan(Integer id, Integer idPelanggan, LocalDateTime tanggalPemesanan, Integer jumlahTotal) {
        this.id = id;
        this.idPelanggan = idPelanggan;
        this.tanggalPemesanan = tanggalPemesanan;
        this.jumlahTotal = jumlahTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(Integer idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public LocalDateTime getTanggalPemesanan() {
        return tanggalPemesanan;
    }

    public void setTanggalPemesanan(LocalDateTime tanggalPemesanan) {
        this.tanggalPemesanan = tanggalPemesanan;
    }

    public Integer getJumlahTotal() {
        return jumlahTotal;
    }

    public void setJumlahTotal(Integer jumlahTotal) {
        this.jumlahTotal = jumlahTotal;
    }
}
