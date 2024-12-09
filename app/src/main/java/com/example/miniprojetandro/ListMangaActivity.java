package com.example.miniprojetandro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListMangaActivity extends AppCompatActivity {
    private ArrayList<Genre> mesGenres;
    private Button btnAjout;
    private ListView listView;
    private ArrayList<Manga> mesMangas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_listmanga);
        initGenre();
        initMangas();
        initialisation();
    }

    private void initGenre(){
        mesGenres = new ArrayList<>();
        mesGenres.add(new Genre("shonen"));
        mesGenres.add(new Genre("seinen"));
        mesGenres.add(new Genre("shojo"));
    }

    private void initMangas(){
        mesMangas = new ArrayList<Manga>();
        mesMangas.add(new Manga("Nana", "Ai Yazawa", 21, (float)7.9, "romance", mesGenres.get(1)));
        mesMangas.add(new Manga("Another", "Yukito Ayatsuji", 4, (float)8.2, "mystery", mesGenres.get(2))); // seinen
        mesMangas.add(new Manga("White Album 2", "Fumiaki Maruto", 3, (float)8.5, "drama", mesGenres.get(3))); // shojo
        mesMangas.add(new Manga("Naruto", "Masashi Kishimoto", 72, (float)8.0, "action", mesGenres.get(1))); // shonen
        mesMangas.add(new Manga("Darling in the Franxx", "Code:000", 8, (float)7.5, "sci-fi", mesGenres.get(1))); // shonen
        mesMangas.add(new Manga("Classroom of the Elite", "Shōgo Kinugasa", 11, (float)8.6, "psychological", mesGenres.get(2))); // seinen
        mesMangas.add(new Manga("Cyberpunk: Edgerunners", "CD Projekt", 1, (float)8.7, "sci-fi", mesGenres.get(2))); // seinen
        mesMangas.add(new Manga("Charlotte", "Jun Maeda", 6, (float)7.8, "supernatural", mesGenres.get(3))); // shojo
    }

    private void initialisation(){
        Intent intent = getIntent();
        mesMangas = (ArrayList<Manga>)getIntent().getSerializableExtra("MesMangas");
        mesGenres = (ArrayList<Genre>)getIntent().getSerializableExtra("MesGenre");

        btnAjout = (Button) findViewById(R.id.btnAdd);
        listView = (ListView) findViewById(R.id.ListeViewMangas);

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mesMangas.stream().map(h->h.getTitre()).collect(Collectors.toList()));
        listView.setAdapter(adp);

        btnAjout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ListMangaActivity.this, CreateActivity.class);
                intent1.putExtra("MesMangas", mesMangas);
                intent1.putExtra("MesGenres", mesGenres);
                startActivity(intent1);
            }
        });
    }

}
