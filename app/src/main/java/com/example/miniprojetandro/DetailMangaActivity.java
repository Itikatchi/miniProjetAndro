package com.example.miniprojetandro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailMangaActivity extends AppCompatActivity {
    private TextView TitreTextView, AuteurTextView,NbTomeTextView,PrixTextView,ThemeTextView,GenreTextView,textViewSynopsis;
    private ImageView imageManga;

    private String Titre, Auteur, NbTome, Prix, Theme, Synopsis, Genre, Affiche;
    private Button ButtonUpdate,ButtonDelete,ButtonBack;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailmanga);
        initilialisation();
    }
    private void initilialisation() {
        TitreTextView = (TextView) findViewById(R.id.TitreTextView); // TITRE MANGA
        AuteurTextView = (TextView) findViewById(R.id.AuteurTextView);
        NbTomeTextView = (TextView) findViewById(R.id.NbTomeTextView);
        PrixTextView = (TextView) findViewById(R.id.PrixTextView);
        ThemeTextView = (TextView) findViewById(R.id.ThemeTextView);
        GenreTextView = (TextView) findViewById(R.id.GenreTextView);
        textViewSynopsis = (TextView) findViewById(R.id.textViewSynopsis);
        imageManga = (ImageView) findViewById(R.id.imageManga);


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
            Prix = intent.getStringExtra("prix");
            PrixTextView.setText(Prix);
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
        ButtonUpdate =(Button)  findViewById(R.id.ButtonUpdate);
        ButtonDelete =(Button)  findViewById(R.id.ButtonDelete);
        ButtonBack =(Button)  findViewById(R.id.ButtonBack);
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
                startActivity(intent1);
            }
        });
        ButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DetailMangaActivity.this, DeleteActivity.class);
                intent1.putExtra("titre", Titre);
                startActivity(intent1);
            }
        });
        ButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DetailMangaActivity.this, DeleteActivity.class);
                startActivity(intent1);
            }
        });
    }

}
