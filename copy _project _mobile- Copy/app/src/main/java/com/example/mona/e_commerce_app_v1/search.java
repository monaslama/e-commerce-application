package com.example.mona.e_commerce_app_v1;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class search extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        final String cust_id=(getIntent().getExtras().getString("cust_id"));

        ViewPager viewPager=(ViewPager)findViewById(R.id.view_pager);
        viewPager.setAdapter(new simplefragmentpageadapter(getSupportFragmentManager()));

        TabLayout tabLayout=(TabLayout)findViewById(R.id.tab_layout_1);
        tabLayout.setupWithViewPager(viewPager);
    }
}
