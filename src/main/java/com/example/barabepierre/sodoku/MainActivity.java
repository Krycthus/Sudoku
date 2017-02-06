package com.example.barabepierre.sodoku;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Activity context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        Button level1 = (Button)findViewById(R.id.level1);
        Button level2 = (Button)findViewById(R.id.level2);

        ImageView imageView = (ImageView) findViewById(R.id.imageLogo);
        imageView.setImageResource(R.drawable.sudoku_logo);

        level1.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putInt("niveau", 1);
                Intent intent = new Intent(context, Level.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        level2.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putInt("niveau", 2);
                Intent intent = new Intent(context, Level.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
}
