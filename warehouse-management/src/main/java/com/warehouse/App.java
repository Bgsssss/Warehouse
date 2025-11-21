package com.warehouse;

import com.warehouse.repository.*;
import com.warehouse.service.*;
import com.warehouse.view.RincianPesananView;


public class App {
    public static void main(String[] args) {
        /*PemasokRepository pemasokRepository = new PemasokRepositoryImpl();
        PemasokService pemasokService = new PemasokServiceImpl(pemasokRepository);
        new PemasokView(pemasokService).menampilkanPemasok();*/

        PesananRepository pesananRepository = new PesananRepositoryImpl();
        RincianPesananRepository repository = new RincianPesananRepositoryImpl();
        ProdukRepository produkRepository = new ProdukRespositoryImpl();
        PersediaanRepository persediaanRepository = new PersediaanRepositoryImpl();
        RincianPesananService rincianPesananService = new RincianPesananServiceImpl(pesananRepository, repository, produkRepository, persediaanRepository);
        ProdukService produkService = new ProdukServiceImpl(produkRepository);
        PersediaanService persediaanService = new PersediaanServiceImpl(persediaanRepository);
        new RincianPesananView(rincianPesananService,produkService,persediaanService).tambahPesanan();
    }
}
