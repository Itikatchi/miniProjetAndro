package com.example.miniprojetandro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CreateActivity extends AppCompatActivity {

    private EditText editTextTitre, editTextAuteur, editTextTome, editTextPrix, editTextTheme, editTextSyno;
    private Spinner spinnerGenre;
    private Button btnAjout, btnBack;
    private String titre, auteur, theme, syno;
    private float prix;
    private int tome;
    private Genre monGenre;
    private ArrayList<Genre> mesGenres;
    private ArrayList<Manga> mesMangas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_creatmanga);
        initialisation();
    }

    public void initialisation() {
        Intent intent = getIntent();
        editTextTitre = (EditText) findViewById(R.id.editTextTitre);
        editTextAuteur = (EditText) findViewById(R.id.editTextAuteur);
        editTextTome = (EditText) findViewById(R.id.editTextNbTomes);
        editTextPrix = (EditText) findViewById(R.id.editTextPrix);
        editTextTheme = (EditText) findViewById(R.id.editTextTheme);
        editTextSyno = (EditText) findViewById(R.id.editTextSyno);
        spinnerGenre = (Spinner) findViewById(R.id.spinnerGenre);
        btnAjout = (Button) findViewById(R.id.btnAjout);
        btnBack = (Button) findViewById(R.id.ButtonBack);

        mesGenres = (ArrayList<Genre>) intent.getSerializableExtra("MesGenres");        //jsp pk mais il n y a pas de liste
        mesMangas = (ArrayList<Manga>) intent.getSerializableExtra("MesMangas");

        ArrayAdapter dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, mesGenres.stream().map(h->h.getLibGenre()).collect(Collectors.toList()));
        spinnerGenre.setAdapter(dataAdapter);
        spinnerGenre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                monGenre = mesGenres.get(position); // On récupérer l'objet film qui correspond à celui sélectionner grâce à la position
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnAjout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                titre = editTextTitre.getText().toString();
                auteur = editTextAuteur.getText().toString();
                theme = editTextTheme.getText().toString();
                syno = editTextSyno.getText().toString();
                prix = Float.parseFloat(editTextPrix.getText().toString());
                tome = Integer.parseInt(editTextTome.getText().toString());


            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
