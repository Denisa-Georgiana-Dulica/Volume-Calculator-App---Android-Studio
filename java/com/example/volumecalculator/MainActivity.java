package com.example.volumecalculator;

import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        GridView gridView=findViewById(R.id.gridView);
        ArrayList<Shape> shapesList=new ArrayList<>();

        Shape cube=new Shape(R.drawable.cube,"Cube");
        Shape sfera=new Shape(R.drawable.sfera,"Sphere");
        Shape pyramid=new Shape(R.drawable.piramid,"Pyramid");
        Shape cylinder=new Shape(R.drawable.cylinder,"Cylinder");

        shapesList.add(cube);
        shapesList.add(pyramid);
        shapesList.add(sfera);
        shapesList.add(cylinder);

        MyCustomAdapter adapter=new MyCustomAdapter(getApplicationContext(),shapesList);
        gridView.setAdapter(adapter);
        gridView.setNumColumns(2);

       gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Shape shape=shapesList.get(i);
                if(shape.getShapeName().equals("Sphere")) {
                    Intent in = new Intent(MainActivity.this, SphereActivity.class);
                    startActivity(in);
                }
                else if(shape.getShapeName().equals("Cube")){
                    Intent in = new Intent(MainActivity.this, CubeActivity.class);
                    startActivity(in);
                }
                else if(shape.getShapeName().equals("Pyramid")){
                    Intent in = new Intent(MainActivity.this, PyramideActivity.class);
                    startActivity(in);
                }
                else if(shape.getShapeName().equals("Cylinder")){
                    Intent in = new Intent(MainActivity.this, CylinderActivity.class);
                    startActivity(in);
                }

           }
       });
    }
}