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

    int Fband=0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana1);

        // Llama al método insertDatos() de MyDatabaseHelper para insertar los datos
        // dbHelper.insertDatos("Título del libro", "Autor del libro", 4.5);

        // Llama al método obtenerDatos() de MyDatabaseHelper para obtener los datos

        //Array List para añadir los libros
        ArrayList<String> listaDatos = new ArrayList<>();

        //Obtener el numero de registros

        Fband = dbHelper.getRowCount();

       for(int a = 1;a<=Fband;a++){

           datosObtenidos = dbHelper.obtenerDatos(a);

           listaDatos.add(datosObtenidos);

        }


        //Indicar a que lista corresponde
        ListView lista = findViewById(R.id.listaLibros);
        //Crear un adaptador para meter los parametros
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, listaDatos);
        lista.setAdapter(adapter);

    }



}















