package com.example.prueba02;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import com.example.prueba02.MyDatabaseHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.view.View;
import android.widget.Toast;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuItem;

public class Ventana1 extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //ID seleccionado para luego enviar a editar
    String datosObtenidos;
    // Crea una instancia de MyDatabaseHelper con el contexto adecuado
    MyDatabaseHelper dbHelper = new MyDatabaseHelper(this);

    int Fband = 0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana1);


        //Barra de navegacion

        BottomNavigationView bottomNavigationView5 = findViewById(R.id.bottomNavigationView);
        bottomNavigationView5.getMenu().setGroupCheckable(0, true, false);

        bottomNavigationView5.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.menu_item1) {
                Intent intent1 = new Intent(Ventana1.this, Empezado.class);
                startActivity(intent1);
                return true;
            } else if (item.getItemId() == R.id.menu_item2) {
                Intent intent1 = new Intent(Ventana1.this, Ventana1.class);
                startActivity(intent1);
                return true;
            } else if (item.getItemId() == R.id.menu_item3) {
                Intent intent2 = new Intent(Ventana1.this, Leidos.class);
                startActivity(intent2);
                return true;
            }
            else if (item.getItemId() == R.id.menu_item4) {
                Intent intent3 = new Intent(Ventana1.this, Agregar_Libro.class);
                startActivity(intent3);
                return true;
            }
            return false;
        });

        // Desmarcar cualquier ítem por defecto que pueda estar marcado
        bottomNavigationView5.getMenu().getItem(0).setChecked(false);
        bottomNavigationView5.getMenu().getItem(1).setChecked(false);
        bottomNavigationView5.getMenu().getItem(2).setChecked(false);
        bottomNavigationView5.getMenu().getItem(3).setChecked(false);



        //Array List para añadir los libros
        ArrayList<String> listaDatos = new ArrayList<>();

        //Obtener el numero de registros

        Fband = dbHelper.getRowCount();

        //Condicional y bucle para optener 1 a 1 los datos de los registros

        if (Fband > 0) {

            for (int a = 1; a <= Fband; a++) {

                datosObtenidos = dbHelper.obtenerDatos(a,"Sin Empezar");

                    if(datosObtenidos.equals("")){

                    }
                    else{

                listaDatos.add(datosObtenidos);
                }

            }
            //Indicar a que lista corresponde
            ListView lista = findViewById(R.id.listaLibros);
            //Asignamos un click listener
            lista.setOnItemClickListener(this);
            //Crear un adaptador para meter los parametros
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item_black_text, listaDatos);
            lista.setAdapter(adapter);

        }
    }


    @Override
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



        Intent intent = new Intent(Ventana1.this, EditarLibro.class);
        //Le mandas la variable miVariable con valor del idSeleccionado
        intent.putExtra("miVariable",resultado);
        //Iniciar Actividad
        startActivity(intent);



    }


}















