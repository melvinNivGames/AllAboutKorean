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

public class CategoriesActivity extends AppCompatActivity {
    // Lessons
    String[] mobileArray = {"Numbers","Education Stages","Fruits","Sports",
            "Wears","Days","Don'ts in Korea","Continents","Colors",
            "Animals","Family Members","School Subjects","Body Parts","Months","Weathers"};

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
                }
                else if(intentLesson.equals("Education Stages"))
                {
                    startActivity(new Intent(CategoriesActivity.this, Lesson2Activity.class));
                }
                else if(intentLesson.equals("Fruits"))
                {
                    startActivity(new Intent(CategoriesActivity.this, Lesson3Activity.class));
                }
                else if(intentLesson.equals("Sports"))
                {
                    startActivity(new Intent(CategoriesActivity.this, Lesson4Activity.class));
                }
                else if(intentLesson.equals("Wears"))
                {
                    startActivity(new Intent(CategoriesActivity.this, Lesson5Activity.class));
                }
                else if(intentLesson.equals("Days"))
                {
                    startActivity(new Intent(CategoriesActivity.this, Lesson6Activity.class));
                }
                else if(intentLesson.equals("Don'ts in Korea"))
                {
                    startActivity(new Intent(CategoriesActivity.this, Lesson7Activity.class));
                }
                else if(intentLesson.equals("Continents"))
                {
                    startActivity(new Intent(CategoriesActivity.this, Lesson8Activity.class));
                }
                else if(intentLesson.equals("Colors"))
                {
                    startActivity(new Intent(CategoriesActivity.this, Lesson9Activity.class));
                }
                else if(intentLesson.equals("Animals"))
                {
                    startActivity(new Intent(CategoriesActivity.this, Lesson10Activity.class));
                }
                else if(intentLesson.equals("Family Members"))
                {
                    startActivity(new Intent(CategoriesActivity.this, Lesson11Activity.class));
                }
                else if(intentLesson.equals("School Subjects"))
                {
                    startActivity(new Intent(CategoriesActivity.this, Lesson12Activity.class));
                }
                else if(intentLesson.equals("Body Parts"))
                {
                    startActivity(new Intent(CategoriesActivity.this, Lesson13Activity.class));
                }
                else if(intentLesson.equals("Months"))
                {
                    startActivity(new Intent(CategoriesActivity.this, Lesson14Activity.class));
                }
                else if(intentLesson.equals("Weathers"))
                {
                    startActivity(new Intent(CategoriesActivity.this, Lesson15Activity.class));
                }
                finish();
            }
        });
    }
}