package com.example.miniprojetandro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DetailMangaActivity extends AppCompatActivity {
    private TextView TitreTextView, AuteurTextView,NbTomeTextView,PrixTextView,ThemeTextView,GenreTextView,textViewSynopsis;
    private ImageView imageManga;
    private ArrayList<Manga> mesMangas;
    private ArrayList<Genre> mesGenres;
    private String Titre, Auteur, NbTomeString,PrixString,Theme, Synopsis, Genre, Affiche;
    private double Prix;
    private int NbTome;
    private Button ButtonUpdate,ButtonDelete,ButtonBack;

    private Manga manga;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailsmanga);
        initilialisation();
    }
    private void initilialisation() {

        TitreTextView = (TextView) findViewById(R.id.titreTextView); // TITRE MANGA
        AuteurTextView = (TextView) findViewById(R.id.auteurTextView);
        NbTomeTextView = (TextView) findViewById(R.id.nbTomeTextView);
        PrixTextView = (TextView) findViewById(R.id.prixTextView);
        ThemeTextView = (TextView) findViewById(R.id.themeTextView);
        GenreTextView = (TextView) findViewById(R.id.genreTextView);
        textViewSynopsis = (TextView) findViewById(R.id.textViewSynopsis);
        imageManga = (ImageView) findViewById(R.id.imageManga);
        mesMangas = (ArrayList<Manga>)getIntent().getSerializableExtra("mesMangas");
        mesGenres = (ArrayList<Genre>)getIntent().getSerializableExtra("mesGenres");

        Intent intent = getIntent();
        if (intent.hasExtra("selectedManga")){
            manga = (Manga) intent.getSerializableExtra("selectedManga");
            TitreTextView.setText(manga.getTitre() + " :");
            GenreTextView.setText("Genre : " + (manga.getGenre().getLibGenre()));
            AuteurTextView.setText(manga.getAuteur());
            NbTomeTextView.setText(String.valueOf(manga.getNbDeTome()) + " Tome");
            textViewSynopsis.setText(manga.getTitre());
            ThemeTextView.setText("Theme : " + (manga.getTheme()));
            PrixTextView.setText("Prix : " + (String.valueOf(manga.getPrix())) + " €");
            if(manga.getTitre().equals("Another"))
                this.imageManga.setImageResource(R.drawable.another);
            else if (manga.getTitre().equals("Charlotte")) {
                this.imageManga.setImageResource(R.drawable.charlotte);
            }
            else if (manga.getTitre().equals("Classroom of the Elite")) {
                this.imageManga.setImageResource(R.drawable.classroomoftheelite);
            }
            else if (manga.getTitre().equals("Cyberpunk: Edgerunners")) {
                this.imageManga.setImageResource(R.drawable.cyberpunk_edgerunners);
            }
            else if (manga.getTitre().equals("Darling in the Franxx")) {
                this.imageManga.setImageResource(R.drawable.darling_in_the_frankxx);
            }
            else if (manga.getTitre().equals("Nana")) {
                this.imageManga.setImageResource(R.drawable.nana);
            }
            else if (manga.getTitre().equals("Naruto")) {
                this.imageManga.setImageResource(R.drawable.naruto);
            }
            else if (manga.getTitre().equals("White Album 2")) {
                this.imageManga.setImageResource(R.drawable.white_album_2);
            }
        }

        ButtonUpdate =(Button)  findViewById(R.id.buttonUpdate);
        ButtonDelete =(Button)  findViewById(R.id.buttonDelete);
        ButtonBack =(Button)  findViewById(R.id.buttonBack);
        ButtonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DetailMangaActivity.this, UpdateMangaActivity.class);
                intent1.putExtra("titre", Titre);
                intent1.putExtra("NbTome",NbTome);
                intent1.putExtra("Prix",Prix);
                intent1.putExtra("Theme",Theme);
                intent1.putExtra("Synopsis",Synopsis);
                intent1.putExtra("Genre",Genre);
                intent1.putExtra("Affiche",Affiche);
                intent1.putExtra("mesMangas",mesMangas);
                intent1.putExtra("mesGenres",mesGenres);
                startActivity(intent1);
            }
        });
        ButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DetailMangaActivity.this, DeleteActivity.class);
                intent1.putExtra("selectedManga", manga);
                intent1.putExtra("mesMangas",mesMangas);
                intent1.putExtra("mesGenres",mesGenres);
                startActivity(intent1);
            }
        });
        ButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DetailMangaActivity.this, ListMangaActivity.class);
                intent1.putExtra("mesMangas",mesMangas);
                intent1.putExtra("mesGenres",mesGenres);
                startActivity(intent1);
            }
        });
    }

}
