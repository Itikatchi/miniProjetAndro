package com.example.miniprojetandro;

import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Utilisateur> mesUti;
    private ArrayList<Genre> mesGenres;
    private EditText editTextLog;

    private

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initUser();
    }

    private void initUser(){
        mesUti = new ArrayList<>();
        mesUti.add(new Utilisateur("jules", "root"));
        mesUti.add(new Utilisateur("yann", "root"));
    }

    private void initGenre(){

    }
}