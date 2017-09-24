package com.ccs.yvonne.allaboutkorean;

/**
 * Created by melvin.g.uy on 9/6/2017.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button categoriesB, gradesB, exitB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoriesB = (Button)findViewById(R.id.categoriesB);
        gradesB = (Button)findViewById(R.id.gradesB);
        exitB = (Button)findViewById(R.id.exitB);

        categoriesB.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this,CategoriesActivity.class));
            }
        });

        gradesB.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(MainActivity.this, "Soon", Toast.LENGTH_SHORT).show();
            }
        });

        exitB.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });
    }
}