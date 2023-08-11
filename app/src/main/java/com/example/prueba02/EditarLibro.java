package com.example.prueba02;

import androidx.appcompat.app.AppCompatActivity;

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



public class EditarLibro extends Ventana1 {


    String idSeleccionado;
    MyDatabaseHelper dbHelper = new MyDatabaseHelper(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_libro);

        //Barra de navegacion

        BottomNavigationView bottomNavigationView2 = findViewById(R.id.bottomNavigationView);
        bottomNavigationView2.getMenu().setGroupCheckable(0, true, false);

        bottomNavigationView2.setOnNavigationItemSelectedListener(item -> {
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
        bottomNavigationView2.getMenu().getItem(0).setChecked(false);
        bottomNavigationView2.getMenu().getItem(1).setChecked(false);
        bottomNavigationView2.getMenu().getItem(2).setChecked(false);
        bottomNavigationView2.getMenu().getItem(3).setChecked(false);


        //Obtener la variable del id seleccionado de la otra ventana
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String miVariable = extras.getString("miVariable");
            //Lo asociamos a la variable IdSeleccionado
            idSeleccionado=miVariable;

        }

        //Obtenemos los datos del libro seleccionado anteriormente

        String LibroAntiguo=dbHelper.obtenerTitulo(Integer.parseInt(idSeleccionado));
        String AutorAntiguo= dbHelper.obtenerAutor(Integer.parseInt(idSeleccionado));
        String RatingAntiguo= dbHelper.obtenerRating(Integer.parseInt(idSeleccionado));

        //Creacion de variables
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        EditText Libro = findViewById(R.id.ETLibro);
        Spinner spinner = findViewById(R.id.spinnerOptions);
        Libro.setText(LibroAntiguo);


        ratingBar.setRating(Float.parseFloat(RatingAntiguo));

        if(AutorAntiguo.equals("Leido")){
            spinner.setSelection(0);
        }
        else if (AutorAntiguo.equals("Empezado")){
            spinner.setSelection(1);
        }
        else {
            spinner.setSelection(2);
        }

            //Variable boton igual al boton de editar
            Button Editar = findViewById(R.id.BtnEditar);
            EditText ETLibro = findViewById(R.id.ETLibro);
          //  EditText ETAutor = findViewById(R.id.ETAutor);
            Button Borrar = findViewById(R.id.btnBorrar);



            Editar.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {

                    int idCambiar=Integer.parseInt(idSeleccionado);
                    String libroCambiar=ETLibro.getText().toString();
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

                    dbHelper.actualizarRegistro(idCambiar,libroCambiar,autorCambiar,ratingbarCambiar);
                    Intent intent = new Intent(EditarLibro.this, Ventana1.class);
                    startActivity(intent);

                }


            });


        Borrar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                dbHelper.eliminarLibro(Integer.parseInt(idSeleccionado));
                dbHelper.actualizarIDs(Integer.parseInt(idSeleccionado));

                //Dependiendo de a que lista mande el libro abre la lista correspondiente

                if(spinner.getSelectedItemId()==0){
                    Intent intent = new Intent(EditarLibro.this, Leidos.class);
                    startActivity(intent);
                }
                else if (spinner.getSelectedItemId()==1){
                    Intent intent = new Intent(EditarLibro.this, Empezado.class);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(EditarLibro.this, Ventana1.class);
                    startActivity(intent);
                }



            }


        });








    }



}