package com.example.barabepierre.sodoku;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TwoLineListItem;

import java.util.ArrayList;

import static com.example.barabepierre.sodoku.R.id.liste;
import static com.example.barabepierre.sodoku.R.id.never;


public class Level extends AppCompatActivity {

    private Activity contexte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        contexte = this;
        Bundle b = this.getIntent().getExtras();

        ListView ListeView = (ListView) findViewById(R.id.liste);

        DataManager dm = new DataManager(contexte);
        ListeView.setAdapter(dm.getAdapter(b.getInt("niveau")));
    }
}
