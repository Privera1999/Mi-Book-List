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
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuItem;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
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


        BottomNavigationView bottomNavigationView1 = findViewById(R.id.bottomNavigationView);
        bottomNavigationView1.getMenu().setGroupCheckable(0, true, false);

        bottomNavigationView1.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.menu_item1) {
                Intent intent = new Intent(this, Empezado.class);
                startActivity(intent);
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
        bottomNavigationView1.getMenu().getItem(0).setChecked(false);
        bottomNavigationView1.getMenu().getItem(1).setChecked(false);
        bottomNavigationView1.getMenu().getItem(2).setChecked(false);
        bottomNavigationView1.getMenu().getItem(3).setChecked(false);




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


                Toast.makeText(Agregar_Libro.this, "Libro Agregado Correctamente", Toast.LENGTH_LONG).show();

                dbHelper.insertDatos(libroCambiar,autorCambiar,ratingbarCambiar);

                //Dependiendo de a que lista mande el libro abre la lista correspondiente

                if(spinner.getSelectedItemId()==0){
                    Intent intent = new Intent(Agregar_Libro.this, Leidos.class);
                    startActivity(intent);
                }
                else if (spinner.getSelectedItemId()==1){
                    Intent intent = new Intent(Agregar_Libro.this, Empezado.class);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(Agregar_Libro.this, Ventana1.class);
                    startActivity(intent);
                }


            }


        });




    }
}