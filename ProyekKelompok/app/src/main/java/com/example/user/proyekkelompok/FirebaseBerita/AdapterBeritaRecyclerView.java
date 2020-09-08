package com.example.user.proyekkelompok.FirebaseBerita;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.proyekkelompok.FirebaseSyarat.AdapterSyaratRecyclerView;
import com.example.user.proyekkelompok.FirebaseSyarat.CreateSyarat;
import com.example.user.proyekkelompok.FirebaseSyarat.ReadSingleSyarat;
import com.example.user.proyekkelompok.FirebaseSyarat.ReadSyarat;
import com.example.user.proyekkelompok.FirebaseSyarat.SyaratPen;
import com.example.user.proyekkelompok.R;

import java.util.ArrayList;

/**
 * Created by User on 5/14/2019.
 */

public class AdapterBeritaRecyclerView extends RecyclerView.Adapter<AdapterBeritaRecyclerView.ViewHolder> {

    private ArrayList<BeritaPen> daftarBarang;
    private Context context;
    AdapterBeritaRecyclerView.FirebaseDataListener listener;

    public AdapterBeritaRecyclerView(ArrayList<BeritaPen> barangs, Context ctx){
        /**
         * Inisiasi data dan variabel yang akan digunakan
         */
        daftarBarang = barangs;
        context = ctx;
        listener = (ReadBerita)ctx;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        /**
         * Inisiasi View
         * Di tutorial ini kita hanya menggunakan data String untuk tiap item
         * dan juga view nya hanyalah satu TextView
         */
        TextView tvTitle;
        CardView cvMain;

        ViewHolder(View v) {
            super(v);
            tvTitle = (TextView) v.findViewById(R.id.tv_judul);
            cvMain = (CardView) v.findViewById(R.id.cv_main);
        }
    }

    @Override
    public AdapterBeritaRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /**
         *  Inisiasi ViewHolder
         */
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_berita, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        AdapterBeritaRecyclerView.ViewHolder vh = new AdapterBeritaRecyclerView.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(AdapterBeritaRecyclerView.ViewHolder holder, final int position) {
        /**
         *  Menampilkan data pada view
         */
        final String name = daftarBarang.get(position).getJudul();
        System.out.println("BARANG DATA one by one "+position+daftarBarang.size());
        holder.cvMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 *  Kodingan untuk tutorial Selanjutnya :p Read detail data
                 */

                context.startActivity(ReadSingleBerita.getActIntent((Activity) context).putExtra("data", daftarBarang.get(position)));
            }
        });
        holder.cvMain.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                /**
                 *  Kodingan untuk tutorial Selanjutnya :p Delete dan update data
                 */
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_view2);
                dialog.setTitle("Pilih Aksi");
                dialog.show();

                Button editButton = (Button) dialog.findViewById(R.id.bt_edit_data);
                Button delButton = (Button) dialog.findViewById(R.id.bt_delete_data);

                //apabila tombol edit diklik
                editButton.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                                context.startActivity(CreateBerita.getActIntent((Activity) context).putExtra("data", daftarBarang.get(position)));
                            }
                        }
                );

                //apabila tombol delete diklik
                delButton.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                                listener.onDeleteData(daftarBarang.get(position), position);
                            }
                        }
                );
                return true;
            }
        });
        holder.tvTitle.setText(name);
    }

    @Override
    public int getItemCount() {
        /**
         * Mengembalikan jumlah item pada barang
         */
        return daftarBarang.size();
    }

    public interface FirebaseDataListener{
        void onDeleteData(BeritaPen barang, int position);
    }
}


