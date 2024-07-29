package com.example.reproductor_pelis_kr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Video extends AppCompatActivity {

    SharedPreferences preferences;
    int valor, x;
    String Video;
    TextView NF, EF, GF;

    Button Me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Me = findViewById(R.id.Me);
        NF = findViewById(R.id.NombreF);
        EF = findViewById(R.id.EdadF);
        GF = findViewById(R.id.GeneroF);

        leerOpc();

        Me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Menu.class);
                startActivity(i);
            }
        });

        leerGa();

        if (valor == 1) {
            Video = "android.resource://" + getPackageName() + "/" + R.raw.empatia;
        }
        if (valor == 2) {
            Video = "android.resource://" + getPackageName() + "/" + R.raw.parcialmente_nublado;
        }
        if (valor == 3) {
            Video = "android.resource://" + getPackageName() + "/" + R.raw.levantado;
        }
        if (valor == 4) {
            Video = "android.resource://" + getPackageName() + "/" + R.raw.encriptado;
        }
        if (valor == 5) {
            Video = "android.resource://" + getPackageName() + "/" + R.raw.missing_halloween;
        }
        if (valor == 6) {
            Video = "android.resource://" + getPackageName() + "/" + R.raw.thedollmaker;
        }


        Uri myUri = Uri.parse(Video);
        VideoView view = findViewById(R.id.VideoE);
        view.setVideoURI(myUri);
        MediaController media = new MediaController(this);
        view.setMediaController(media);
        media.setAnchorView(view);
        view.requestFocus();

    }

    private void leerOpc() {
        preferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        String nom = preferences.getString("user", "0");
        NF.setText("Nombre: "+nom);
        x = preferences.getInt("edad", Integer.parseInt("0"));
        EF.setText("Edad: "+x);
        String g = preferences.getString("gen","-");
        GF.setText("Género: "+g);
    }

    private void leerGa() {
        preferences = getSharedPreferences("videos", Context.MODE_PRIVATE);
        valor = Integer.parseInt(preferences.getString("video", "0"));
    }

}