package com.example.user.proyekkelompok.FirebaseBerita;

import com.example.user.proyekkelompok.Berita;

import java.io.Serializable;

/**
 * Created by User on 5/14/2019.
 */

public class BeritaPen implements Serializable {
    private String judul;
    private String topik;
    private String tanggal;
    private String deskripsi;
    private String key;

    public BeritaPen() {

    }
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTopik() {
        return topik;
    }

    public void setTopik(String topik) {
        this.topik = topik;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    @Override
    public String toString() {
        return " "+judul+"\n" +
                " "+topik+"\n" +
                " "+tanggal+"\n" +
                " "+deskripsi;
    }

    public BeritaPen(String judul, String topik, String tanggal, String deskripsi) {
        this.judul = judul;
        this.topik = topik;
        this.tanggal = tanggal;
        this.deskripsi = deskripsi;
    }
}
