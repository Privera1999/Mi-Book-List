package com.example.prueba02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {

    MyDatabaseHelper dbHelper = new MyDatabaseHelper(this);

    String usuariolog="Usuario";
    String passlog= "usuario";

    private Button boton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Crea una instancia de MyDatabaseHelper
        dbHelper = new MyDatabaseHelper(this);

        //Iniciar el boton
        boton = findViewById(R.id.boton);
        Button Agregar = findViewById(R.id.btnAgregar);
        Button leidos = findViewById(R.id.btnLeidos);
        Button empezado = findViewById(R.id.btnEmpezados);



        boton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                    Intent intent = new Intent(MainActivity.this, Ventana1.class);
                    startActivity(intent);

            }

        });

        Agregar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Agregar_Libro.class);
                startActivity(intent);

            }

        });


        leidos.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Leidos.class);
                startActivity(intent);

            }

        });

        empezado.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Empezado.class);
                startActivity(intent);

            }

        });






    }


    }



