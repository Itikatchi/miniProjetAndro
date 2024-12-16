package com.example.miniprojetandro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

public class UpdateMangaActivity extends AppCompatActivity {
    private EditText  editTextAuteur,editTextNbTomes,editTextTheme,editTextDesc,editTextPrix;
    private TextView textViewTitreMangaEdit;
    private Spinner spinnerGenre;
    private ArrayList<Manga> mesMangas;
    private ArrayList<Genre> mesGenres;
    private String titre, auteur,theme, synopsis, affiche;
    private float prix;
    private int nbTome;
    private Button btnAjout,btnBack;
    private Manga manga;
    private Genre monGenre;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatemanga);
        initialisation();

    }
    public void initUpdatemanga() {
        titre = textViewTitreMangaEdit.getText().toString();
        auteur = editTextAuteur.getText().toString();
        theme = editTextTheme.getText().toString();
        synopsis = editTextDesc.getText().toString();
        prix = Float.parseFloat(editTextPrix.getText().toString());
        nbTome = Integer.parseInt(editTextNbTomes.getText().toString());

        Manga manga = new Manga(titre, auteur, nbTome, prix, theme, synopsis, monGenre);

        for (int i = 0; i < mesMangas.size(); i++) {
            Manga manga1 = mesMangas.get(i);
            if (manga.getTitre().equals(manga1.getTitre())) {
                mesMangas.set(i,manga);
                break;
            }
        }
    }
    public void posmanga(){
        String libGenreDeLOeuvre = manga.getGenre().getLibGenre();
        int positionGenre = 0;
        for (int i = 0; i < mesGenres.size(); i++) {
            if (mesGenres.get(i).getLibGenre().equals(libGenreDeLOeuvre)) {
                positionGenre = i;
                break;
            }
        }
        spinnerGenre.setSelection(positionGenre);
    }
    public void initialisation() {

        Intent intent = getIntent();
        manga = (Manga) intent.getSerializableExtra("selectedManga");
        textViewTitreMangaEdit = (TextView) findViewById(R.id.textViewTitreMangaEdit);
        editTextAuteur = (EditText) findViewById(R.id.editTextAuteurEdit);
        editTextNbTomes = (EditText) findViewById(R.id.editTextNbTomesEdit);
        editTextPrix = (EditText) findViewById(R.id.editTextPrixEdit);
        editTextTheme = (EditText) findViewById(R.id.editTextThemeEdit);
        editTextDesc = (EditText) findViewById(R.id.editTextSynopsisEdit);
        spinnerGenre = (Spinner) findViewById(R.id.spinnerGenreEdit);
        btnAjout = (Button) findViewById(R.id.btnUpdateEdit);
        btnBack = (Button) findViewById(R.id.buttonBackEdit);
        textViewTitreMangaEdit.setText(manga.getTitre());
        editTextAuteur.setText(manga.getAuteur());
        editTextNbTomes.setText(String.valueOf(manga.getNbDeTome()));
        editTextPrix.setText(String.valueOf(manga.getPrix()));
        editTextTheme.setText(manga.getTheme());
        editTextDesc.setText(manga.getSynopsis());

        mesGenres = (ArrayList<Genre>) intent.getSerializableExtra("MesGenres");        //jsp pk mais il n y a pas de liste
        mesMangas = (ArrayList<Manga>) intent.getSerializableExtra("MesMangas");

        ArrayAdapter dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, mesGenres.stream().map(h->h.getLibGenre()).collect(Collectors.toList()));
        spinnerGenre.setAdapter(dataAdapter);
        posmanga();
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
                initUpdatemanga();
                Intent intent1 = new Intent(UpdateMangaActivity.this, ListMangaActivity.class);
                intent1.putExtra("MesGenres", mesGenres);
                intent1.putExtra("MesMangas", mesMangas);
                startActivity(intent1);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(UpdateMangaActivity.this, ListMangaActivity.class);
                intent1.putExtra("MesGenres", mesGenres);
                intent1.putExtra("MesMangas", mesMangas);
                startActivity(intent1);
            }
        });
    }



}
