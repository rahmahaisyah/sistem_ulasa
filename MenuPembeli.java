package com.method.main;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuPembeli implements Menu {
    final private Pembeli pembeli;
    private Scanner scanner;
    private ArrayList<RewardUlasan> daftarReward;

    public MenuPembeli(Pembeli pembeli) {
        this.pembeli = pembeli;
        this.scanner = new Scanner(System.in);
        this.daftarReward = new ArrayList<>();
    }

    @Override
    public void tampilkanMenu() {
        System.out.println("=== Menu Pembeli ===");
        System.out.println("1. Lihat Produk");
        System.out.println("2. Lihat Rating Produk");
        System.out.println("3. Beli Produk");
        System.out.println("4. Berikan Rating");
        System.out.println("5. Tampilkan Reward");
        System.out.println("6. Profil");
        System.out.println("7. Keluar");
    }

    @Override
public void aksi() {
    int pilihan;

    while (true) {
        tampilkanMenu();
        System.out.print("Pilih aksi: ");
        pilihan = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        switch (pilihan) {
            case 1:
                Produk.tampilkanSemuaProduk();
                break;
            case 2:
                lihatRatingProduk();
                break;
           // case 3:
              //  beliProduk();
               // break;
            case 4:
                System.out.print("Masukkan nama produk untuk memberikan rating: ");
                String namaProduk = scanner.nextLine();
                //berikanRating(namaProduk);
                break;
            case 5:
                tampilkanReward();
                break;
            case 6:
                pembeli.jenisPengguna();  
                break;
            case 7:
                System.out.println("Keluar dari menu pembeli.");
                return;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }
}


    private void lihatProduk() {
        System.out.println("=== Daftar Produk ===");
        
    }

    private void lihatRatingProduk() {
        System.out.print("Masukkan nama produk untuk melihat rating: ");
        String namaProduk = scanner.nextLine();
        double rating = Produk.cekRatingProduk(namaProduk);
        if (rating != -1) {
            System.out.println("Rating produk " + namaProduk + ": " + rating + " bintang");
        } else {
            System.out.println("Produk tidak ditemukan.");
        }
    }

    private void beliProduk() {
        System.out.print("Masukkan nama produk yang ingin dibeli: ");
        String namaProduk = scanner.nextLine();
        boolean berhasil = Produk.beliProduk(namaProduk);
        if (berhasil) {
            System.out.println("Produk " + namaProduk + " berhasil dibeli.");
            beriRatingProduk(namaProduk);
        } else {
            System.out.println("Produk tidak ditemukan atau gagal membeli produk.");
        }
    }

    private void beriRatingProduk(String namaProduk) {
        System.out.print("Berikan rating untuk produk " + namaProduk + " (1-5): ");
        int rating = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        if (rating >= 1 && rating <= 5) {
            boolean berhasil = Produk.berikanRating(namaProduk, rating, pembeli.getNama());
            if (berhasil) {
                System.out.println("Rating " + rating + " berhasil diberikan untuk produk " + namaProduk + ".");
                RewardUlasan reward = new RewardUlasan(pembeli.getNama(), "Ulasan produk " + namaProduk, rating);
                daftarReward.add(reward);
            } else {
                System.out.println("Gagal memberikan rating.");
            }
        } else {
            System.out.println("Rating harus antara 1 dan 5.");
        }
    }

    private void tampilkanReward() {
        System.out.println("=== Daftar Reward ===");
        if (daftarReward.isEmpty()) {
            System.out.println("Belum ada reward.");
        } else {
            for (RewardUlasan reward : daftarReward) {
                reward.tampilkanReward();
                System.out.println("---------------------------");
            }
        }
    }
}


