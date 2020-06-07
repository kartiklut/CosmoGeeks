package com.example.cosmologygeeks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class Fragment_main extends AppCompatActivity {

    ChipNavigationBar bottomnav;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);

        bottomnav=findViewById(R.id.chip);

        if(savedInstanceState==null)
        {
            bottomnav.setItemSelected(R.id.home,true);
            fragmentManager=getSupportFragmentManager();
            HomeFragment homeFragment=new HomeFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container,homeFragment)
                    .commit();
        }

        bottomnav.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {
                Fragment fragment=null;
                switch(id){
                    case R.id.home:
                        fragment=new HomeFragment();
                        break;
                    case R.id.discover:
                        fragment=new DiscoverFragment();
                        break;
                    case R.id.account:
                        fragment=new AccountFragment();
                        break;

                }

                if(fragment!=null)
                {
                    fragmentManager=getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container,fragment)
                            .commit();
                }
                else
                {
                    Log.e("Error","Error in creating fragment object");
                }
            }
        });


    }
}
