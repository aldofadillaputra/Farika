package com.example.farika.Model;

public class BatchingPlant {
    String id_bp;
    String nama_bp;
    String alamat_bp;
    String gambar_bp;

    public BatchingPlant() {
    }

    public BatchingPlant(String id_bp, String nama_bp, String alamat_bp, String gambar_bp) {
        this.id_bp = id_bp;
        this.nama_bp = nama_bp;
        this.alamat_bp = alamat_bp;
        this.gambar_bp = gambar_bp;
    }

    public String getId_bp() {
        return id_bp;
    }

    public String getNama_bp() {
        return nama_bp;
    }

    public String getAlamat_bp() {
        return alamat_bp;
    }

    public String getGambar_bp() {
        return gambar_bp;
    }

    public void setId_bp(String id_bp) {
        this.id_bp = id_bp;
    }

    public void setNama_bp(String nama_bp) {
        this.nama_bp = nama_bp;
    }

    public void setAlamat_bp(String alamat_bp) {
        this.alamat_bp = alamat_bp;
    }

    public void setGambar_bp(String gambar_bp) {
        this.gambar_bp = gambar_bp;
    }
}
