package com.example.user.proyekkelompok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 5/14/2019.
 */

class ListAkunAdapter extends RecyclerView.Adapter<ListAkunAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<Akun> listProduk;

    private ArrayList<Akun> getListProduk() {
        return listProduk;
    }

    public void setListProduk(ArrayList<Akun> listProduk) {
        this.listProduk = listProduk;
    }

    public ListAkunAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.listdaftar, parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.tvName.setText(getListProduk().get(position).getEmail());


    }

    @Override
    public int getItemCount() {
        return getListProduk().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;


        CategoryViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_nama);

        }
    }


}

