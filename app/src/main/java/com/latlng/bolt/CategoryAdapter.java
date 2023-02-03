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

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private LayoutInflater layout;
    private List<Integer> cImg;
    private List<Integer> cBg;
    private List<String> cName;

    CategoryAdapter(Context context,List<Integer> img,List<Integer> bg, List<String> name) {

        this.layout=LayoutInflater.from(context);
        this.cImg=img;
        this.cBg=bg;
        this.cName=name;

    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layout.inflate(R.layout.category_card,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
        Integer img = cImg.get(position);
        holder.cimg.setImageResource(img);
        Integer bg = cBg.get(position);
        holder.cbg.setImageResource(bg);
        String name = cName.get(position);
        holder.cname.setText(name);


    }

    @Override
    public int getItemCount() {
        return cImg.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cimg;
        ImageView cbg;
        TextView cname;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cimg=itemView.findViewById(R.id.catImg);
            cbg=itemView.findViewById(R.id.catBg);
            cname=itemView.findViewById(R.id.catName);
        }
    }
}
