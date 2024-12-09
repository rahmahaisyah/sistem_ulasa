package com.method.main;

import java.util.ArrayList;


public class Penjual extends Pengguna implements LaporUlasan {
    private static ArrayList<Penjual> daftarPenjual = new ArrayList<>();

    public Penjual(String nama, String email, String password, String nomorTelepon) {
        super(nama, email, password, nomorTelepon);
    }

    @Override
    public void jenisPengguna(){
        System.out.println("[=== PENJUAL ===]");
        super.tampilkanProfil();
    }

    // Method untuk menambahkan penjual ke daftar
    public static void tambahPenjual(Penjual penjual) {
        daftarPenjual.add(penjual);
    }

    // Method untuk mencari penjual berdasarkan email
    public static Penjual cariPenjual(String email) {
        for (Penjual penjual : daftarPenjual) {
            if (penjual.getEmail().equals(email)) {
                return penjual;
            }
        }
        return null;
    }

    @Override
    public void LaporUlasan() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

