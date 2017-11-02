package com.ccs.yvonne.allaboutkorean;

/**
 * Created by melvin.g.uy on 9/6/2017.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button categoriesB, examB, exitB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoriesB = (Button)findViewById(R.id.categoriesB);
        examB = (Button)findViewById(R.id.examB);
        exitB = (Button)findViewById(R.id.exitB);

        categoriesB.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this,CategoriesActivity.class));
            }
        });

        examB.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this,CategoriesQuizActivity.class));
            }
        });

        exitB.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });
    }
}