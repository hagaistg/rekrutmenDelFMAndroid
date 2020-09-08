package com.example.user.proyekkelompok.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.user.proyekkelompok.Model.ModelData;
import com.example.user.proyekkelompok.R;

import java.util.ArrayList;

/**
 * Created by User on 5/13/2019.
 */

public class ListArrayAdapter extends ArrayAdapter<ModelData> {

    private ArrayList<ModelData> list;
    private LayoutInflater inflater;
    private int res;

    public ListArrayAdapter(Context context, int resource, ArrayList<ModelData> list) {
        super(context, resource, list);
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.res = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        MyHolder holder = null;


        if (convertView == null) {

            convertView = inflater.inflate(res, parent, false);

            holder = new MyHolder();

            holder.ID = (TextView) convertView.findViewById(R.id.listID);
            holder.IDPUSH = (TextView) convertView.findViewById(R.id.listID1);
            holder.Nama = (TextView) convertView.findViewById(R.id.listNamaKar);
            holder.Email = (TextView) convertView.findViewById(R.id.listEmailKar);
//            holder.Umur = (TextView) convertView.findViewById(R.id.listUmurKar);
//            holder.Tgllahir = (TextView) convertView.findViewById(R.id.listTgllahirKar);
//            holder.Alamat = (TextView) convertView.findViewById(R.id.listAlamatKar);
//            holder.Notlp = (TextView) convertView.findViewById(R.id.listNotlpKar);
//            holder.Jeniskelamin = (TextView) convertView.findViewById(R.id.listJenisKar);
//            holder.Pendidikan = (TextView) convertView.findViewById(R.id.listPendidikanKar);
//            holder.Pengalaman = (TextView) convertView.findViewById(R.id.listPengalamanKar);
//            holder.Posisi = (TextView) convertView.findViewById(R.id.listPosisiKar);
//            holder.Motivasi = (TextView) convertView.findViewById(R.id.listMotivasiKar);
//            holder.Cv = (TextView) convertView.findViewById(R.id.listCvKar);

            convertView.setTag(holder);

        } else {

            holder = (MyHolder) convertView.getTag();
        }

        holder.ID.setText("No : "+list.get(position).getIdKar());
        holder.IDPUSH.setText(list.get(position).getIdKar());
        holder.Nama.setText("Nama Calon Karyawan: "+list.get(position).getNamalengkap());
        holder.Email.setText("Email : "+list.get(position).getEmail_kar());
//        holder.Umur.setText("Umur : "+list.get(position).getUmur_kar());
//        holder.Tgllahir.setText("Tanggal Lahir : "+list.get(position).getTgllahir_kar());
//        holder.Alamat.setText("Alamat : "+list.get(position).getAlamat_kar());
//        holder.Notlp.setText("No telepon: "+list.get(position).getNotlp_kar());
//        holder.Jeniskelamin.setText("Jenis Kelamin: "+list.get(position).getJeniskelamin_kar());
//        holder.Pendidikan.setText("Pendidikan : "+list.get(position).getPendidikan_kar());
//        holder.Pengalaman.setText("Pengalaman: "+list.get(position).getPengalaman_kar());
//        holder.Posisi.setText("Posisi : "+list.get(position).getPosisi_kar());
//        holder.Motivasi.setText("Motivasi : "+list.get(position).getMotivasi_kar());
//        holder.Cv.setText("CV : "+list.get(position).getCv_kar());


        return convertView;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public void remove(ModelData object) {
        super.remove(object);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    static class MyHolder {

        TextView ID;
        TextView IDPUSH;
        TextView Nama;
        TextView Email;
//        TextView Umur;
//        TextView Tgllahir;
//        TextView Alamat;
//        TextView Notlp;
//        TextView Jeniskelamin;
//        TextView Pendidikan;
//        TextView Pengalaman;
//        TextView Posisi;
//        TextView Motivasi;
//        TextView Cv;



    }
}
