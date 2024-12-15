package com.example.miniprojetandro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Utilisateur> mesUti;
    private EditText editTextLog, editTextMdp;
    private Button btnConnexion;
    private boolean verif;
    private String log, mdp;
    private ArrayList<Manga> mesmangas;
    private ArrayList<Genre> mesgenres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initUser();
        initialisation();
    }

    private void initUser(){
        mesUti = new ArrayList<>();
        mesUti.add(new Utilisateur("jules", "root"));
        mesUti.add(new Utilisateur("yann", "root"));
    }

    private boolean controle(String log, String mdp){
        verif = false;
            for (Utilisateur uti: mesUti){
                if (uti.getLog().equals(log) && uti.getMdp().equals(mdp)){
                    verif = true;
                }
            }
        return verif;
    }

    private void initialisation(){
        editTextLog = (EditText) findViewById(R.id.editTextId);
        editTextMdp = (EditText) findViewById(R.id.editTextPassword);
        btnConnexion = (Button) findViewById(R.id.btnConnexion);

        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                log = editTextLog.getText().toString();
                mdp = editTextMdp.getText().toString();
                if (controle(log, mdp)){
                    Intent intent = new Intent(MainActivity.this, ListMangaActivity.class);
                    intent.putExtra("MesMangas",mesmangas);
                    intent.putExtra("MesGenre",mesgenres);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "Identifiant ou Mot de passe incorect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}