package com.latlng.bolt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {


    private Context context;
    private ArrayList<AddressModel> addressModel;
    LayoutInflater layout;
    int selectedPosition = -1;
    ItemClickListener itemClickListener;

    AddressAdapter(ArrayList<AddressModel> addModel, Context context,ItemClickListener itemClickListener){
    this.layout=LayoutInflater.from(context);
    this.addressModel=addModel;
    this.itemClickListener=itemClickListener;
    this.context=context;
    }
    @NonNull
    @Override
    public AddressAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layout.inflate(R.layout.address_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressAdapter.ViewHolder holder, int position) {

        AddressModel address = addressModel.get(position);
        holder.addressTv1.setText(address.add1);
        holder.addressTv2.setText(address.add2);
        holder.addressTv3.setText(address.add3);

        holder.radioButton.setChecked(position==selectedPosition);
        holder.radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    selectedPosition=holder.getAdapterPosition();
                    itemClickListener.onClick(
                            holder.radioButton.getText()
                                    .toString());

                }
            }
        });

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return addressModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView addressTv1, addressTv2, addressTv3;
        RadioButton radioButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            addressTv1=itemView.findViewById(R.id.addTv1);
            addressTv2=itemView.findViewById(R.id.addTv2);
            addressTv3=itemView.findViewById(R.id.addTv3);
            radioButton=itemView.findViewById(R.id.radioBt);
        }
    }
}
