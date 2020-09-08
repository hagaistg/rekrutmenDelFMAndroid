package com.example.user.proyekkelompok.program;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.user.proyekkelompok.Program;
import com.example.user.proyekkelompok.R;

import java.util.List;

public class MyRecyclerAdapter2 extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {
    private List<Model> items;
    Context mContext;

    public MyRecyclerAdapter2(Context context, List<Model> items) {
        this.items = items;
        this.mContext = context;
    }
    @Override
    public MyRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.singel_celll, parent, false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),ProgramList.class);
                mContext.startActivity(intent);
            }
        });
        return new MyRecyclerAdapter.ViewHolder(v);

    }
    @Override
    public void onBindViewHolder(MyRecyclerAdapter.ViewHolder holder, final int position) {
        Model item = items.get(position);
        holder.textName.setText(item.getName());
        holder.textHarga.setText(item.getHarga());
        holder.textEmail.setText(item.getEmail());
        holder.textGender.setText(item.getGender());

    }
    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textName;
        public TextView textEmail;
        public TextView textHarga;
        public TextView textGender;
        public ImageButton imgBtnDelete;
        public ImageButton imgBtnEdit;

        public ViewHolder(View itemView) {
            super(itemView);
            textName = (TextView) itemView.findViewById(R.id.text_name);
            textHarga = (TextView) itemView.findViewById(R.id.text_harga);
            textEmail = (TextView) itemView.findViewById(R.id.text_email);
            textGender = (TextView) itemView.findViewById(R.id.text_gender);
            imgBtnDelete = (ImageButton) itemView.findViewById(R.id.image_btn_delete);
            imgBtnEdit = (ImageButton) itemView.findViewById(R.id.image_btn_edit);
        }
    }
    /**
     * Edit record in database
     * @param position - row position in array list
     */
    private void editRow(int position) {
        String rowId = items.get(position).getId();
        Intent intentEdit = new Intent(mContext,Program.class);
        intentEdit.putExtra("ROW_ID", rowId);
        mContext.startActivity(intentEdit);
        ((Activity)mContext).finish();
    }

    //Remove item
    public void removeItem(int position) {
        DatabaseHandler dbHandler = DatabaseHandler.getInstance(mContext);
        try {
            String rowId = items.get(position).getId();

            String whereClause = DatabaseHandler.KEY_ID+" = ?";
            String[] whereArgs = new String[]{rowId};
            int result = dbHandler.deleteRecord(DatabaseHandler.TABLE_CONTACTS, whereClause, whereArgs);
            if(result > 0){
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, items.size());
                items.remove(position);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null != dbHandler){
                dbHandler.close();
            }
        }

    }
}
