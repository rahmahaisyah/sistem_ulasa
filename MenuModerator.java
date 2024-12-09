package com.method.main;
import java.util.Scanner;

public class MenuModerator implements Menu {
    private Moderator moderator;
    private Scanner scanner;

    public MenuModerator(Moderator moderator) {
        this.moderator = moderator;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void tampilkanMenu() {
        System.out.println("=== Menu Moderator ===");
        System.out.println("1. Lihat laporan");
        System.out.println("2. Hapus Ulasan");
        System.out.println("3. Hapus Komentar");
        System.out.println("4. Lihat Daftar Produk");
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
                    lihatLaporan();
                case 2:
                    hapusUlasan();
                    break;
                case 3:
                    hapusKomentar();
                    break;
                case 4:
                    lihatProduk();
                    break;
                case 5:
                    moderator.tampilkanProfil();
                    break;
                case 6:
                    System.out.println("Keluar dari menu moderator.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void hapusUlasan() {
        System.out.print("Masukkan ID ulasan yang ingin dihapus: ");
        String ulasanId = scanner.nextLine();
        moderator.hapusUlasan(ulasanId);
    }

    private void hapusKomentar() {
        System.out.print("Masukkan ID komentar yang ingin dihapus: ");
        String komentarId = scanner.nextLine();
        moderator.hapusKomentar(komentarId);
    }

    private void lihatProduk() {
        System.out.println("=== Daftar Produk ===");
        Produk.tampilkanSemuaProduk();
    }
    
    private void lihatLaporan() {
        System.out.println("=== Daftar Laporan ===");
    }
}

