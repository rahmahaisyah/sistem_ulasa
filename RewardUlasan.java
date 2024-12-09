package com.method.main;

public class RewardUlasan {
    private String pengguna;
    private String ulasan;
    private int rating;
    private String reward;

    public RewardUlasan(String pengguna, String ulasan, int rating) {
        this.pengguna = pengguna;
        this.ulasan = ulasan;
        this.rating = rating;
        this.reward = calculateReward(rating);
    }

    private String calculateReward(int rating) {
        if (rating == 5) {
            return "Diskon 20% untuk pembelian berikutnya";
        } else if (rating == 4) {
            return "Diskon 10% untuk pembelian berikutnya";
        } else if (rating == 3) {
            return "Poin reward 50";
        } else {
            return "Terima kasih atas ulasan Anda!";
        }
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
            this.reward = calculateReward(rating);
        } else {
            System.out.println("Rating harus antara 1 dan 5.");
        }
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    // Menampilkan reward
    public void tampilkanReward() {
        System.out.println("Pengguna : " + pengguna);
        System.out.println("Ulasan   : " + ulasan);
        System.out.println("Rating   : " + rating + " bintang");
        System.out.println("Reward   : " + reward);
    }
}