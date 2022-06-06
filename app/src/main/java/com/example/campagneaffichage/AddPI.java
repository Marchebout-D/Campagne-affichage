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

import com.example.campagneaffichage.temporaire.PI;
import com.example.campagneaffichage.temporaire.testglobal;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AddPI extends AppCompatActivity {
    String nom,lat,longi,adrr,aff,typechoisi,modeChoisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pi4);

        String messageValidation = "";
        //trouver les edittext
        EditText editnom = findViewById(R.id.editTextNom);
        EditText editlat = findViewById(R.id.editTextLat);
        EditText editLong = findViewById(R.id.editTextLong);
        EditText editadrr = findViewById(R.id.editTextAddress);
        EditText editnbaff = findViewById(R.id.editTextAffiches);
        //button
        Button valider = findViewById(R.id.buttonVal);
        //les listes déroulante
        Spinner spintype =findViewById(R.id.spinnerType);
        Spinner spinMode = findViewById(R.id.spinnerMode);
        //gestion spinner
        //spintype
        List<String> type = new ArrayList<String>();
        type.add("panneau");
        type.add("local");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,type);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spintype.setAdapter(dataAdapter);

        spintype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                typechoisi = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }

        });

        //spin mode
        List<String> mode = new ArrayList<String>();
        mode.add("mail");
        mode.add("physique");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapterdeux = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,mode);
        // Drop down layout style - list view with radio button
        dataAdapterdeux.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinMode.setAdapter(dataAdapterdeux);
        spinMode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                modeChoisi = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }

        });
        //validation des données
        valider.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nom = editnom.getText().toString();
                lat = editlat.getText().toString();
                longi = editLong.getText().toString();
                adrr = editadrr.getText().toString();
                aff = editnbaff.getText().toString();
                String Newligne= System.getProperty("line.separator");
                String message = nom + Newligne + lat +Newligne+longi+Newligne+adrr+Newligne+aff+Newligne+typechoisi+Newligne+modeChoisi;
                Log.i("messagederapport",message);
                JSONObject object = new JSONObject();
                try {
                    object.put("nom", nom);
                    object.put("latitude", lat);
                    object.put("longitude", longi);
                    object.put("adresse", adrr);
                    object.put("affiche", aff);
                    object.put("type", typechoisi);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.i("messagederapport",object.toString());
                PI nouveauPi = new PI(nom,lat,longi,adrr,aff,typechoisi,modeChoisi);
                ((testglobal) AddPI.this.getApplication()).addListePi(nouveauPi);
                Log.i("messagederapport",((testglobal) AddPI.this.getApplication()).getListePi().toString());
                ArrayList<PI> ListePI = ((testglobal) AddPI.this.getApplication()).getListePi();
                Log.i("messagederapport2",ListePI.toString());
            }
        });


    }
}