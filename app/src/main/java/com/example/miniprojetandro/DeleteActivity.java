package com.example.miniprojetandro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DeleteActivity extends AppCompatActivity {
    private Button ButtonSureDelete, ButtonBackAttention;
    private ArrayList<Manga> mesMangas;
    private ArrayList<Genre> mesGenres;
    private Manga manga;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_deletemanga);
        initialisation();
    }
    private void initialisation(){
        ButtonSureDelete = (Button) findViewById(R.id.ButtonSureDelete);
        ButtonBackAttention = (Button) findViewById(R.id.ButtonBackAttention);
        mesMangas = (ArrayList<Manga>)getIntent().getSerializableExtra("MesMangas");
        mesGenres = (ArrayList<Genre>)getIntent().getSerializableExtra("MesGenres");
        Intent intent = getIntent();
        manga = (Manga) intent.getSerializableExtra("selectedManga");


        ButtonSureDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0; i < mesMangas.size(); i++) {
                    Manga manga1 = mesMangas.get(i);
                    if (manga.getTitre().equals(manga1.getTitre())) {
                        mesMangas.remove(i);
                        break;
                    }
                }
                Intent intent1 = new Intent(DeleteActivity.this, ListMangaActivity.class);
                intent1.putExtra("MesMangas",mesMangas);
                intent1.putExtra("MesGenre",mesGenres);
                startActivity(intent1);

            }
        });
        ButtonBackAttention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DeleteActivity.this, DetailMangaActivity.class);
                intent1.putExtra("selectedManga", manga);
                intent1.putExtra("MesMangas",mesMangas);
                intent1.putExtra("MesGenre",mesGenres);
                startActivity(intent1);
            }
        });
    }

}
