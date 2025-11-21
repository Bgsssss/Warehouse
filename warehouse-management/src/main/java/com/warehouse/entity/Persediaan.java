package com.warehouse.entity;

public class Persediaan {

    Integer id;

    private String idProduk;

    private String idGudang;

    private Integer jumlah;

    public Persediaan() {
    }

    public Persediaan(Integer id, String idProduk, String idGudang, Integer jumlah) {
        this.id = id;
        this.idProduk = idProduk;
        this.idGudang = idGudang;
        this.jumlah = jumlah;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(String idProduk) {
        this.idProduk = idProduk;
    }

    public String getIdGudang() {
        return idGudang;
    }

    public void setIdGudang(String idGudang) {
        this.idGudang = idGudang;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }
}
