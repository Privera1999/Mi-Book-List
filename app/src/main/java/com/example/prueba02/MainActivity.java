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
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuItem;
public class MainActivity extends AppCompatActivity {

    MyDatabaseHelper dbHelper = new MyDatabaseHelper(this);






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Crea una instancia de MyDatabaseHelper
        dbHelper = new MyDatabaseHelper(this);


        //Barra de Navegacion

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.getMenu().setGroupCheckable(0, true, false);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
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
        bottomNavigationView.getMenu().getItem(0).setChecked(false);
        bottomNavigationView.getMenu().getItem(1).setChecked(false);
        bottomNavigationView.getMenu().getItem(2).setChecked(false);
        bottomNavigationView.getMenu().getItem(3).setChecked(false);





















    }


    }



