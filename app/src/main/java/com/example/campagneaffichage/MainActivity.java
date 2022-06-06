package com.example.campagneaffichage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.campagneaffichage.temporaire.PI;
import com.example.campagneaffichage.temporaire.Secteur;
import com.example.campagneaffichage.temporaire.testglobal;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//ajout de donnée
        ((testglobal) this.getApplication()).addListePi( new PI("point1","30","30","4 rue abc","4","panneau","mail"));
        ((testglobal) this.getApplication()).addListePi(new PI("point2","50","50","5 rue abc","9","panneau","physique"));
        ((testglobal) this.getApplication()).addListePi(new PI("point3","60","60","7 rue abb","20","panneau","mail"));
        ArrayList<PI> sect1pi = new ArrayList<PI>();
        sect1pi.add(((testglobal) this.getApplication()).getUnPi(0));
        sect1pi.add(((testglobal) this.getApplication()).getUnPi(1));
        ((testglobal) this.getApplication()).addListeSecteur(new Secteur("sect1",sect1pi));
        ArrayList<PI> sect2pi = new ArrayList<PI>();
        sect2pi.add(((testglobal) this.getApplication()).getUnPi(1));
        sect2pi.add(((testglobal) this.getApplication()).getUnPi(2));
        ((testglobal) this.getApplication()).addListeSecteur(new Secteur("sect2",sect2pi));
        Log.i("messagederapport1",((testglobal) this.getApplication()).getListePi().toString());
        Log.i("messagederapport1",((testglobal) this.getApplication()).getUnPi(0).toString());
        Log.i("messagederapport1",((testglobal) this.getApplication()).getUnPi(0).getNom());
        //chercher les boutons dans l'activity
        Button AddPI = findViewById(R.id.buttonAddPi);
        Button AddSecteur = findViewById(R.id.buttonAddSecteur);
        Button ModSecteur = findViewById(R.id.buttonModSecteur);
        Button VoirSecteur = findViewById(R.id.buttonVoirSecteur);

        //changement d'activity sur les boutons
        Intent AddPIintent = new Intent(this, AddPI.class);
        AddPI.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(AddPIintent);
            }
        });
        Intent AddSecteurintent = new Intent(this, AddSecteur.class);
        AddSecteur.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(AddSecteurintent);
            }
        });
        Intent VoirSecteurintent = new Intent(this, ChoixSecteurVisualisation.class);
        VoirSecteur.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(VoirSecteurintent);
            }
        });
        Intent ModifSecteurintent = new Intent(this, choixSecteurModif.class);
        ModSecteur.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(ModifSecteurintent);
            }
        });

    }

}