package service;

import entity.Pengiriman;
import repository.PengirimanRepository;

import java.time.LocalDateTime;
import java.util.List;

public class PengirimanServiceImpl implements PengirimanService {

    private PengirimanRepository pengirimanRepository;

    public PengirimanServiceImpl(PengirimanRepository pengirimanRepository) {
        this.pengirimanRepository = pengirimanRepository;
    }



    @Override
    public void updateStatusPengiriman(Integer id, String status) {
        if (id == null || status == null) {
            throw new IllegalArgumentException("Id dan status tidak boleh null");
        }

        Pengiriman p = pengirimanRepository.findById(id);
        if (p == null) {
            throw new IllegalArgumentException("Pengiriman tidak ditemukan");
        }

        p.setStatus(status.toUpperCase());

        if ("DIKIRIM".equalsIgnoreCase(status) || "SELESAI".equalsIgnoreCase(status)) {
            p.setTanggalPengiriman(LocalDateTime.now());
        } else {
            p.setTanggalPengiriman(null);
        }

        pengirimanRepository.update(p);
    }

    @Override
    public List<Pengiriman> getAllPengiriman() {
        return pengirimanRepository.findAll();
    }

    @Override
    public Pengiriman getPengirimanById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID tidak boleh null");
        }
        Pengiriman pengiriman = pengirimanRepository.findById(id);
        if (pengiriman == null){
            throw new IllegalArgumentException("ID Pengiriman tidak ditemukan");
        }
        return pengiriman;
    }
}
