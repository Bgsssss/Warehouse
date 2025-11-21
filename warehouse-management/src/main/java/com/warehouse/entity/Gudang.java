package com.warehouse.entity;

public class Gudang {

    private String id;

    private String lokasi;

    private Integer kapasitas;

    private String email;

    public Gudang() {
    }

    public Gudang(String id, String lokasi, Integer kapasitas, String email) {
        this.id = id;
        this.lokasi = lokasi;
        this.kapasitas = kapasitas;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public Integer getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(Integer kapasitas) {
        this.kapasitas = kapasitas;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
