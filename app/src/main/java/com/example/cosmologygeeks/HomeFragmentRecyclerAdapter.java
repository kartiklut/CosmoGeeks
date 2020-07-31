package com.example.cosmologygeeks;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeFragmentRecyclerAdapter extends RecyclerView.Adapter<HomeFragmentRecyclerAdapter.viewHolder> {

    Context context;
    ArrayList<HomeRecyclerCardModel> arrayList;

    public HomeFragmentRecyclerAdapter(Context context, ArrayList<HomeRecyclerCardModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public HomeFragmentRecyclerAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_recyclelayout, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeFragmentRecyclerAdapter.viewHolder holder, final int position) {
        holder.title.setText(arrayList.get(position).getName());
        holder.shortsummary.setText(arrayList.get(position).getShortsummary());
        holder.thumbnail.setImageResource(arrayList.get(position).getImage());


        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==0)
                {
                    Uri uri;
                    Intent intent=new Intent(v.getContext(), AstronomyPictureActivity.class);
                    v.getContext().startActivity(intent);
                }
                else if(position==1)
                {

                    Intent intent=new Intent(v.getContext(), NeowsActivity.class);
                    v.getContext().startActivity(intent);
                }
                else if(position==2)
                {

                    Intent intent=new Intent(v.getContext(), PeopleActivity.class);
                    v.getContext().startActivity(intent);
                }
                else if(position==3)
                {

                    Intent intent=new Intent(v.getContext(), ArrangeActivity.class);
                    v.getContext().startActivity(intent);
                }
            }
        });
    }



    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView thumbnail;
        TextView title;
        TextView shortsummary;


        public viewHolder(View itemView) {
            super(itemView);
            thumbnail =  itemView.findViewById(R.id.imageViewThumb);
            title =  itemView.findViewById(R.id.textViewTitle);
            shortsummary =  itemView.findViewById(R.id.textViewDate);

        }


    }

}
