package com.ccs.yvonne.allaboutkorean;

/**
 * Created by melvin.g.uy on 9/6/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class CategoriesActivity extends AppCompatActivity {
    // Array of strings...
    String[] mobileArray = {"Numbers","Education Stages","Fruits","Sports",
            "Wears","Basic Phrases 1","Basic Phrases 2","Item 8","Item 9",
            "Item 10","Item 11","Item 12","Item 13","Item 14","Item 15"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, mobileArray);

        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                String intentLesson = ((TextView) view).getText().toString().trim();
                Toast.makeText(CategoriesActivity.this, intentLesson, Toast.LENGTH_SHORT).show();

                if(intentLesson.equals("Numbers")) {
                    startActivity(new Intent(CategoriesActivity.this, LessonActivity.class));
                    finish();
                }
                else if(intentLesson.equals("Education Stages"))
                {
                    startActivity(new Intent(CategoriesActivity.this, Lesson2Activity.class));
                    finish();
                }
                else if(intentLesson.equals("Fruits"))
                {
                    startActivity(new Intent(CategoriesActivity.this, Lesson3Activity.class));
                    finish();
                }
                else if(intentLesson.equals("Sports"))
                {
                    startActivity(new Intent(CategoriesActivity.this, Lesson4Activity.class));
                    finish();
                }
                else if(intentLesson.equals("Wears"))
                {
                    startActivity(new Intent(CategoriesActivity.this, Lesson5Activity.class));
                    finish();
                }
                else
                {
                    Toast.makeText(CategoriesActivity.this, "Soon", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
