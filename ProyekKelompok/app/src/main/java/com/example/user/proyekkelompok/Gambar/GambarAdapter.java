package com.example.user.proyekkelompok.Gambar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.proyekkelompok.R;

import java.util.ArrayList;

/**
 * Created by User on 5/14/2019.
 */

public class GambarAdapter  extends BaseAdapter {
    private Context context;
    private  int layout;
    private ArrayList<GambarModel> foodsList;

    public GambarAdapter(Context context, int layout, ArrayList<GambarModel> foodsList) {
        this.context = context;
        this.layout = layout;
        this.foodsList = foodsList;
    }

    @Override
    public int getCount() {
        return foodsList.size();
    }

    @Override
    public Object getItem(int position) {
        return foodsList.get(position);
    }

    @Override
    public long getItemId(int position) {


        return position;
    }
    private class ViewHolder{
        ImageView imageView;
        TextView txtName, txtarea;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtName = (TextView) row.findViewById(R.id.txtName);

            holder.txtarea = (TextView) row.findViewById(R.id.txtarea);
            holder.imageView = (ImageView) row.findViewById(R.id.imgFood);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

       GambarModel food = foodsList.get(position);

        holder.txtName.setText(food.getName());

        holder.txtarea.setText(food.getArea());

        byte[] foodImage = food.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(foodImage, 0, foodImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}

