package com.warehouse;

import com.warehouse.repository.*;
import com.warehouse.service.ProdukService;
import com.warehouse.service.ProdukServiceImpl;
import com.warehouse.service.RincianPesananService;
import com.warehouse.service.RincianPesananServiceImpl;
import com.warehouse.view.RincianPesananView;


public class App {
    public static void main(String[] args) {
        /*PemasokRepository pemasokRepository = new PemasokRepositoryImpl();
        PemasokService pemasokService = new PemasokServiceImpl(pemasokRepository);
        new PemasokView(pemasokService).menampilkanPemasok();*/

        PesananRepository pesananRepository = new PesananRepositoryImpl();
        RincianPesananRepository repository = new RincianPesananRepositoryImpl();
        ProdukRepository produkRepository = new ProdukRespositoryImpl();
        RincianPesananService rincianPesananService = new RincianPesananServiceImpl(pesananRepository, repository, produkRepository);
        ProdukService produkService = new ProdukServiceImpl(produkRepository);
        new RincianPesananView(rincianPesananService,produkService).tambahPesanan();
    }
}
