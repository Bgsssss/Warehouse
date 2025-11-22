package com.warehouse;

import com.warehouse.repository.*;
import com.warehouse.service.*;
import com.warehouse.view.PengirimanView;
import com.warehouse.view.RincianPesananView;


public class App {
    public static void main(String[] args) {
        /*PemasokRepository pemasokRepository = new PemasokRepositoryImpl();
        PemasokService pemasokService = new PemasokServiceImpl(pemasokRepository);
        new PemasokView(pemasokService).menampilkanPemasok();*/

        PesananRepository pesananRepository = new PesananRepositoryImpl();
        RincianPesananRepository repository = new RincianPesananRepositoryImpl();
        ProdukRepository produkRepository = new ProdukRespositoryImpl();
        PengirimanRepository pengirimanRepository = new PengirimanRepositoryImpl();
        PersediaanRepository persediaanRepository = new PersediaanRepositoryImpl();
        PelangganRepository pelangganRepository = new PelangganRepositoryImpl();
        RincianPesananService rincianPesananService = new RincianPesananServiceImpl(pesananRepository, repository, produkRepository,
                                                                                    persediaanRepository, pengirimanRepository);
        ProdukService produkService = new ProdukServiceImpl(produkRepository);
        PersediaanService persediaanService = new PersediaanServiceImpl(persediaanRepository);
        PengirimanService pengirimanService = new PengirimanServiceImpl(pengirimanRepository);
        PelangganService pelangganService = new PelangganServiceImpl(pelangganRepository);
        new RincianPesananView(rincianPesananService,produkService,persediaanService,pengirimanService, pelangganService).tambahPesanan();

        /*PengirimanRepository pengirimanRepository = new PengirimanRepositoryImpl();
        PersediaanRepository persediaanRepository = new PersediaanRepositoryImpl();
        PengirimanService pengirimanService = new PengirimanServiceImpl(pengirimanRepository);
        new PengirimanView(pengirimanService).menu();*/
    }
}
