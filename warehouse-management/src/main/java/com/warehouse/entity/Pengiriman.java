package com.warehouse.entity;

import java.sql.Date;

public class Pengiriman {

    private Integer id;

    private Integer idPesanan;

    private String idGudang;

    private Date tanggalPengiriman;

    public Pengiriman() {
    }

    public Pengiriman(Integer id, Integer idPesanan, String idGudang, Date tanggalPengiriman) {
        this.id = id;
        this.idPesanan = idPesanan;
        this.idGudang = idGudang;
        this.tanggalPengiriman = tanggalPengiriman;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPesanan() {
        return idPesanan;
    }

    public void setIdPesanan(Integer idPesanan) {
        this.idPesanan = idPesanan;
    }

    public String getIdGudang() {
        return idGudang;
    }

    public void setIdGudang(String idGudang) {
        this.idGudang = idGudang;
    }

    public Date getTanggalPengiriman() {
        return tanggalPengiriman;
    }

    public void setTanggalPengiriman(Date tanggalPengiriman) {
        this.tanggalPengiriman = tanggalPengiriman;
    }
}
