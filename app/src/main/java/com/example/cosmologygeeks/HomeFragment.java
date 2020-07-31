package com.example.cosmologygeeks;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    ArrayList<HomeRecyclerCardModel> arrayList;
    RecyclerView recyclerView;
    int icons[] = {R.drawable.blackhole,R.drawable.blackhole,R.drawable.blackhole,R.drawable.blackhole};
    String iconsName[] = {"Astronomy\n Picture \nof the \nDay", "Meteroids \nNear \nEarth", "How many\n peoples in\n Space \nright now?", "Re-arrange \nPlanets"};
    String shortsummary[] = {"BlackHole","Full Details","ISS","Fun Game"};


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v=inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = v.findViewById(R.id.recycler_home);
        arrayList = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        for (int i = 0; i < icons.length; i++) {
            HomeRecyclerCardModel homeRecyclerCardModel = new HomeRecyclerCardModel();
            homeRecyclerCardModel.setImage(icons[i]);
            homeRecyclerCardModel.setName(iconsName[i]);
            homeRecyclerCardModel.setShortsummary(shortsummary[i]);

            //add in array list
            arrayList.add(homeRecyclerCardModel);
        }

        HomeFragmentRecyclerAdapter adapter = new HomeFragmentRecyclerAdapter(v.getContext(), arrayList);
        recyclerView.setAdapter(adapter);
        return v;
    }

}
