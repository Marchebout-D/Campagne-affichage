package com.example.campagneaffichage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.campagneaffichage.temporaire.PI;
import com.example.campagneaffichage.temporaire.Secteur;
import com.example.campagneaffichage.temporaire.testglobal;

import org.osmdroid.config.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ChoixSecteurVisualisation extends AppCompatActivity {
    private LinearLayout myLayout;
    ArrayList<Secteur> Listesecteur = new ArrayList<Secteur>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_secteur_visualisation);
        ArrayList<Secteur> Listesecteur = ((testglobal) this.getApplication()).getListeSecteur();
        Log.i("message rapport",Listesecteur.toString());
        Button validation = findViewById(R.id.buttonVis);
        Spinner spinsect =findViewById(R.id.spinnerchoixsecteur);
        String Newligne= System.getProperty("line.separator");
        final Secteur[] secteurchoisie = new Secteur[1];
        Intent VoirSecteur = new Intent(this, VoirSecteur.class);
        //spinner
        List<String> ListsecteurNom = new ArrayList<String>();
        for(Secteur s : Listesecteur)
            ListsecteurNom.add(s.getLibelle());
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,ListsecteurNom);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinsect.setAdapter(dataAdapter);

        spinsect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {

                for(Secteur s : Listesecteur) {
                    Log.i("messagederapport",s.getLibelle()+Newligne+parent.getItemAtPosition(position).toString());
                    if(s.getLibelle()==parent.getItemAtPosition(position).toString()){

                        secteurchoisie[0] = s;

                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }

        });
        //validation données
        validation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((testglobal) ChoixSecteurVisualisation.this.getApplication()).setSecteurChoisi(secteurchoisie[0]);
                Log.i("messagederapport", secteurchoisie[0].toString());
                Log.i("messagederapport",((testglobal) ChoixSecteurVisualisation.this.getApplication()).getSecteurChoisi().toString());
                startActivity(VoirSecteur);
            }
        });

        /*titre.setText("Quel secteur souhaiter vous visualiser?");
        titre.setTextSize(25);
        myLayout.addView(titre);
        int id =0;
        for(Secteur s:Listesecteur){

            Log.i("message de rapport","rentrer boucle");
            Button button = new Button(this);
            button.setId(id);
            id =id+1;
            final int id_ = button.getId();
            button.setBackgroundColor(Color.rgb(70, 80, 90));
            String nomsect = s.getLibelle();
            button.setText(nomsect);
            button.setTextSize(25);
            myLayout.addView(button);
            btn1 = ((Button) findViewById(id_));
            btn1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),
                            "Button clicked index = " + id_, Toast.LENGTH_SHORT)
                            .show();
                }
            });*/


    }
}