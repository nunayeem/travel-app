package com.gaazee.travelapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

public class NearbyAdapter extends RecyclerView.Adapter<NearbyAdapter.NearbyMyViewHolder>{

    Context context;
    String[] nearby_city = {"Dhaka", "London", "Dubai"};
    int[] nearby_pic;
    String[] appartment_text;
    int[] rating_score;
    int[] price_text;
    int[] bed_text;
    int[] bath_text;
    String[] address_text;

    public NearbyAdapter(Context context, String[] nearby_city, int[] nearby_pic, String[] appartment_text, int[] rating_score, int[] price_text, int[] bed_text, int[] bath_text, String[] address_text) {
        this.context = context;
        this.nearby_city = nearby_city;
        this.nearby_pic = nearby_pic;
        this.appartment_text = appartment_text;
        this.rating_score = rating_score;
        this.price_text = price_text;
        this.bed_text = bed_text;
        this.bath_text = bath_text;
        this.address_text = address_text;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String[] getNearby_city() {
        return nearby_city;
    }

    public void setNearby_city(String[] nearby_city) {
        this.nearby_city = nearby_city;
    }

    public int[] getNearby_pic() {
        return nearby_pic;
    }

    public void setNearby_pic(int[] nearby_pic) {
        this.nearby_pic = nearby_pic;
    }

    public String[] getAppartment_text() {
        return appartment_text;
    }

    public void setAppartment_text(String[] appartment_text) {
        this.appartment_text = appartment_text;
    }

    public int[] getRating_score() {
        return rating_score;
    }

    public void setRating_score(int[] rating_score) {
        this.rating_score = rating_score;
    }

    public int[] getPrice_text() {
        return price_text;
    }

    public void setPrice_text(int[] price_text) {
        this.price_text = price_text;
    }

    public int[] getBed_text() {
        return bed_text;
    }

    public void setBed_text(int[] bed_text) {
        this.bed_text = bed_text;
    }

    public int[] getBath_text() {
        return bath_text;
    }

    public void setBath_text(int[] bath_text) {
        this.bath_text = bath_text;
    }

    public String[] getAddress_text() {
        return address_text;
    }

    public void setAddress_text(String[] address_text) {
        this.address_text = address_text;
    }

    @NonNull
    @Override
    public NearbyMyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.near_by_items, parent, false);
        NearbyMyViewHolder nearbyMyViewHolder = new NearbyMyViewHolder(view);
        return nearbyMyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NearbyMyViewHolder holder, int position) {
        holder.appartment_text.setText(appartment_text[position]);
        holder.title_text.setText(nearby_city[position]);
        holder.address_text.setText(address_text[position]);
        holder.rating_text.setText(""+rating_score[position]);
        holder.bed_text.setText(""+bed_text[position]);
        holder.bath_text.setText(""+bath_text[position]);
        holder.price_text.setText(""+price_text[position]);
        holder.pic.setImageResource(nearby_pic[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NearbyDetailsActivity.class);
                intent.putExtra("image", nearby_pic[holder.getAdapterPosition()]);
                intent.putExtra("type", appartment_text[holder.getAdapterPosition()]);
                intent.putExtra("score", rating_score[holder.getAdapterPosition()]);
                intent.putExtra("price", price_text[holder.getAdapterPosition()]);
                intent.putExtra("address", address_text[holder.getAdapterPosition()]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return appartment_text.length;
    }

    class NearbyMyViewHolder extends RecyclerView.ViewHolder{
        TextView appartment_text, title_text, address_text, rating_text, bed_text, bath_text, price_text;
        ShapeableImageView pic;

        public NearbyMyViewHolder(@NonNull View itemView) {
            super(itemView);

            appartment_text = itemView.findViewById(R.id.appartment_text);
            title_text = itemView.findViewById(R.id.title_text);
            address_text = itemView.findViewById(R.id.address_text);
            rating_text = itemView.findViewById(R.id.rating_text);
            bed_text = itemView.findViewById(R.id.bed_text);
            bath_text = itemView.findViewById(R.id.bath_text);
            price_text = itemView.findViewById(R.id.price_text);
            pic = itemView.findViewById(R.id.pic);
        }
    }
}
