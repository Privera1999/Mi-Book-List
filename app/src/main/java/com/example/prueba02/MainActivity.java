package com.example.prueba02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {

    MyDatabaseHelper dbHelper = new MyDatabaseHelper(this);





    String usuariolog="Usuario";
    String passlog= "usuario";

    private Button boton1;
    private EditText usuario;
    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Crea una instancia de MyDatabaseHelper
        dbHelper = new MyDatabaseHelper(this);

        //Iniciar el boton
        boton1 = findViewById(R.id.boton1);


        boton1.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                String usuarioguardado = usuario.getText().toString();
                String passguardado = pass.getText().toString();

               // if (usuarioguardado.equals(usuariolog) && passguardado.equals(passguardado)) {
                  //  Toast.makeText(MainActivity.this, "Usuario Logado Correctamente", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, Ventana1.class);
                    startActivity(intent);

               // }

                //else {

                  //  Toast.makeText(MainActivity.this, "Usuario Incorrecto", Toast.LENGTH_LONG).show();

              //  }



            }



        });

    }


    }



