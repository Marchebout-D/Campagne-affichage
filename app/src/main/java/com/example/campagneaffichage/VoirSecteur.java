package com.example.campagneaffichage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;

import com.example.campagneaffichage.temporaire.PI;
import com.example.campagneaffichage.temporaire.Secteur;
import com.example.campagneaffichage.temporaire.testglobal;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.ArrayList;


public class VoirSecteur extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        /*StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));*/
        setContentView(R.layout.activity_voir_secteur);
        Configuration.getInstance().load(getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));


        MapView map;
        ArrayList<OverlayItem> overlayItems = new ArrayList<OverlayItem>();

        map = findViewById(R.id.map);//recuperation de la map dans le layout
        map.setTileSource(TileSourceFactory.MAPNIK);//render la forme de la carte
        map.setBuiltInZoomControls(true);//zoomable
        GeoPoint startPoint = new GeoPoint(45.936698, -0.961697);//coord rochefort objet de coor
        IMapController mapController = map.getController();//initialisation du controleur de la carte
        mapController.setCenter(startPoint); //centrer la carte sur rochefort
        mapController.setZoom(18);//mettre le zoom de base
//creation d'un point
        Secteur SecteurChoisie = ((testglobal) this.getApplication()).getSecteurChoisi();
        ArrayList<PI> ListePI = SecteurChoisie.getListePI();
        Drawable image2 = this.getApplicationContext().getDrawable(R.drawable.ic_action_name);
        ArrayList<Marker> markerlist = new ArrayList<Marker>();
        ArrayList<GeoPoint> geolist = new ArrayList<GeoPoint>();
        int index = 0;
        for(PI s : ListePI) {

            markerlist.add(new Marker(map));
            geolist.add(new GeoPoint(Double.parseDouble(s.getLatitude()), Double.parseDouble(s.getLongitude())));
            markerlist.get(index).setPosition(geolist.get(index));
            markerlist.get(index).setIcon(image2);
            markerlist.get(index).setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
            map.getOverlays().add(markerlist.get(index));
            index = index +1 ;
        }

    }
}