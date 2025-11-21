package com.warehouse.view;

import com.warehouse.entity.Pemasok;
import com.warehouse.service.PemasokService;

import java.util.List;
import java.util.Scanner;

public class PemasokView {

    Scanner input = new Scanner(System.in);

    private PemasokService pemasokService;

    public PemasokView(PemasokService pemasokService) {
        this.pemasokService = pemasokService;
    }

    public void menampilkanPemasok(){
        while (true){
            System.out.println("\n=== MENU PEMASOK ===");
            System.out.println("1. Tambah Pemasok");
            System.out.println("2. Update Pemasok");
            System.out.println("3. Hapus Pemasok");
            System.out.println("4. Cari Pemasok");
            System.out.println("5. Tampilkan Semua Data Pemasok");
            System.out.println("x. Keluar");
            System.out.print("Pilih: ");

            String pilih = input.nextLine();

            switch (pilih){
                case "1":
                    tambah();
                    break;
                case "2":
                    update();
                    break;
                case "3":
                    hapus();
                    break;
                case "4":
                    cariById();
                    break;
                case "5":
                    menampilkanData();
                    break;
                case "x":
                    System.out.println("Keluar....");
                    return;
                default:
                    System.out.println("Input tidak valid");
            }
        }
    }

    public void tambah(){
        System.out.println("=== Tambah Pemasok ===");
        System.out.print("ID: ");
        String id = input.nextLine();
        System.out.print("Nama Perusahaan: ");
        String nama = input.nextLine();
        System.out.print("Email: ");
        String email = input.nextLine();
        System.out.print("Nama Kontak: ");
        String nk = input.nextLine();

        pemasokService.tambahPemasok(new Pemasok(id, nama, email, nk));
    }

    public void update(){
        System.out.println("=== Update Pemasok ===");
        System.out.print("ID Pemasok yang diupdate: ");
        String id = input.nextLine();
        System.out.print("Nama Perusahaan: ");
        String nama = input.nextLine();
        System.out.print("Email: ");
        String email = input.nextLine();
        System.out.print("Nama Kontak: ");
        String nk = input.nextLine();

        pemasokService.updatePemasok(new Pemasok(id,nama, email, nk));
    }

    public void hapus(){
        System.out.println("=== Hapus Pemasok ===");
        System.out.print("ID: ");
        String id = input.nextLine();

        if (pemasokService.hapusPemasok(id)){
            System.out.println("Berhasil Hapus Data: " + id);
        }else {
            System.out.println("ID tidak ditemukan");
        }
    }

    public void cariById(){
        System.out.println("=== Cari Data dengan ID ===");
        System.out.print("ID: ");
        String id = input.nextLine();

        Pemasok pemasok = pemasokService.cariPemasokById(id);
        if (pemasok != null){
            System.out.println("=== Data Pemasok ===");
            System.out.println("ID              : " + pemasok.getIdPemasok());
            System.out.println("Nama Perusahaan : " + pemasok.getNama());
            System.out.println("Email           : " + pemasok.getEmail());
            System.out.println("Nama Kontak     : " + pemasok.getNamaKontak());
        }else {
            System.out.println("Data Pemasok tidak ditemukan");
        }
    }

    public void menampilkanData(){
        List<Pemasok> model = pemasokService.tampilkanSemua();
        System.out.println("\n--DATA PEMASOK--");
        System.out.printf("| %-10s | %-40s | %-25s | %-20s |\n",
                "ID", "Nama Perusahaan", "Email", "Nama Kontak");
        System.out.println("------------------------------------------------------------------------------------------------------------");

        for (Pemasok p : model) {
            System.out.printf("| %-10s | %-40s | %-25s | %-20s |\n",
                    p.getIdPemasok(),
                    p.getNama(),
                    p.getEmail(),
                    p.getNamaKontak());
        }
        System.out.println("------------------------------------------------------------------------------------------------------------");
    }
}
