package com.example.cosmologygeeks;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleHolder>  {


    private ArrayList<PeopleDataModel> dataSet;
    private Context context=null;

    public PeopleAdapter(Context context,ArrayList<PeopleDataModel> dataSet) {
        this.dataSet = dataSet;
        this.context=context;
    }

    @NonNull
    @Override
    public PeopleHolder  onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.peoplelayout,parent,false);
        PeopleHolder holder=new PeopleHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final PeopleHolder holder, int position) {
        TextView textViewName=holder.textViewName;
        TextView textViewCraft=holder.textViewCraft;

        final PeopleDataModel dataModel=dataSet.get(position);
        textViewName.setText(dataModel.getPeopleName());
        textViewCraft.setText(dataModel.getPeopleCraft());




    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class PeopleHolder extends RecyclerView.ViewHolder{

        TextView textViewName,textViewCraft;

        public PeopleHolder(View itemView)
        {
            super(itemView);
            this.textViewName=itemView.findViewById(R.id.peopleName);
            this.textViewCraft=itemView.findViewById(R.id.craftName);
        }


    }

}
