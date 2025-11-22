package com.warehouse.service;

import com.warehouse.entity.Pelanggan;
import com.warehouse.repository.PelangganRepository;

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
