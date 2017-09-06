package com.ccs.yvonne.allaboutkorean;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button categoriesB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoriesB = (Button)findViewById(R.id.categoriesB);

        categoriesB.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this,CategoriesActivity.class));
            }
        });
    }
}
