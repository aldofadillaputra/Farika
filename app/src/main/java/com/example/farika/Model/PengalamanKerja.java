package com.example.farika.Model;

public class PengalamanKerja {
    String id_pk, nama_pk, deskripsi_pk, gambar_pk;

    public PengalamanKerja() {
    }

    public PengalamanKerja(String id_pk, String nama_pk, String deskripsi_pk, String gambar_pk) {
        this.id_pk = id_pk;
        this.nama_pk = nama_pk;
        this.deskripsi_pk = deskripsi_pk;
        this.gambar_pk = gambar_pk;
    }

    public String getId_pk() {
        return id_pk;
    }

    public void setId_pk(String id_pk) {
        this.id_pk = id_pk;
    }

    public String getNama_pk() {
        return nama_pk;
    }

    public void setNama_pk(String nama_pk) {
        this.nama_pk = nama_pk;
    }

    public String getDeskripsi_pk() {
        return deskripsi_pk;
    }

    public void setDeskripsi_pk(String deskripsi_pk) {
        this.deskripsi_pk = deskripsi_pk;
    }

    public String getGambar_pk() {
        return gambar_pk;
    }

    public void setGambar_pk(String gambar_pk) {
        this.gambar_pk = gambar_pk;
    }
}
