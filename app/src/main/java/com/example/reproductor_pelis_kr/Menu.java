package com.example.reproductor_pelis_kr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Menu extends AppCompatActivity {

    ImageButton C1, C2, A1, A2, T1, T2;

    Button Regreso;
    int a;
    String nom;

    LinearLayout L1, L2;
    TextView Info;

    int x;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        C1 = findViewById(R.id.C1);
        C2 = findViewById(R.id.C2);
        A1 = findViewById(R.id.A1);
        A2 = findViewById(R.id.A2);
        T1 = findViewById(R.id.T1);
        T2 = findViewById(R.id.T2);
        L1 = findViewById(R.id.L1);
        L2 = findViewById(R.id.L2);
        Info = findViewById(R.id.Info);
        Regreso = findViewById(R.id.Regreso);
        leerOpc();


        if (x>=12){
            L1.setVisibility(View.VISIBLE);
        }
        if(x>18){
            L2.setVisibility(View.VISIBLE);
        }


        C1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Video.class);
                a = 1;
                Ga(a);
                startActivity(i);
            }
        });

        C2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Video.class);
                a = 2;
                Ga(a);
                startActivity(i);
            }
        });

        A1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Video.class);
                a = 3;
                Ga(a);
                startActivity(i);
            }
        });

        A2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Video.class);
                a = 4;
                Ga(a);
                startActivity(i);
            }
        });

        T1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Video.class);
                a = 5;
                Ga(a);
                startActivity(i);
            }
        });

        T2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Video.class);
                a = 6;
                Ga(a);
                startActivity(i);
            }
        });

        Regreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Bienvenida.class);
                startActivity(i);
            }
        });

    }

    private void leerOpc() {
        preferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        x = preferences.getInt("edad", Integer.parseInt("0"));
        nom = preferences.getString("user", "0");
        Info.setText(nom+", según tu edad: "+x+", tienes acceso a los siguientes videos");
    }

    private void Ga(int a) {
        preferences=getSharedPreferences("videos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("video", String.valueOf(a));
        editor.commit();
    }
}