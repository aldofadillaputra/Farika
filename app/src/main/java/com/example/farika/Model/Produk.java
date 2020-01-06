package com.example.farika.Model;

public class Produk {
    String id_produk;
    String nama_produk;
    String deskripsi_produk;
    String gambar_produk;

    public Produk(){

    }

    public Produk(String id_produk, String nama_produk, String deskripsi_produk, String gambar_produk) {
        this.id_produk = id_produk;
        this.nama_produk = nama_produk;
        this.deskripsi_produk = deskripsi_produk;
        this.gambar_produk = gambar_produk;
    }

    public String getId_produk(){
        return id_produk;
    }

    public String getNama_produk(){
        return nama_produk;
    }

    public String getDeskripsi_produk() {
        return deskripsi_produk;
    }

    public String getGambar_produk() {
        return gambar_produk;
    }

    public void setId_produk(String id_produk) {
        this.id_produk = id_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public void setDeskripsi_produk(String deskripsi_produk) {
        this.deskripsi_produk = deskripsi_produk;
    }

    public void setGambar_produk(String gambar_produk) {
        this.gambar_produk = gambar_produk;
    }
}
