package com.example.user.proyekkelompok.Model;

/**
 * Created by User on 5/13/2019.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelData {

    @SerializedName("id_kar")
    @Expose
    private String idKar;

    @SerializedName("namalengkap_kar")
    @Expose
    private String namalengkap;

    @SerializedName("email_kar")
    @Expose
    private String email_kar;

    @SerializedName("umur_kar")
    @Expose
    private String umur_kar;

    @SerializedName("tgllahir_kar")
    @Expose
    private String tgllahir_kar;

    @SerializedName("alamat_kar")
    @Expose
    private String alamat_kar;

    @SerializedName("notlp_kar")
    @Expose
    private String notlp_kar;

    @SerializedName("jeniskelamin_kar")
    @Expose
    private String jeniskelamin_kar;

    @SerializedName("pendidikan_kar")
    @Expose
    private String pendidikan_kar;

    @SerializedName("pengalaman_kar")
    @Expose
    private String pengalaman_kar;

    @SerializedName("posisi_kar")
    @Expose
    private String posisi_kar;

    @SerializedName("motivasi_kar")
    @Expose
    private String motivasi_kar;




    public static final String id_karyawan = "ID_MAHASISWA";
    public static final String namalengkap_karyawan = "ID_MAHASISWA";
    public static final String email_karyawan = "ID_MAHASISWA";
    public static final String umur_karyawan = "ID_MAHASISWA";
    public static final String tgllahir_karyawan = "ID_MAHASISWA";
    public static final String alamat_karyawan = "ID_MAHASISWA";
    public static final String notlp_karyawan = "ID_MAHASISWA";
    public static final String jeniskelamin_karyawan = "ID_MAHASISWA";
    public static final String pendidikan_karyawan = "ID_MAHASISWA";
    public static final String pengalaman_karyawan = "ID_MAHASISWA";
    public static final String posisi_karyawan = "ID_MAHASISWA";
    public static final String motivasi_karyawan = "ID_MAHASISWA";
    public static final String cv_karyawan = "ID_MAHASISWA";

    public ModelData(String id, String namalengkap, String email_kar, String umur_kar, String tgllahir_kar, String alamat_kar, String notlp_kar,
                     String jeniskelamin_kar, String pendidikan_kar, String pengalaman_kar, String posisi_kar, String motivasi_kar) {
        this.idKar = id;
        this.namalengkap = namalengkap;
        this.email_kar = email_kar;
        this.umur_kar = umur_kar;
        this.tgllahir_kar = tgllahir_kar;
        this.alamat_kar = alamat_kar;
        this.notlp_kar = notlp_kar;
        this.jeniskelamin_kar = jeniskelamin_kar;
        this.pendidikan_kar = pendidikan_kar;
        this.pengalaman_kar = pengalaman_kar;
        this.posisi_kar = posisi_kar;
        this.motivasi_kar = motivasi_kar;

    }

    public String getIdKar() {
        return idKar;
    }

    public void setIdKar(String idKar) {
        this.idKar = idKar;
    }

    public String getNamalengkap() {
        return namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        this.namalengkap = namalengkap;
    }

    public String getEmail_kar() {
        return email_kar;
    }

    public void setEmail_kar(String email_kar) {
        this.email_kar = email_kar;
    }

    public String getUmur_kar() {
        return umur_kar;
    }

    public void setUmur_kar(String umur_kar) {
        this.umur_kar = umur_kar;
    }

    public String getTgllahir_kar() {
        return tgllahir_kar;
    }

    public void setTgllahir_kar(String tgllahir_kar) {
        this.tgllahir_kar = tgllahir_kar;
    }

    public String getAlamat_kar() {
        return alamat_kar;
    }

    public void setAlamat_kar(String alamat_kar) {
        this.alamat_kar = alamat_kar;
    }

    public String getNotlp_kar() {
        return notlp_kar;
    }

    public void setNotlp_kar(String notlp_kar) {
        this.notlp_kar = notlp_kar;
    }

    public String getJeniskelamin_kar() {
        return jeniskelamin_kar;
    }

    public void setJeniskelamin_kar(String jeniskelamin_kar) {
        this.jeniskelamin_kar = jeniskelamin_kar;
    }

    public String getPendidikan_kar() {
        return pendidikan_kar;
    }

    public void setPendidikan_kar(String pendidikan_kar) {
        this.pendidikan_kar = pendidikan_kar;
    }

    public String getPengalaman_kar() {
        return pengalaman_kar;
    }

    public void setPengalaman_kar(String pengalaman_kar) {
        this.pengalaman_kar = pengalaman_kar;
    }

    public String getPosisi_kar() {
        return posisi_kar;
    }

    public void setPosisi_kar(String posisi_kar) {
        this.posisi_kar = posisi_kar;
    }

    public String getMotivasi_kar() {
        return motivasi_kar;
    }

    public void setMotivasi_kar(String motivasi_kar) {
        this.motivasi_kar = motivasi_kar;
    }




}