package com.example.christian.multipledeviceslab;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CardListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        TextView title = (TextView) findViewById(R.id.card_list_title);

        TextView subtitle = (TextView) findViewById(R.id.card_list_subtitle);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            title.setText("Layouts R Fun");
            subtitle.setText("Enjoy this landscape layout!");
        } else {
            title.setText("Layouts Are Fun");
            subtitle.setText("Enjoy this portrait layout!");
        }
        ListView listView = (ListView) findViewById(R.id.card_list_view);
        listView.setAdapter(new ArrayAdapter<String>(
                CardListActivity.this,
                android.R.layout.simple_list_item_1,
                getList()
        ));
    }

    private ArrayList<String> getList() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            list.add("List item #" + i);
        }
        return list;
    }
}