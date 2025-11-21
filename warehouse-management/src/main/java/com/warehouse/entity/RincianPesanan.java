package com.warehouse.entity;

public class RincianPesanan {

    private Integer idPesanan;

    private String idProduk;

    private Integer jumlah;

    private Integer harga;

    public RincianPesanan() {
    }

    public RincianPesanan(Integer idPesanan, String idProduk, Integer jumlah, Integer harga) {
        this.idPesanan = idPesanan;
        this.idProduk = idProduk;
        this.jumlah = jumlah;
        this.harga = harga;
    }

    public Integer getIdPesanan() {
        return idPesanan;
    }

    public void setIdPesanan(Integer idPesanan) {
        this.idPesanan = idPesanan;
    }

    public String getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(String idProduk) {
        this.idProduk = idProduk;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }
}
