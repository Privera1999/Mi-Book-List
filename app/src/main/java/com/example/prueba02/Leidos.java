package com.example.prueba02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuItem;

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


        //Barra de navegacion

        BottomNavigationView bottomNavigationView4 = findViewById(R.id.bottomNavigationView);
        bottomNavigationView4.getMenu().setGroupCheckable(0, true, false);

        bottomNavigationView4.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.menu_item1) {
                Intent intent1 = new Intent(this, Empezado.class);
                startActivity(intent1);
                return true;
            } else if (item.getItemId() == R.id.menu_item2) {
                Intent intent1 = new Intent(this, Ventana1.class);
                startActivity(intent1);
                return true;
            } else if (item.getItemId() == R.id.menu_item3) {
                Intent intent2 = new Intent(this, Leidos.class);
                startActivity(intent2);
                return true;
            }
            else if (item.getItemId() == R.id.menu_item4) {
                Intent intent3 = new Intent(this, Agregar_Libro.class);
                startActivity(intent3);
                return true;
            }
            return false;
        });

        // Desmarcar cualquier ítem por defecto que pueda estar marcado
        bottomNavigationView4.getMenu().getItem(0).setChecked(false);
        bottomNavigationView4.getMenu().getItem(1).setChecked(false);
        bottomNavigationView4.getMenu().getItem(2).setChecked(false);
        bottomNavigationView4.getMenu().getItem(3).setChecked(false);


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
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item_black_text, listaDatos);
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