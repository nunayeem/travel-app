package com.gaazee.travelapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.MyViewHolder>{
    Context context;
    private String[] title;
    private int[] pic;



    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String[] getTitle() {
        return title;
    }

    public void setTitle(String[] title) {
        this.title = title;
    }

    public int[] getPic() {
        return pic;
    }

    public void setPic(int[] pic) {
        this.pic = pic;
    }

    public RecommendAdapter(Context context, String[] title, int[] pic) {
        this.context = context;
        this.title = title;
        this.pic = pic;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_holder_item, parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(title[position]);
        holder.pic.setImageResource(pic[position]);
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView pic;
        TextView title;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            pic = itemView.findViewById(R.id.pic);
            title = itemView.findViewById(R.id.title_text);
        }
    }
}
