package com.method.main;

import java.util.ArrayList;

public class Moderator extends Pengguna {
    private String areaTugas; // Contoh: kategori produk, lokasi, jenis konten
    private int jumlahUlasanDihapus;
    private int jumlahKomentarDihapus;
    private static ArrayList<Moderator> daftarModerator = new ArrayList<>();

    public Moderator(String nama, String email, String password, String nomorTelepon, String areaTugas) {
        super(nama, email, password, nomorTelepon);
        this.areaTugas = areaTugas;
        this.jumlahUlasanDihapus = 0;
        this.jumlahKomentarDihapus = 0;
    }

    @Override
    public void jenisPengguna(){
        System.out.println("[=== MODERATOR ===]");
        super.tampilkanProfil();
    }

    // Method untuk menambahkan moderator ke daftar
    public static void tambahModerator(Moderator moderator) {
        daftarModerator.add(moderator);
    }

    // Method untuk mencari moderator berdasarkan email
    public static Moderator cariModerator(String email) {
        for (Moderator moderator : daftarModerator) {
            if (moderator.getEmail().equals(email)) {
                return moderator;
            }
        }
        return null;
    }

    // Getter dan Setter untuk areaTugas
    public String getAreaTugas() {
        return areaTugas;
    }

    public void setAreaTugas(String areaTugas) {
        if (areaTugas != null && !areaTugas.isEmpty()) {
            this.areaTugas = areaTugas;
        } else {
            System.out.println("Area tugas tidak valid.");
        }
    }

    public int getJumlahUlasanDihapus() {
        return jumlahUlasanDihapus;
    }

    public int getJumlahKomentarDihapus() {
        return jumlahKomentarDihapus;
    }

    // Method untuk menghapus ulasan
    public void hapusUlasan(String ulasanId) {
        if (ulasanId != null && !ulasanId.isEmpty()) {
            System.out.println("Ulasan dengan ID " + ulasanId + " berhasil dihapus oleh moderator.");
            jumlahUlasanDihapus++;
        } else {
            System.out.println("ID ulasan tidak valid.");
        }
    }

    // Method untuk menghapus komentar
    public void hapusKomentar(String komentarId) {
        if (komentarId != null && !komentarId.isEmpty()) {
            System.out.println("Komentar dengan ID " + komentarId + " berhasil dihapus oleh moderator.");
            jumlahKomentarDihapus++;
        } else {
            System.out.println("ID komentar tidak valid.");
        }
    }

    // Overriding method tampilkanProfil
    @Override
    public void tampilkanProfil() {
        super.tampilkanProfil();
        System.out.println("Area Tugas            : " + areaTugas);
        System.out.println("Jumlah Ulasan Dihapus : " + jumlahUlasanDihapus);
        System.out.println("Jumlah Komentar Dihapus: " + jumlahKomentarDihapus);
    }
}
