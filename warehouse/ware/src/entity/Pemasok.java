package entity;

public class Pemasok {

    private String idPemasok;

    private String nama;

    private String email;

    private String namaKontak;

    public Pemasok() {
    }

    public Pemasok(String idPemasok, String nama, String email, String namaKontak) {
        this.idPemasok = idPemasok;
        this.nama = nama;
        this.email = email;
        this.namaKontak = namaKontak;
    }

    public String getIdPemasok() {
        return idPemasok;
    }

    public void setIdPemasok(String idPemasok) {
        this.idPemasok = idPemasok;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNamaKontak() {
        return namaKontak;
    }

    public void setNamaKontak(String namaKontak) {
        this.namaKontak = namaKontak;
    }
}
