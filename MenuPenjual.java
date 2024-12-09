package com.method.main;

import java.util.Scanner;

public class MenuPenjual implements Menu {
    private Penjual penjual;
    private Scanner scanner;

    public MenuPenjual(Penjual penjual) {
        this.penjual = penjual;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void tampilkanMenu() {
        System.out.println("=== Menu Penjual ===");
        System.out.println("1. Tambah Produk");
        System.out.println("2. Lihat Daftar Produk");
        System.out.println("3. Balas Ulasan");
        System.out.println("4. Hapus Produk");
        System.out.println("5. Tampilkan Profil");
        System.out.println("6. Keluar");
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
                    tambahProduk();
                    break;
                case 2:
                    lihatProduk();
                    break;
                case 3:
                    balasUlasan();
                    break;
                case 4:
                    hapusProduk();
                    break;
                case 5:
                    penjual.tampilkanProfil();
                    break;
                case 6:
                    System.out.println("Keluar dari menu penjual.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void tambahProduk() {
        System.out.println("=== Tambah Produk ===");
        System.out.print("Nama Produk: ");
        String nama = scanner.nextLine();

        System.out.print("Harga Produk: ");
        int harga = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        System.out.print("Deskripsi Produk: ");
        String deskripsi = scanner.nextLine();

        Produk produk = new Produk(nama, harga, deskripsi);
        Produk.tambahProduk(produk);
        System.out.println("Produk berhasil ditambahkan!\n");
    }

    private void lihatProduk() {
        System.out.println("=== Daftar Produk ===");
        Produk.tampilkanSemuaProduk();
    }

    private void balasUlasan() {
        System.out.println("=== Balas Ulasan ===");
        // Implementasi logika balas ulasan
        System.out.println("Fitur ini masih dalam pengembangan.");
    }

    private void hapusProduk() {
        System.out.print("Masukkan nama produk yang ingin dihapus: ");
        String namaProduk = scanner.nextLine();
        boolean berhasil = Produk.hapusProduk(namaProduk);
        if (berhasil) {
            System.out.println("Produk " + namaProduk + " berhasil dihapus.");
        } else {
            System.out.println("Produk tidak ditemukan atau gagal dihapus.");
        }
    }
}

