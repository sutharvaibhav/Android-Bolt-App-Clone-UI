package com.latlng.bolt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private LayoutInflater layout;
    private List<Integer> cImg;
    private List<String> cName;
    private List<String> cBrand;
    private List<String> cPrice;

    CartAdapter(Context context, List<Integer> img, List<String> name, List<String> brand, List<String> price){

        this.layout=LayoutInflater.from(context);
        this.cImg=img;
        this.cName=name;
        this.cBrand=brand;
        this.cPrice=price;

    }
    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layout.inflate(R.layout.cart_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
        Integer img = cImg.get(position);
        holder.pImg.setImageResource(img);
        String name = cName.get(position);
        holder.pName.setText(name);
        String brand = cBrand.get(position);
        holder.pBrand.setText(brand);
        String rate = cPrice.get(position);
        holder.pPrice.setText(rate);
    }

    @Override
    public int getItemCount() {
        return cImg.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView pImg;
        TextView pName, pBrand, pPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pImg=itemView.findViewById(R.id.cartImg);
            pName=itemView.findViewById(R.id.cProName);
            pBrand=itemView.findViewById(R.id.cProC);
            pPrice=itemView.findViewById(R.id.cProR);
        }
    }
}
