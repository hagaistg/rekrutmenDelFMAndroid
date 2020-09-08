package com.example.user.proyekkelompok.program;

public class Model {
    String id;
    String name;
    String harga;
    String email;
    String gender;
    String interest;
    String course;

    public Model(String id, String name, String harga, String email, String gender, String interest, String course) {
        this.id = id;
        this.name = name;
        this.harga = harga;
        this.email = email;
        this.gender = gender;
        this.interest = interest;
        this.course = course;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}