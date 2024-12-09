package com.method.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Pembeli extends Pengguna {
    private static ArrayList<Pembeli> daftarPembeli = new ArrayList<Pembeli>() {{
        add(new Pembeli("Rahmah Aisyah", "rahmah", "123", "081234567890"));
        add(new Pembeli("Dhea Sri Noor Septianiz", "dheasrinoorseptianiz@gmail.com", "dhea123", "081234567891"));
    }};

    public Pembeli(String nama, String email, String password, String nomorTelepon) {
        super(nama, email, password, nomorTelepon);
    }

    @Override
    public void jenisPengguna(){
        System.out.println("[=== PEMBELI ===]");
        super.tampilkanProfil();
    }

    // Method untuk menambahkan pembeli ke daftar
    public static void tambahPembeli(Pembeli pembeli) {
        daftarPembeli.add(pembeli);
    }

    // Method untuk mencari pembeli berdasarkan email
    public static Pembeli cariPembeli(String email) {
        for (Pembeli pembeli : daftarPembeli) {
            if (pembeli.getEmail().equals(email)) {
                return pembeli;
            }
        }
        return null;
    }
    
    public static Menu loginPembeli(Scanner scan) {
        System.out.print("Masukkan email Pembeli: ");
        String email = scan.nextLine();
        System.out.print("Masukkan password Pembeli: ");
        String password = scan.nextLine();

        Pembeli pembeli = cariPembeli(email);
        if (pembeli != null && pembeli.login(email, password)) {
            pembeli.jenisPengguna(); 
            return new MenuPembeli(pembeli);
        } else {
            System.out.println("Email atau password salah.");
            return null;
        }
    }
}


