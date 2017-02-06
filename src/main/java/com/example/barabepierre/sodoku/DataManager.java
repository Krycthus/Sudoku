package com.example.barabepierre.sodoku;

import android.app.Activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DataManager {

    private Activity contexte;

    public DataManager(Activity contexte) {
        this.contexte = contexte;
    }

    public MyAdapter getAdapter(int level) {
        int load = 0;
        switch (level) {
            case 1:
                load = R.raw.niveau1;
                break;
            case 2:
                load = R.raw.niveau2;
                break;
        }

        ArrayList<vGrille> liste = getGridLevelList(level, load);
        MyAdapter adapterLevel = new MyAdapter(contexte, liste);
        return adapterLevel;
    }


    public ArrayList<vGrille> getGridLevelList(int level, int fileSource) {

        InputStream file = contexte.getResources().openRawResource(fileSource);
        BufferedReader reader = new BufferedReader(new InputStreamReader(file));
        String str = "";

        ArrayList<vGrille> grille = new ArrayList();
        if (file != null) {
            try {
                int index = 0;
                while ((str = reader.readLine()) != null) {
                    grille.add(new vGrille(index, level, index, 30, str));
                    index++;
                }
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return grille;
    }
}
