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

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class VideoPostAdapterCSA extends RecyclerView.Adapter<VideoPostAdapterCSA.YoutubePostHolderCSA> {

    private ArrayList<YoutubeDataModel> dataSet;
    private Context context=null;

    public VideoPostAdapterCSA(Context context,ArrayList<YoutubeDataModel> dataSet) {
        this.dataSet = dataSet;
        this.context=context;
    }

    @NonNull
    @Override
    public YoutubePostHolderCSA onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.youtube_post_layout_csa,parent,false);
        YoutubePostHolderCSA postHolder=new YoutubePostHolderCSA(view);
        return postHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull YoutubePostHolderCSA holder, int position) {
        TextView textViewTitle=holder.textViewTitle;
        TextView textViewDes=holder.textViewDes;
        TextView textViewDate=holder.textViewDate;
        ImageView imageViewThumb=holder.imageViewThumb;

        YoutubeDataModel dataModel=dataSet.get(position);
        textViewTitle.setText(dataModel.getMtitle());
        textViewDes.setText(dataModel.getMdescription());
        textViewDate.setText(dataModel.getMpublishedAt());

        Picasso.with(context).load(dataModel.getThumbnail()).into(imageViewThumb);

        holder.imageViewThumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW , Uri.parse("https://www.youtube.com/channel/UCdNtqpHlU1pCaVy2wlzxHKQ"));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class YoutubePostHolderCSA extends RecyclerView.ViewHolder{

        TextView textViewTitle,textViewDes,textViewDate;
        ImageView imageViewThumb;

        public YoutubePostHolderCSA(View itemView)
        {
            super(itemView);
            this.textViewTitle=itemView.findViewById(R.id.textViewTitle);
            this.textViewDes=itemView.findViewById(R.id.textViewDes);
            this.textViewDate=itemView.findViewById(R.id.textViewDate);
            this.imageViewThumb=itemView.findViewById(R.id.imageViewThumb);
        }


    }
}
