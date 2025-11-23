package service;

import entity.Pelanggan;
import repository.PelangganRepository;

public class PelangganServiceImpl implements PelangganService{

    PelangganRepository pelangganRepository;

    public PelangganServiceImpl(PelangganRepository pelangganRepository) {
        this.pelangganRepository = pelangganRepository;
    }

    @Override
    public Pelanggan cariPelangganById(Integer id) {
        return pelangganRepository.findById(id);
    }
}
