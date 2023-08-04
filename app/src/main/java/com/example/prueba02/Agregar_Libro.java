package com.example.prueba02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RatingBar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prueba02.MyDatabaseHelper;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Agregar_Libro extends AppCompatActivity {

    MyDatabaseHelper dbHelper = new MyDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_libro);

        RatingBar ratingBar = findViewById(R.id.ratingBar);
        EditText Libro = findViewById(R.id.ETLibro);
        Spinner spinner = findViewById(R.id.spinnerOptions);
        Button Agregar = findViewById(R.id.btnAgregar);


        Agregar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                String libroCambiar=Libro.getText().toString();
                String autorCambiar;
                double ratingbarCambiar = (ratingBar.getRating());

                if(spinner.getSelectedItemId()==0){
                    autorCambiar="Leido";
                }
                else if (spinner.getSelectedItemId()==1){
                    autorCambiar="Empezado";
                }
                else{
                    autorCambiar="Sin Empezar";
                }


                // Toast.makeText(EditarLibro.this, libroCambiar, Toast.LENGTH_LONG).show();

                dbHelper.insertDatos(libroCambiar,autorCambiar,ratingbarCambiar);

                Intent intent = new Intent(Agregar_Libro.this, MainActivity.class);
                startActivity(intent);

            }


        });



    }
}