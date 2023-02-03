package com.latlng.bolt;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.ViewHolder> {

    private LayoutInflater layout;
    private ArrayList<Block> blocks;
    private Context context;


    FeaturedAdapter(Context context, ArrayList<Block> blocks){
        this.layout=LayoutInflater.from(context);
        this.blocks = blocks;
        this.context=context;
    }
    @NonNull
    @Override
    public FeaturedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layout.inflate(R.layout.feat_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedAdapter.ViewHolder holder, int position) {
        Block block = blocks.get(position);
        holder.proImg.setImageResource(block.getImg());
        holder.proRate.setText(block.getPrice());
        holder.proDesc.setText(block.getDesc());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ItemDetailsActivity.class);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return blocks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        ImageView proImg;
        TextView proRate,seeAll;
        TextView proDesc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            proImg=itemView.findViewById(R.id.fImg);
            proRate=itemView.findViewById(R.id.fRate);
            proDesc=itemView.findViewById(R.id.fDesc);
            seeAll=itemView.findViewById(R.id.seeAll);
        }
    }

}
