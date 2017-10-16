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

public class CategoriesQuizActivity extends AppCompatActivity {
    // Lessons
    String[] mobileArray = {"Easy","Medium","Hard"};

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
                Toast.makeText(CategoriesQuizActivity.this, intentLesson, Toast.LENGTH_SHORT).show();

                if(intentLesson.equals("Easy")) {
                    startActivity(new Intent(CategoriesQuizActivity.this, Quiz1Activity.class));
                    finish();
                }
                else if(intentLesson.equals("Medium"))
                {
                    startActivity(new Intent(CategoriesQuizActivity.this, Quiz2Activity.class));
                    finish();
                }
                else if(intentLesson.equals("Hard")) {
                    startActivity(new Intent(CategoriesQuizActivity.this, Quiz3Activity.class));
                    finish();
                }
            }
        });
    }
}