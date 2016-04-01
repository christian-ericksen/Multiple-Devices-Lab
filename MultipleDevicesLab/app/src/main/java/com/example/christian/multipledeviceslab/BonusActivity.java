package com.example.christian.multipledeviceslab;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.GridLayout;

public class BonusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.bonus_recycler_view);

        GridLayoutManager layoutManager;

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            layoutManager = new GridLayoutManager(BonusActivity.this, 2, GridLayout.HORIZONTAL, false);
        } else {
            layoutManager = new GridLayoutManager(BonusActivity.this, 2, GridLayout.VERTICAL, false);
        }

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new BonusRecyclerAdapter());
    }
}