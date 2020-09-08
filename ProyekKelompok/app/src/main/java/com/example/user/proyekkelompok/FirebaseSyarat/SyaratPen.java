package com.example.user.proyekkelompok.FirebaseSyarat;

import java.io.Serializable;

/**
 * Created by User on 5/14/2019.
 */

public class SyaratPen implements Serializable {
    private String nama;
    private String deskripsi;
    private String key;

    public SyaratPen() {

    }
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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
        return " "+nama+"\n" +
                " "+deskripsi;
    }

    public SyaratPen(String nama, String deskripsi) {
        this.nama = nama;
        this.deskripsi = deskripsi;

    }
}
