package com.method.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        Penjual penjual1 = new Penjual("Bob", "bob@example.com", "password123", "081298765432");
        Penjual.tambahPenjual(penjual1);

        Moderator moderator1 = new Moderator("Charlie", "charlie@example.com", "password123", "081212345678", "Konten Negatif");
        Moderator.tambahModerator(moderator1);

        // Verifikasi Pembeli
//        System.out.println("\n=== Daftar Pembeli Terdaftar ===");
//        for (Pembeli pembeli : Pembeli.getDaftarPembeli()) {
//            System.out.println("Nama: " + pembeli.getNama() + ", Email: " + pembeli.getEmail());
//        }
//        System.out.println("==================================\n");

        System.out.println("========== Sistem Ulasan Toko ==========");
        System.out.println("1. Login sebagai Pembeli");
        System.out.println("2. Login sebagai Penjual");
        System.out.println("3. Login sebagai Moderator");
        System.out.println("4. Registrasi sebagai Pembeli");
        System.out.print("Pilih: ");
        if (!scan.hasNextInt()) {
            System.out.println("Input harus berupa angka.");
            return;
        }
        int pilihan = scan.nextInt();
        scan.nextLine(); // Clear buffer

        Menu menu = null;

        switch (pilihan) {
            case 1:
                menu = loginPembeli(scan);
                break;
            case 2:
                menu = loginPenjual(scan);
                break;
            case 3:
                menu = loginModerator(scan);
                break;
            case 4:
                registrasiPembeli(scan);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }

        if (menu != null) {
            menu.aksi();
        }

        scan.close();
    }

    public static Menu loginPembeli(Scanner scan) {
        System.out.print("Masukkan email Pembeli: ");
        String email = scan.nextLine();
        System.out.print("Masukkan password Pembeli: ");
        String password = scan.nextLine();

        Pembeli pembeli = Pembeli.cariPembeli(email);
        if (pembeli != null && pembeli.login(email, password)) {
            System.out.println("Login berhasil sebagai Pembeli");
            return new MenuPembeli(pembeli);
        } else {
            System.out.println("Email atau password salah.");
            return null;
        }
    }

    public static Menu loginPenjual(Scanner scan) {
        System.out.print("Masukkan email Penjual: ");
        String email = scan.nextLine();
        System.out.print("Masukkan password Penjual: ");
        String password = scan.nextLine();

        Penjual penjual = Penjual.cariPenjual(email);
        if (penjual != null && penjual.login(email, password)) {
            System.out.println("Login berhasil sebagai Penjual");
            return new MenuPenjual(penjual);
        } else {
            System.out.println("Email atau password salah.");
            return null;
        }
    }

    public static Menu loginModerator(Scanner scan) {
        System.out.print("Masukkan email Moderator: ");
        String email = scan.nextLine();
        System.out.print("Masukkan password Moderator: ");
        String password = scan.nextLine();

        Moderator moderator = Moderator.cariModerator(email);
        if (moderator != null && moderator.login(email, password)) {
            System.out.println("Login berhasil sebagai Moderator");
            return new MenuModerator(moderator);
        } else {
            System.out.println("Email atau password salah.");
            return null;
        }
    }

    public static void registrasiPembeli(Scanner scan) {
        System.out.println("=== Registrasi Pembeli ===");
        System.out.print("Masukkan nama Pembeli: ");
        String nama = scan.nextLine();
        System.out.print("Masukkan email Pembeli: ");
        String email = scan.nextLine();
        System.out.print("Masukkan password Pembeli: ");
        String password = scan.nextLine();
        System.out.print("Masukkan nomor telepon Pembeli: ");
        String nomorTelepon = scan.nextLine();

        // Cek apakah email sudah digunakan
        Pembeli existingPembeli = Pembeli.cariPembeli(email);
        if (existingPembeli != null) {
            System.out.println("Email sudah terdaftar. Silakan gunakan email lain.");
            return;
        }

        Pembeli pembeli = new Pembeli(nama, email, password, nomorTelepon);
        Pembeli.tambahPembeli(pembeli);
        System.out.println("Registrasi berhasil! Anda dapat login sekarang.");
    }
}

