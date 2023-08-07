package com.example.prueba02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class Leidos extends AppCompatActivity {

    //ID seleccionado para luego enviar a editar
    String datosObtenidos;
    // Crea una instancia de MyDatabaseHelper con el contexto adecuado
    MyDatabaseHelper dbHelper = new MyDatabaseHelper(this);

    int Fband = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leidos);

        // Llama al método insertDatos() de MyDatabaseHelper para insertar los datos
        // dbHelper.insertDatos("Título del libro", "Autor del libro", 4.5);

        // Llama al método obtenerDatos() de MyDatabaseHelper para obtener los datos

        //Array List para añadir los libros
        ArrayList<String> listaDatos = new ArrayList<>();

        //Obtener el numero de registros

        Fband = dbHelper.getRowCount();

        if (Fband > 0) {


            for (int a = 1; a <= Fband; a++) {





                datosObtenidos = dbHelper.obtenerDatos(a,"Leido");

                if(datosObtenidos.equals("")){

                }
                else{

                    listaDatos.add(datosObtenidos);
                }

            }
            //Indicar a que lista corresponde
            ListView lista = findViewById(R.id.listaLibros);
            //Asignamos un click listener
            lista.setOnItemClickListener(this::onItemClick);
            //Crear un adaptador para meter los parametros
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaDatos);
            lista.setAdapter(adapter);

        }
    }



    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        //Obtenemos el String del objeto seleccionado
        String itemTexto = (String) parent.getItemAtPosition(position);

        String resultado = "";
        for (char c : itemTexto.toCharArray()) {
            if (c != '.') {
                resultado += c;
            } else {
                break; // Sale del bucle cuando encuentra un punto
            }
        }



        Intent intent = new Intent(Leidos.this, EditarLibro.class);
        //Le mandas la variable miVariable con valor del idSeleccionado
        intent.putExtra("miVariable",resultado);
        //Iniciar Actividad
        startActivity(intent);





    }
}