/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.method.main;

import java.util.ArrayList;

/**
 *
 * @author Dhea Sri Noor Septianiz
 */

public class Produk {
    private String nama;
    private int harga;
    private String deskripsi;
    private static ArrayList<Produk> daftarProduk = new ArrayList<>(){{
        add(new Produk("Laptop ABC", 5000000, "Laptop dengan spesifikasi tinggi dan desain elegan."));
        add(new Produk("Headphone DEF", 300000, "Headphone dengan kualitas suara terbaik dan nyaman digunakan."));
    }};
    private static ArrayList<Rating> daftarRating = new ArrayList<>();

    public Produk(String nama, int harga, String deskripsi) {
        this.nama = nama;
        this.harga = harga;
        this.deskripsi = deskripsi;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    // Menambahkan produk ke daftar
    public static void tambahProduk(Produk produk) {
        daftarProduk.add(produk);
    }

    // Menghapus produk berdasarkan nama
    public static boolean hapusProduk(String namaProduk) {
        for (Produk produk : daftarProduk) {
            if (produk.getNama().equalsIgnoreCase(namaProduk)) {
                daftarProduk.remove(produk);
                return true;
            }
        }
        return false;
    }

    // Menampilkan semua produk
    public static void tampilkanSemuaProduk() {
        if (daftarProduk.isEmpty()) {
            System.out.println("Tidak ada produk yang tersedia.");
        } else {
            for (Produk produk : daftarProduk) {
                produk.tampilkanInfo();
                System.out.println("---------------------------");
            }
        }
    }

    // Method untuk membeli produk (dummy implementation)
    public static boolean beliProduk(String namaProduk) {
        for (Produk produk : daftarProduk) {
            if (produk.getNama().equalsIgnoreCase(namaProduk)) {
                // Implementasi logika pembelian
                return true;
            }
        }
        return false;
    }

    // Method untuk memberikan rating
    public static boolean berikanRating(String namaProduk, int rating, String pengguna) {
        for (Produk produk : daftarProduk) {
            if (produk.getNama().equalsIgnoreCase(namaProduk)) {
                Rating newRating = new Rating(pengguna, "Ulasan produk " + namaProduk, rating);
                daftarRating.add(newRating);
                return true;
            }
        }
        return false;
    }

    // Method untuk cek rating produk
    public static double cekRatingProduk(String namaProduk) {
        int totalRating = 0;
        int jumlahRating = 0;
        for (Rating rating : daftarRating) {
            if (rating.getUlasan().contains(namaProduk)) {
                totalRating += rating.getRatingBintang();
                jumlahRating++;
            }
        }
        if (jumlahRating > 0) {
            return (double) totalRating / jumlahRating;
        } else {
            return -1;
        }
    }

    // Menampilkan informasi produk
    public void tampilkanInfo() {
        System.out.println("Nama Produk : " + nama);
        System.out.println("Harga       : Rp" + harga);
        System.out.println("Deskripsi   : " + deskripsi);
    }
}