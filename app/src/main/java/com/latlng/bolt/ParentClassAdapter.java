package com.latlng.bolt;

import static androidx.core.content.ContextCompat.startActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class ParentClassAdapter extends RecyclerView.Adapter<ParentClassAdapter.ViewHolder> {

    private LayoutInflater layout;
    private Context context;
    private ArrayList<Subject> cTitle;

    ParentClassAdapter(Context context, ArrayList<Subject> cT) {

       this.context = context;
       this.layout=LayoutInflater.from(context);
       this.cTitle=cT;
   }
    @NonNull
    @Override
    public ParentClassAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
       View view = layout.inflate(R.layout.home_horizontalview,parent,false);
       return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ParentClassAdapter.ViewHolder holder, int position) {

       holder.feaTxt.setText(cTitle.get(position).title);
       FeaturedAdapter featuredAdapter = new FeaturedAdapter(context,cTitle.get(position).blocks);
       holder.parentRv.setAdapter(featuredAdapter);

       holder.seeAll.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent intent = new Intent(context, SeeAllActivity.class);
               intent.putExtra("title",cTitle.get(position).title);
               Bundle bundle = new Bundle();
               bundle.putParcelableArrayList("mylist", (ArrayList<? extends Parcelable>) cTitle.get(position).blocks);
               intent.putExtras(bundle);

               context.startActivity(intent);

           }
       });


   }

    @Override
    public int getItemCount() {

        return cTitle.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       private TextView feaTxt,seeAll;
       private RecyclerView parentRv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            feaTxt = itemView.findViewById(R.id.fTxt);
            parentRv = itemView.findViewById(R.id.horizontalView);
            seeAll = itemView.findViewById(R.id.seeAll);
        }
    }
}
