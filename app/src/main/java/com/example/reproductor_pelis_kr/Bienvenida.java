package com.example.reproductor_pelis_kr;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Bienvenida extends AppCompatActivity {

    SharedPreferences preferences;

    TextView Nom;

    String User, Cont, Edades, Genero;

    Button Registro, Menu, Reg, Can;
    int n = 0, ed;

    EditText Usu, Pass, Edad, Gen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        Registro = findViewById(R.id.Registro);
        Menu = findViewById(R.id.Menu);
        Nom = findViewById(R.id.Nom);



        Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogoP();
            }
        });


        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Menu.class);
                startActivity(i);
            }
        });

    }

    private void leerOpc() {
        preferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        String nom = preferences.getString("user", "0");
        Nom.setText("Binvenid@ "+nom);
    }

    private void DialogoP(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.registro, null);
        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();

        Reg = view.findViewById(R.id.Reg);
        Can = view.findViewById(R.id.Can);
        Usu = view.findViewById(R.id.Usuario);
        Pass = view.findViewById(R.id.Pass);
        Edad = view.findViewById(R.id.Edad);
        Gen = view.findViewById(R.id.Gen);

        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User = Usu.getText().toString();
                Cont = Pass.getText().toString();
                Edades = Edad.getText().toString();
                Genero = Gen.getText().toString();


                if (User.isEmpty() || Cont.isEmpty() || Edades.isEmpty() || Genero.isEmpty()) {
                    Toast.makeText(Bienvenida.this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Bienvenida.this, "Registrado. Ahora puedes acceder al Menú", Toast.LENGTH_LONG).show();
                    n = 1;
                    ed = Integer.parseInt(Edades);
                    GUs(User);
                    GPass(Cont);
                    GEdad(ed);
                    GGen(Genero);
                    if (n == 1){
                        Menu.setVisibility(View.VISIBLE);
                    }
                    leerOpc();
                    dialog.dismiss();
                }
            }
        });

        Can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Bienvenida.this, "Cancelado", Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });

    }

    private void GGen(String genero) {
        preferences=getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("gen",genero);
        editor.commit();
    }

    private void GEdad(int ed) {
        preferences=getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("edad",ed);
        editor.commit();
    }

    private void GPass(String cont) {
        preferences=getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("pass",cont);
        editor.commit();
    }

    private void GUs(String user) {
        preferences=getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user",user);
        editor.commit();
    }
}