package com.warehouse.entity;

public class Produk {

    private String idProduk;

    private String nama;

    private String deskripsi;

    private Integer harga;

    private String category;

    private String idPemasok;

    public Produk() {
    }

    public Produk(String idProduk, String nama, String deskripsi, Integer harga, String category, String idPemasok) {
        this.idProduk = idProduk;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.category = category;
        this.idPemasok = idPemasok;
    }

    public String getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(String idProduk) {
        this.idProduk = idProduk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIdPemasok() {
        return idPemasok;
    }

    public void setIdPemasok(String idPemasok) {
        this.idPemasok = idPemasok;
    }
}