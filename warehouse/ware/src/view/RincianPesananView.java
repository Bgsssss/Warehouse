package view;

import entity.Pelanggan;
import entity.Pengiriman;
import entity.Pesanan;
import entity.RincianPesanan;
import service.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RincianPesananView {
    Scanner input = new Scanner(System.in);

    private RincianPesananService rincianPesananService;
    private ProdukService produkService;
    private PersediaanService persediaanService;
    private PengirimanService pengirimanService;
    private PelangganService pelangganService;

    public RincianPesananView(RincianPesananService rincianPesananService, ProdukService produkService,
                              PersediaanService persediaanService, PengirimanService pengirimanService, PelangganService pelangganService) {
        this.rincianPesananService = rincianPesananService;
        this.produkService = produkService;
        this.persediaanService = persediaanService;
        this.pengirimanService = pengirimanService;
        this.pelangganService = pelangganService;
    }

    public void tambahPesanan() {
        try {
            System.out.println("==== Tambah Pesanan ===");
            System.out.print("ID Pelanggan: ");
            int idPelanggan = Integer.parseInt(input.nextLine());

            Pelanggan pelanggan = pelangganService.cariPelangganById(idPelanggan);
            if (pelanggan == null){
                System.out.println("Pelanggan tidak ditemukan!");
                return;
            }
            List<RincianPesanan> items = new ArrayList<>();

            while (true) {
                System.out.print("ID Produk: ");
                String idProduk = input.nextLine();

                System.out.print("Jumlah: ");
                int jumlah = Integer.parseInt(input.nextLine());

                int harga = produkService.getHargaById(idProduk);

                items.add(new RincianPesanan(0, idProduk, jumlah, harga));

                System.out.print("Tambah item lain? (y/n): ");
                String lagi = input.nextLine();
                if (!lagi.equalsIgnoreCase("y")) break;
            }

            Pesanan pesanan = new Pesanan();
            pesanan.setIdPelanggan(idPelanggan);
            pesanan.setTanggalPemesanan(LocalDateTime.now());

            rincianPesananService.tambahOrder(pesanan, items);

            System.out.println("\nPesanan berhasil ditambahkan:");
            System.out.println("ID Pesanan: " + pesanan.getId());
            System.out.println("Jumlah Total: " + pesanan.getJumlahTotal());

            System.out.println("\nDetail Pelanggan");
            System.out.println("Id: " + pelanggan.getId());
            System.out.println("Nama: " + pelanggan.getNama());
            System.out.println("Alamat: " + pelanggan.getAlamat());
            System.out.println("No HP: " + pelanggan.getNoHp());

            System.out.println("\n=== Rincian Pesanan ===");
            System.out.printf("%-10s %-10s %-10s%n", "ID Produk", "Jumlah", "Harga");
            for (RincianPesanan rp : items) {
                System.out.printf("%-10s %-10d %-10d%n", rp.getIdProduk(), rp.getJumlah(), rp.getHarga());
            }

            // Tampilkan pengiriman terkait
            List<Pengiriman> allPengiriman = pengirimanService.getAllPengiriman();
            List<Pengiriman> pengirimanList = new ArrayList<>();
            for (Pengiriman p : allPengiriman) {
                if (p.getIdPesanan().equals(pesanan.getId())) {
                    pengirimanList.add(p);
                }
            }


            System.out.println("\n=== Detail Pengiriman ===");
            System.out.printf("%-5s %-10s %-12s %-20s%n", "ID", "ID Gudang", "Status", "Tgl Pengiriman");
            for (Pengiriman p : pengirimanList) {
                String tgl = (p.getTanggalPengiriman() == null) ? "-" : p.getTanggalPengiriman().toLocalDate().toString();
                System.out.printf("%-5d %-10s %-12s %-20s%n",
                        p.getId(),
                        p.getIdGudang() == null ? "-" : p.getIdGudang(),
                        p.getStatus() == null ? "-" : p.getStatus(),
                        tgl
                );
            }

        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    public void deleteById(){
        System.out.println("=== Hapus Pesanan ===");
        System.out.print("ID Pesanan: ");
        int id = Integer.parseInt(input.nextLine());

        if (rincianPesananService.deleteByPesananId(id)){
            System.out.println("Berhasil Hapus Data: " + id);
        }else {
            System.out.println("ID tidak ditemukan");
        }
    }

}
