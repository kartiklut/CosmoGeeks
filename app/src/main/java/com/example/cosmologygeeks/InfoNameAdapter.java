package com.example.cosmologygeeks;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class InfoNameAdapter extends RecyclerView.Adapter<InfoNameAdapter.InfoNameHolder>  {


    private ArrayList<NasaInfoDataModel> dataSet;
    private Context context=null;

    public InfoNameAdapter(Context context, ArrayList<NasaInfoDataModel> dataSet) {
        this.dataSet = dataSet;
        this.context=context;
    }

    @NonNull
    @Override
    public InfoNameHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.neows_layout,parent,false);
        InfoNameHolder holder=new InfoNameHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final InfoNameHolder holder, int position) {
        TextView textViewName=holder.textViewName;
        TextView textViewRefId=holder.textViewRefId;
        final TextView textViewObjId=holder.textViewObjId;

        final NasaInfoDataModel dataModel=dataSet.get(position);
        textViewName.setText(dataModel.getmName());
        textViewRefId.setText(dataModel.getmNeoRefId());
        textViewObjId.setText(dataModel.getmObjectId());


        holder.textViewName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent=new Intent(v.getContext(),BottomSheetDailogINFO.class);
//                v.getContext().startActivity(intent);

                Bundle args = new Bundle();
                args.putString("ObjectId", dataModel.getmNeoRefId());
                BottomSheetInfoActivity bottomSheetDailogINFO=new BottomSheetInfoActivity();
                bottomSheetDailogINFO .setArguments(args);
                bottomSheetDailogINFO .show(((FragmentActivity) context).getSupportFragmentManager(),bottomSheetDailogINFO.getTag());



//                BottomSheetDailogINFO bottomSheetDailogINFO=new BottomSheetDailogINFO();
//                FragmentManager fragmentManager = ((FragmentActivity) v.getContext()).getSupportFragmentManager();
//
//                bottomSheetDailogINFO.show(fragmentManager,"BottomSheet");
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class InfoNameHolder extends RecyclerView.ViewHolder{

        TextView textViewName,textViewRefId,textViewObjId;

        public InfoNameHolder(View itemView)
        {
            super(itemView);
            this.textViewName=itemView.findViewById(R.id.objectName);
            this.textViewRefId=itemView.findViewById(R.id.neorefid);
            this.textViewObjId=itemView.findViewById(R.id.objectId);
        }


    }

}
