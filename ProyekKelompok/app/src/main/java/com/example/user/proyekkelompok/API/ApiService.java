package com.example.user.proyekkelompok.API;

import java.util.List;
import com.example.user.proyekkelompok.Model.ModelData;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


/**
 * Created by User on 5/13/2019.
 */

public interface ApiService {
    @FormUrlEncoded
    @POST("/proyekkelompok/tambah_data.php")
    Call<ResponseBody> tambahData(@Field("namalengkap_kar") String namalengkap, @Field("email_kar") String email,@Field("umur_kar") String umur,
                                  @Field("tgllahir_kar") String tgllahir,@Field("alamat_kar") String alamat,@Field("notlp_kar") String notlp,
                                  @Field("jeniskelamin_kar") String jeniskelamin,@Field("pendidikan_kar") String pendidikan,@Field("pengalaman_kar") String pengalaman,
                                  @Field("posisi_kar") String posisi,@Field("motivasi_kar") String motivasi);

    @FormUrlEncoded
    @POST("proyekkelompok/edit_data.php")
    Call<ResponseBody> editData(@Field("namalengkap_kar") String namalengkap, @Field("email_kar") String email,@Field("umur_kar") String umur,
                                @Field("tgllahir_kar") String tgllahir,@Field("alamat_kar") String alamat,@Field("notlp_kar") String notlp,
                                @Field("jeniskelamin_kar") String jeniskelamin,@Field("pendidikan_kar") String pendidikan,@Field("pengalaman_kar") String pengalaman,
                                @Field("posisi_kar") String posisi,@Field("motivasi_kar") String motivasi);
    //
    @FormUrlEncoded
    @POST("proyekkelompok/hapus_data.php")
    Call<ResponseBody> hapusData(@Field("id_kar") String id_kar);

    @GET("proyekkelompok/lihat_data.php")
    Call<List<ModelData>> getSemuaKar();

    @GET("proyekkelompok/single_data.php")
    Call<List<ModelData>> getSingleData(@Query("id_kar") String id);

}
