package com.warehouse.service;

import com.warehouse.entity.Pemasok;
import com.warehouse.repository.PemasokRepository;

import java.util.List;

public class PemasokServiceImpl implements PemasokService {

    private PemasokRepository pemasokRepository;

    public PemasokServiceImpl(PemasokRepository pemasokRepository) {
        this.pemasokRepository = pemasokRepository;
    }

    @Override
    public List<Pemasok> tampilkanSemua() {
        return pemasokRepository.findAll();
    }

    @Override
    public void tambahPemasok(Pemasok pemasok) {
        validasiTambah(pemasok);
        pemasokRepository.addPemasok(pemasok);
        System.out.println("Sukses Menambahkan Pemasok");
    }

    @Override
    public void updatePemasok(Pemasok pemasok) {
        validasiUpdate(pemasok);
        pemasokRepository.update(pemasok);
        System.out.println("Sukses Update Pemasok");
    }

    @Override
    public boolean hapusPemasok(String id) {
        boolean success = pemasokRepository.delete(id);
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID tidak boleh kosong");
        }
        return success;
    }

    @Override
    public Pemasok cariPemasokById(String idPemasok) {
        if (idPemasok == null || idPemasok.isBlank()) {
            throw new IllegalArgumentException("ID tidak boleh kosong");
        }
        return pemasokRepository.findById(idPemasok);
    }


    private void validasiTambah(Pemasok p) {
        if (p.getIdPemasok() == null || p.getIdPemasok().isBlank()) {
            throw new IllegalArgumentException("ID pemasok tidak boleh kosong");
        }

        if (pemasokRepository.findById(p.getIdPemasok()) != null) {
            throw new IllegalArgumentException("ID sudah ada");
        }

        if (p.getNama() == null || p.getNama().length() < 3) {
            throw new IllegalArgumentException("Nama minimal 3 karakter");
        }

        if (p.getEmail() == null || p.getEmail().isBlank()) {
            throw new IllegalArgumentException("Format email tidak valid");
        }

        if (p.getNamaKontak() == null || p.getNamaKontak().isBlank()) {
            throw new IllegalArgumentException("Nama kontak tidak boleh kosong");
        }
    }

    private void validasiUpdate(Pemasok p) {
        if (p.getIdPemasok() == null || p.getIdPemasok().isBlank()) {
            throw new IllegalArgumentException("ID pemasok tidak boleh kosong");
        }

        if (pemasokRepository.findById(p.getIdPemasok()) == null) {
            throw new IllegalArgumentException("ID pemasok tidak ditemukan");
        }

        if (p.getNama() == null || p.getNama().isBlank()) {
            throw new IllegalArgumentException("Nama Perusahaan tidak boleh kosong");
        }

        if (p.getEmail() == null || p.getEmail().isBlank()) {
            throw new IllegalArgumentException("Format email tidak valid");
        }

        if (p.getNamaKontak() == null || p.getNamaKontak().isBlank()) {
            throw new IllegalArgumentException("Nama kontak tidak boleh kosong");
        }
    }
}
