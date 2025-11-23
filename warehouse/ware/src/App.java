import view.PengirimanView;
import view.RincianPesananView;
import repository.PelangganRepository;
import repository.PelangganRepositoryImpl;
import repository.PengirimanRepository;
import repository.PengirimanRepositoryImpl;
import repository.PersediaanRepository;
import repository.PersediaanRepositoryImpl;
import repository.PesananRepository;
import repository.PesananRepositoryImpl;
import repository.ProdukRepository;
import repository.ProdukRespositoryImpl;
import repository.RincianPesananRepository;
import repository.RincianPesananRepositoryImpl;
import service.PelangganService;
import service.PelangganServiceImpl;
import service.PengirimanService;
import service.PengirimanServiceImpl;
import service.PersediaanService;
import service.PersediaanServiceImpl;
import service.ProdukService;
import service.ProdukServiceImpl;
import service.RincianPesananService;
import service.RincianPesananServiceImpl;

public class App {
    public static void main(String[] args) {

        /* PesananRepository pesananRepository = new PesananRepositoryImpl();
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
        new RincianPesananView(rincianPesananService,produkService,persediaanService,pengirimanService, pelangganService).tambahPesanan(); */

        PengirimanRepository pengirimanRepository = new PengirimanRepositoryImpl();
        PengirimanService pengirimanService = new PengirimanServiceImpl(pengirimanRepository);
        new PengirimanView(pengirimanService).menu();
    }
}
