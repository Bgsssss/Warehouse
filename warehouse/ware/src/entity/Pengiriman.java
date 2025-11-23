package entity;

import java.sql.Date;
import java.time.LocalDateTime;

public class Pengiriman {

    private Integer id;

    private Integer idPesanan;

    private String idGudang;

    private LocalDateTime tanggalPengiriman;

    private String status;

    public Pengiriman() {
    }

    public Pengiriman(Integer id, Integer idPesanan, String idGudang, LocalDateTime tanggalPengiriman, String status) {
        this.id = id;
        this.idPesanan = idPesanan;
        this.idGudang = idGudang;
        this.tanggalPengiriman = tanggalPengiriman;
        this.status = status;
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

    public LocalDateTime getTanggalPengiriman() {
        return tanggalPengiriman;
    }

    public void setTanggalPengiriman(LocalDateTime tanggalPengiriman) {
        this.tanggalPengiriman = tanggalPengiriman;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
