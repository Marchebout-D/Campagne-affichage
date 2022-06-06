package com.example.campagneaffichage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.campagneaffichage.temporaire.PI;
import com.example.campagneaffichage.temporaire.Secteur;
import com.example.campagneaffichage.temporaire.testglobal;

import java.util.ArrayList;
import java.util.List;

public class AddSecteur extends AppCompatActivity {
String libelle;
ArrayList<PI> ListePI = new ArrayList<PI>();
ArrayList<PI> ListePIEnCour = new ArrayList<PI>();
String Newligne= System.getProperty("line.separator");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_secteur);
        Log.i("messagederapport1",((testglobal) this.getApplication()).getUnPi(0).getNom());
        //recup donnée
        Log.i("messagedeerreur", String.valueOf(((testglobal) this.getApplication()).getNbPI()));
        ArrayList<PI> ListePI = ((testglobal) this.getApplication()).getListePi();

        //récuperation des élements
        EditText editnomSecteur = findViewById(R.id.editTextNomSecteur);
        Button valider = findViewById(R.id.buttonValidsecteur);
        Spinner spinListePI =findViewById(R.id.spinnerPI);
        TextView ListePIVisuel = findViewById(R.id.textViewListePIadd);
        //gestion du spinner
        List<String> ListePINom = new ArrayList<String>();
        for(PI s : ListePI)
            ListePINom.add(s.getNom());
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,ListePINom);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinListePI.setAdapter(dataAdapter);

        spinListePI.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {

                for(PI s : ListePI) {
                    Log.i("messagederapport",s.getNom()+Newligne+parent.getItemAtPosition(position).toString());
                    if(s.getNom()==parent.getItemAtPosition(position).toString()){

                       ListePIEnCour.add(s);
                       ListePIVisuel.setText(ListePIVisuel.getText()+s.getNom()+Newligne);
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }

        });
        //validation données
        valider.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Secteur unSecteur = new Secteur(libelle,ListePIEnCour);
                ((testglobal) AddSecteur.this.getApplication()).addListeSecteur(unSecteur);
                Log.i("messagederapport",unSecteur.toString());
                Log.i("messagederapport",((testglobal) AddSecteur.this.getApplication()).getListePi().toString()+Newligne+((testglobal) AddSecteur.this.getApplication()).getListeSecteur().toString());
            }
        });
    }
}