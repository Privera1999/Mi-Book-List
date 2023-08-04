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
import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;




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

        String LibroAntiguo=dbHelper.obtenerTitulo(Integer.parseInt(idSeleccionado));
        String AutorAntiguo= dbHelper.obtenerAutor(Integer.parseInt(idSeleccionado));
        String RatingAntiguo= dbHelper.obtenerRating(Integer.parseInt(idSeleccionado));


        RatingBar ratingBar = findViewById(R.id.ratingBar);
        EditText Libro = findViewById(R.id.ETLibro);
        Spinner spinner = findViewById(R.id.spinnerOptions);
        Libro.setText(LibroAntiguo);



        //Autor.setText(AutorAntiguo);
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
                Intent intent = new Intent(EditarLibro.this, Ventana1.class);
                startActivity(intent);

            }


        });






    }



}