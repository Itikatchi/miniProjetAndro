package com.example.miniprojetandro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class UpdateMangaActivity extends AppCompatActivity {
    private EditText editTextTitre, editTextAuteur,editTextNbTomes,editTextTheme,editTextDesc,editTextPrix;
    private Spinner spinnerGenre;
    private ArrayList<Manga> mesMangas;
    private ArrayList<Genre> mesGenres;
    private Genre genre;
    private String Titre, Auteur, NbTome,PrixString,Theme, Synopsis, Genre, Affiche;
    private double Prix;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailmanga);
        initilialisation();

    }
    private void initilialisation() {

        editTextTitre = (EditText) findViewById(R.id.editTextTitre);
        editTextAuteur = (EditText) findViewById(R.id.editTextAuteur);
        editTextNbTomes = (EditText) findViewById(R.id.editTextNbTomes);
        editTextTheme = (EditText) findViewById(R.id.editTextTheme);
        editTextDesc = (EditText) findViewById(R.id.editTextDesc);
        editTextPrix = (EditText) findViewById(R.id.editTextPrix);
        mesMangas = (ArrayList<Manga>)getIntent().getSerializableExtra("mesMangas");
        mesGenres = (ArrayList<Genre>)getIntent().getSerializableExtra("mesGenres");

        spinnerGenre = (Spinner) findViewById(R.id.spinnerGenre);
        ArrayAdapter dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, mesGenres);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGenre.setAdapter(dataAdapter);
        Intent intent = getIntent();


        if (intent.hasExtra("titre")) {
            Titre = intent.getStringExtra("titre");
            editTextTitre.setText(Titre);
        }
        if (intent.hasExtra("auteur")) {
            Auteur = intent.getStringExtra("auteur");
            editTextAuteur.setText(Auteur);
        }
        if (intent.hasExtra("nbtome")) {
            NbTome = intent.getStringExtra("nbtome");
            editTextNbTomes.setText(NbTome);
        }
        if(intent.hasExtra("prix")){
            Prix  = Double.parseDouble(intent.getStringExtra("prix"));
            PrixString = intent.getStringExtra("prix");
            editTextPrix.setText(PrixString);
        }
        if(intent.hasExtra("Synopsis")){
            Synopsis = intent.getStringExtra("Synopsis");
            editTextDesc.setText(Synopsis);
        }
        if(intent.hasExtra("Theme")){
            Theme = intent.getStringExtra("Theme");
            editTextTheme.setText(Theme);
        }


        /// LA GESTION DU SPINNER POUR LE GENRE CONCERNER
        String genreRecu = intent.getStringExtra("Genre");
        if (genreRecu != null) {
            int index = -1;
            for (int i = 0; i < mesGenres.size(); i++) {
                if (mesGenres.get(i).toString().equalsIgnoreCase(genreRecu)) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                spinnerGenre.setSelection(index);
            }
        }

        spinnerGenre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                genre = mesGenres.get(position); // On récupérer l'objet film qui correspond à celui sélectionner grâce à la position
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }

}
