package com.example.mycontacts;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    //Initialize variable
    Activity activity;
    ArrayList<ContactModel> arrayList;
    RecyclerViewClickListener listener;

    //Create constructor
    public MainAdapter(Activity activity,ArrayList<ContactModel> arrayList, RecyclerViewClickListener listener){
        this.activity = activity;
        this.arrayList = arrayList;
        this.listener = listener;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Initialize view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contact,parent,false);
        //Return view
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Initialize contact model
        ContactModel model = arrayList.get(position);

        //Set name
        holder.tvName.setText(model.getName());
        //Set number
        holder.tvNumber.setText(model.getNumber());


    }

    @Override
    public int getItemCount() {
        //Return array list size
        return arrayList.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //Initialize variable
        TextView tvName, tvNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Assign variable
            tvName = itemView.findViewById(R.id.tv_name);
            tvNumber = itemView.findViewById(R.id.tv_number);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, getAdapterPosition());
        }
    }
}
