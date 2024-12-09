package com.method.main;

public class Komentar {
    private String pengguna;
    private String komentarText;
    private String tanggalKomentar;

    public Komentar(String pengguna, String komentarText, String tanggalKomentar) {
        this.pengguna = pengguna;
        this.komentarText = komentarText;
        this.tanggalKomentar = tanggalKomentar;
    }

    // Getter dan Setter
    public String getPengguna() {
        return pengguna;
    }

    public void setPengguna(String pengguna) {
        this.pengguna = pengguna;
    }

    public String getKomentarText() {
        return komentarText;
    }

    public void setKomentarText(String komentarText) {
        this.komentarText = komentarText;
    }

    public String getTanggalKomentar() {
        return tanggalKomentar;
    }

    public void setTanggalKomentar(String tanggalKomentar) {
        this.tanggalKomentar = tanggalKomentar;
    }

    // Menampilkan komentar
    public void tampilkanKomentar() {
        System.out.println("Pengguna          : " + pengguna);
        System.out.println("Komentar          : " + komentarText);
        System.out.println("Tanggal Komentar  : " + tanggalKomentar);
    }
}
