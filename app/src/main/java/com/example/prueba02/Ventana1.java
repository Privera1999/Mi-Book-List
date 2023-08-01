package com.example.prueba02;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import com.example.prueba02.MyDatabaseHelper;




public class Ventana1 extends AppCompatActivity {

    String datosObtenidos;
    // Crea una instancia de MyDatabaseHelper con el contexto adecuado
    MyDatabaseHelper dbHelper = new MyDatabaseHelper(this);


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana1);

        // Llama al método insertDatos() de MyDatabaseHelper para insertar los datos
       dbHelper.insertDatos("Título del libro", "Autor del libro", 4.5);

        // Llama al método obtenerDatos() de MyDatabaseHelper para obtener los datos
        datosObtenidos = dbHelper.obtenerDatos();


        // Obtén una referencia al TextView por su id
        EditText textViewDatos = findViewById(R.id.Etautor);

        // Asigna el valor de la variable "datos" al TextView
        textViewDatos.setText(datosObtenidos);
    }



}















