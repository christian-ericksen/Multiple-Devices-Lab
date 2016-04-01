package com.example.christian.multipledeviceslab;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.calendar_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(CalendarActivity.this);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            layoutManager.setOrientation(LinearLayout.HORIZONTAL);
            recyclerView.setAdapter(new CalendarRecyclerAdapter(LinearLayout.HORIZONTAL));
        } else {
            layoutManager.setOrientation(LinearLayout.VERTICAL);
            recyclerView.setAdapter(new CalendarRecyclerAdapter(LinearLayout.VERTICAL));
        }

        recyclerView.setLayoutManager(layoutManager);
    }
}