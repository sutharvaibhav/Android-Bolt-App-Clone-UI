package com.latlng.bolt;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SizeAdapter extends RecyclerView.Adapter<SizeAdapter.ViewHolder> {


    private LayoutInflater layout;
    private ArrayList<String> sizeChart;
    private Context context;
    int selectedPosition = -1;
    ItemClickListener itemClickListener;

    SizeAdapter(Context context,ArrayList<String> sChart, ItemClickListener itemClickListener){
        this.context=context;
        this.sizeChart=sChart;
        this.layout=LayoutInflater.from(context);
        this.itemClickListener = itemClickListener;
    }
    @NonNull
    @Override
    public SizeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layout.inflate(R.layout.size_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        String sname = sizeChart.get(position);
        holder.sizeBt.setText(sname);

        holder.sizeBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPosition=holder.getAdapterPosition();
                itemClickListener.onClick(
                        holder.sizeBt.getText()
                                .toString());

                selectedPosition = position;
                notifyDataSetChanged();



                if(selectedPosition == position) {
//                    holder.sizeBt.setBackgroundResource(R.drawable.selected_bt);
                    holder.sizeBt.setTextColor(Color.parseColor("#FFFFFFFF"));
                }
                else {
//                    holder.sizeBt.setBackgroundColor(R.drawable.unselected_bt);
                    holder.sizeBt.setTextColor(Color.parseColor("#FF000000"));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return sizeChart.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button sizeBt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sizeBt=itemView.findViewById(R.id.btSize);

        }
    }
}
