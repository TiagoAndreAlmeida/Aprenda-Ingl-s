package com.example.aprendaingles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.aprendaingles.adapters.TabAdapter;
import com.example.aprendaingles.fragmentos.BichosFragment;
import com.example.aprendaingles.fragmentos.NumerosFragment;
import com.example.aprendaingles.fragmentos.VogaisFragment;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private TabLayout tabLayout;

    private List<Fragment> listFragments = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewPage2);
        tabLayout = findViewById(R.id.tabLayout);

        listFragments.add(new BichosFragment());
        listFragments.add(new NumerosFragment());
        listFragments.add(new VogaisFragment());

        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager(), getLifecycle(), listFragments);
        viewPager2.setAdapter(tabAdapter);

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            switch (position){
                case 0:
                    tab.setText("Bichos");
                    break;
                case 1:
                    tab.setText("Números");
                    break;
                default:
                    tab.setText("Vogais");
                    break;
            }
        }).attach();


    }
}