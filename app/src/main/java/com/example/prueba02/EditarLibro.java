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

        String LibroAntiguo=dbHelper.obtenerTitulo(Integer.parseInt(idSeleccionado));
        String AutorAntiguo= dbHelper.obtenerAutor(Integer.parseInt(idSeleccionado));
        String RatingAntiguo= dbHelper.obtenerRating(Integer.parseInt(idSeleccionado));



        EditText Libro = findViewById(R.id.ETLibro);
        EditText Autor = findViewById(R.id.ETAutor);
        EditText Rating = findViewById(R.id.ETRating);

        Libro.setText(LibroAntiguo);
        Autor.setText(AutorAntiguo);
        Rating.setText(RatingAntiguo);

            //Variable boton igual al boton de editar
            Button Editar = findViewById(R.id.BtnEditar);
            EditText ETLibro = findViewById(R.id.ETLibro);
            EditText ETAutor = findViewById(R.id.ETAutor);
            EditText ETRating = findViewById(R.id.ETRating);

            Editar.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {

                    int idCambiar=Integer.parseInt(idSeleccionado);
                    String libroCambiar=ETLibro.getText().toString();
                    String autorCambiar=ETAutor.getText().toString();
                    double ratingCambiar=Double.parseDouble(ETRating.getText().toString());

                    Toast.makeText(EditarLibro.this, libroCambiar, Toast.LENGTH_LONG).show();

                    dbHelper.actualizarRegistro(idCambiar,libroCambiar,autorCambiar,ratingCambiar);
                    Intent intent = new Intent(EditarLibro.this, Ventana1.class);
                    startActivity(intent);

                }


            });




    }



}