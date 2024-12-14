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
    private String Titre, Auteur, NbTome,PrixString,Theme, Synopsis, Genre, Affiche;
    private double Prix;
    private Button ButtonUpdate,ButtonDelete,ButtonBack;

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
        if (intent.hasExtra("titre")) {
            Titre = intent.getStringExtra("titre");
            TitreTextView.setText(Titre);
        }
        if (intent.hasExtra("auteur")) {
            Auteur = intent.getStringExtra("auteur");
            AuteurTextView.setText(Auteur);
        }
        if (intent.hasExtra("nbtome")) {
            NbTome = intent.getStringExtra("nbtome");
            NbTomeTextView.setText(NbTome);
        }
        if(intent.hasExtra("prix")){
            Prix  = Double.parseDouble(intent.getStringExtra("prix"));
            PrixString = intent.getStringExtra("prix");
            PrixTextView.setText(PrixString);
        }
        if(intent.hasExtra("Synopsis")){
            Synopsis = intent.getStringExtra("Synopsis");
            textViewSynopsis.setText(Synopsis);
        }
        if(intent.hasExtra("Genre")){
            Genre = intent.getStringExtra("Genre");
            GenreTextView.setText(Genre);
        }
        if(intent.hasExtra("Theme")){
            Theme = intent.getStringExtra("Theme");
            ThemeTextView.setText(Theme);
        }

        if (intent.hasExtra("affiche")){
            Affiche = intent.getStringExtra("affiche");
            if(Affiche.equals("another"))
                this.imageManga.setImageResource(R.drawable.another);
            else if (Affiche.equals("charlotte")) {
                this.imageManga.setImageResource(R.drawable.charlotte);
            }
            else if (Affiche.equals("classroom")) {
                this.imageManga.setImageResource(R.drawable.classroomoftheelite);
            }
            else if (Affiche.equals("cyberpunk")) {
                this.imageManga.setImageResource(R.drawable.cyberpunk_edgerunners);
            }
            else if (Affiche.equals("darling")) {
                this.imageManga.setImageResource(R.drawable.darling_in_the_frankxx);
            }
            else if (Affiche.equals("nana")) {
                this.imageManga.setImageResource(R.drawable.nana);
            }
            else if (Affiche.equals("naruto")) {
                this.imageManga.setImageResource(R.drawable.naruto);
            }
            else if (Affiche.equals("white")) {
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
                intent1.putExtra("titre", Titre);
                intent1.putExtra("mesMangas",mesMangas);
                intent1.putExtra("mesGenres",mesGenres);
                startActivity(intent1);
            }
        });
        ButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DetailMangaActivity.this, DeleteActivity.class);
                intent1.putExtra("mesMangas",mesMangas);
                intent1.putExtra("mesGenres",mesGenres);
                startActivity(intent1);
            }
        });
    }

}
