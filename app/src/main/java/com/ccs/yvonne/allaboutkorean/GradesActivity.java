package com.ccs.yvonne.allaboutkorean;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class GradesActivity extends AppCompatActivity {
    static final int READ_BLOCK_SIZE = 100;
    int easy = 0, medium = 0, hard = 0;
    TextView summary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);

        summary = (TextView) findViewById(R.id.summary);

        try {
            FileInputStream fileIn=openFileInput("grades.aak");
            InputStreamReader InputRead= new InputStreamReader(fileIn);

            char[] inputBuffer= new char[READ_BLOCK_SIZE];
            String s="";
            int charRead;

            while ((charRead=InputRead.read(inputBuffer))>0) {
                // char to string conversion
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                s +=readstring;
            }

            InputRead.close();
            easy = Integer.parseInt(s.split(",")[0]);
            medium = Integer.parseInt(s.split(",")[1]);
            hard = Integer.parseInt(s.split(",")[2]);
        }
        catch (Exception e)
        {
        }

        GraphView graph = (GraphView) findViewById(R.id.graph);
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 0),
                new DataPoint(1, easy),
                new DataPoint(2, medium),
                new DataPoint(3, hard),
                new DataPoint(4, 0)
        });
        graph.addSeries(series);

        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(4);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(25);

        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setXAxisBoundsManual(true);

        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
        staticLabelsFormatter.setHorizontalLabels(new String[] {"\t", "Easy", "Medium", "Hard", "\t"});
        graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);

        // styling
        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
            }
        });

        series.setSpacing(30);

        // draw values on top
        series.setDrawValuesOnTop(false);
        series.setValuesOnTopColor(Color.RED);
        //series.setValuesOnTopSize(50);

        summary.setText("EASY - " + easy + " pts.\nMEDIUM - " + medium + " pts\nHARD - " + hard + " pts");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                startActivity(new Intent(GradesActivity.this, CategoriesQuizActivity.class));
                finish();
            }
        });
    }

    public void onBackPressed() {
        startActivity(new Intent(GradesActivity.this,CategoriesQuizActivity.class));
        finish();
    }
}
