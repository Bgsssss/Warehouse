package com.warehouse.view;

import com.warehouse.entity.Pengiriman;
import com.warehouse.service.PengirimanService;

import java.util.List;
import java.util.Scanner;

public class PengirimanView {

    Scanner input = new Scanner(System.in);
    PengirimanService pengirimanService;

    public PengirimanView(PengirimanService pengirimanService) {
        this.pengirimanService = pengirimanService;
    }

    public void menu() {
        while (true) {
            System.out.println("\n=== MENU PENGIRIMAN ===");
            System.out.println("1. Lihat Semua Pengiriman");
            System.out.println("2. Update Status Pengiriman");
            System.out.println("x. Keluar");
            System.out.print("Pilih menu: ");

            String pilihan = input.nextLine();

            switch (pilihan) {
                case "1":
                    tampilkanSemuaPengiriman();
                    break;
                case "2":
                    updateStatusPengirimanCLI();
                    break;
                case "x":
                    System.out.println("Keluar dari menu pengiriman.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private void tampilkanSemuaPengiriman() {
        List<Pengiriman> list = pengirimanService.getAllPengiriman();
        System.out.printf("%-5s %-10s %-10s %-12s %-20s%n",
                "ID", "ID Pesanan", "ID Gudang", "Status", "Tgl Pengiriman");

        for (Pengiriman p : list) {
            System.out.printf("%-5d %-10d %-10s %-12s %-20s%n",
                    p.getId(),
                    p.getIdPesanan(),
                    p.getIdGudang() == null ? "-" : p.getIdGudang(),
                    p.getStatus() == null ? "-" : p.getStatus(),
                    p.getTanggalPengiriman() == null ? "-" : p.getTanggalPengiriman()
            );
        }
    }

    private void updateStatusPengirimanCLI() {
        try {
            System.out.print("Masukkan ID Pengiriman: ");
            int id = Integer.parseInt(input.nextLine());

            System.out.print("Masukkan Status Baru (DIPROSES / DIKIRIM / SELESAI): ");
            String status = input.nextLine();

            pengirimanService.updateStatusPengiriman(id, status.toUpperCase());
            System.out.println("Status pengiriman berhasil diupdate!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
