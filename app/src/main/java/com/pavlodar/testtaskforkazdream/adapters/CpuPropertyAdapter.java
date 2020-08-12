package com.pavlodar.testtaskforkazdream.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.pavlodar.testtaskforkazdream.R;
import com.pavlodar.testtaskforkazdream.models.CpuPropertyModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CpuPropertyAdapter extends RecyclerView.Adapter<CpuPropertyAdapter.MyViewHolder> {

    private Context context;
    private List<CpuPropertyModel> cpuPropertyModelList;
    private ItemClickListener itemClickListener;

    public CpuPropertyAdapter(Context context, List<CpuPropertyModel> cpuPropertyList, ItemClickListener itemClickListener) {
        this.context = context;
        this.cpuPropertyModelList = cpuPropertyList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.property_item, parent, false);
        return new MyViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.propertyName.setText(cpuPropertyModelList.get(position).getName());
        holder.propertyDescription.setText(cpuPropertyModelList.get(position).getValue());
    }

    @Override
    public int getItemCount() {
        return cpuPropertyModelList.size();
    }




    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.txt_property_name_item) TextView propertyName;
        @BindView(R.id.txt_property_description_item) TextView propertyDescription;
        @BindView(R.id.property_item_container) ConstraintLayout item_container;

        ItemClickListener itemClickListener;
        Unbinder unbinder;

        public MyViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
            super(itemView);
            unbinder = ButterKnife.bind(this, itemView);
            this.itemClickListener = itemClickListener;
            item_container.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick(v, getAdapterPosition());
        }
    }

    public interface ItemClickListener{
        void onItemClick(View view, int position);
    }

}
