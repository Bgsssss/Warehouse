package com.warehouse.view;

import com.warehouse.entity.Pesanan;
import com.warehouse.entity.RincianPesanan;
import com.warehouse.service.ProdukService;
import com.warehouse.service.RincianPesananService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RincianPesananView {
    Scanner input = new Scanner(System.in);

    private RincianPesananService rincianPesananService;

    private ProdukService produkService;

    public RincianPesananView(RincianPesananService rincianPesananService, ProdukService produkService) {
        this.rincianPesananService = rincianPesananService;
        this.produkService = produkService;
    }

    public void tambahPesanan() {
        try {
            System.out.print("ID Pelanggan: ");
            int idPelanggan = Integer.parseInt(input.nextLine());

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

            System.out.println("Pesanan berhasil ditambahkan dengan ID: " + pesanan.getId() +
                    " | Total: " + pesanan.getJumlahTotal());
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
