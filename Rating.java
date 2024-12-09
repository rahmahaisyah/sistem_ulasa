package com.method.main;

public class Rating {
    private String pengguna;
    private String ulasan;
    private int ratingBintang;

    public Rating(String pengguna, String ulasan, int ratingBintang) {
        this.pengguna = pengguna;
        this.ulasan = ulasan;
        this.ratingBintang = ratingBintang;
    }

    // Getter dan Setter
    public String getPengguna() {
        return pengguna;
    }

    public void setPengguna(String pengguna) {
        this.pengguna = pengguna;
    }

    public String getUlasan() {
        return ulasan;
    }

    public void setUlasan(String ulasan) {
        this.ulasan = ulasan;
    }

    public int getRatingBintang() {
        return ratingBintang;
    }

    public void setRatingBintang(int ratingBintang) {
        if (ratingBintang >= 1 && ratingBintang <= 5) {
            this.ratingBintang = ratingBintang;
        } else {
            System.out.println("Rating harus antara 1 dan 5.");
        }
    }

    // Menampilkan rating
    public void displayRating() {
        System.out.println("Pengguna      : " + pengguna);
        System.out.println("Ulasan        : " + ulasan);
        System.out.println("Rating        : " + ratingBintang + " bintang");
    }
}