package com.ccs.yvonne.allaboutkorean;

/**
 * Created by melvin.g.uy on 9/6/2017.
 */

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CategoriesActivity extends AppCompatActivity {
    // Array of strings...
    String[] mobileArray = {"Numbers","Fruits","Educational Stages","Sports",
            "Simple Phrases 1","Simple Phrases 2","To be is all I gotta be",
            "And all that I see","And all that I need this time",
            "To me the life you gave me","The day you said goodnight",
            "Item 12", "Item 13", "Item 14", "Item 15"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, mobileArray);

        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);


    }

}
