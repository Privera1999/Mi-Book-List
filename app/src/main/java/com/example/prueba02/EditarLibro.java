package com.example.prueba02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prueba02.MyDatabaseHelper;
import android.widget.Button;
import android.view.View;


public class EditarLibro extends Ventana1 {


    String idSeleccionado;
    MyDatabaseHelper dbHelper = new MyDatabaseHelper(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_libro);

        //Obtener la variable del id seleccionado de la otra ventana
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String miVariable = extras.getString("miVariable");
            //Lo asociamos a la variable IdSeleccionado
            idSeleccionado=miVariable;

        }

        EditText Libro = findViewById(R.id.ETLibro);
        Libro.setText(idSeleccionado);

            //Variable boton igual al boton de editar
            Button Editar = findViewById(R.id.BtnEditar);
            Editar.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {




                }


            });




    }



}