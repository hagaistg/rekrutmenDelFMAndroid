package com.example.user.proyekkelompok.Gambar;

/**
 * Created by User on 5/14/2019.
 */

public class GambarModel {
    private int id;
    private String name;

    private String area;
    private byte[] image;

    public GambarModel(int id, String name, String area, byte[] image) {
        this.id = id;
        this.name = name;

        this.area = area;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}

