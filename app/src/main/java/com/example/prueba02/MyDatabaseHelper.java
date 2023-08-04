package com.example.prueba02;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;


public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "my_database.db";
    private static final int DATABASE_VERSION = 1;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crea las tablas que necesites aquí
        db.execSQL("CREATE TABLE IF NOT EXISTS TLibros (id INTEGER PRIMARY KEY AUTOINCREMENT , Titulo TEXT, Autor TEXT, Rating DOUBLE)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Si necesitas hacer cambios en la estructura de la base de datos
        // puedes gestionarlos aquí
    }

    // Inserta los datos en la tabla mi_tabla
    public void insertDatos(String Titulo, String Autor, Double Rating) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Titulo", Titulo);
        values.put("AUTOR", Autor);
        values.put("Rating", Rating);

        // Inserta los datos en la tabla mi_tabla
        long resultado = db.insert("TLibros", null, values);


        db.close();


    }

    public String obtenerDatos(int a,String b) {
        String datos = "";
        SQLiteDatabase db = getReadableDatabase();

        // Realiza una consulta para obtener los datos de la tabla TLibros
        Cursor cursor = db.rawQuery("SELECT Titulo, Autor, Rating FROM TLibros WHERE id = ? AND Autor LIKE ?", new String[]{String.valueOf(a), b});


        // Itera a través del cursor para obtener los datos
        while (cursor.moveToNext()) {
            String titulo = cursor.getString(cursor.getColumnIndex("Titulo"));
            String autor = cursor.getString(cursor.getColumnIndex("Autor"));
            double rating = cursor.getDouble(cursor.getColumnIndex("Rating"));

            // Concatena los datos en el string "datos"
            datos = titulo + "  " + autor + " " + rating+" ";
        }

        // Cierra el cursor después de obtener los datos
        cursor.close();

        // Cierra la base de datos
        db.close();

        // Devuelve los datos obtenidos como un String
        return datos;
    }


    public int getRowCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        int count = 0;

        try {
            // Ejecuta la consulta COUNT para obtener el número de registros
            cursor = db.rawQuery("SELECT COUNT(*) FROM Tlibros ", null);
            if (cursor.moveToFirst()) {
                count = cursor.getInt(0);
            }
        } catch (Exception e) {
            // Maneja cualquier excepción que pueda ocurrir
            e.printStackTrace();
        } finally {
            // Cierra el cursor y la base de datos
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }

        return count;
    }

    //Editar un registro
    public void actualizarRegistro(int idRegistro, String nuevoTitulo, String nuevoAutor, double nuevoRating) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("Titulo", nuevoTitulo);
        values.put("Autor", nuevoAutor);
        values.put("Rating", nuevoRating);

        // Actualiza el registro en la tabla TLibros donde el ID coincide con el idRegistro
        int filasActualizadas = db.update("TLibros", values, "id=?", new String[]{String.valueOf(idRegistro)});

        // Verifica si se actualizó al menos una fila
        if (filasActualizadas > 0) {
            // Se actualizó el registro exitosamente
        } else {
            // No se pudo encontrar el registro con el ID proporcionado o no se realizaron cambios
        }

        db.close();
    }

    public String obtenerTitulo(int a) {
        String datos = "";
        SQLiteDatabase db = getReadableDatabase();

        // Realiza una consulta para obtener los datos de la tabla TLibros
        Cursor cursor = db.rawQuery("SELECT Titulo FROM TLibros WHERE id= "+a, null);

        // Itera a través del cursor para obtener los datos
        while (cursor.moveToNext()) {
            String titulo = cursor.getString(cursor.getColumnIndex("Titulo"));

            // Concatena los datos en el string "datos"
            datos = titulo;
        }

        // Cierra el cursor después de obtener los datos
        cursor.close();

        // Cierra la base de datos
        db.close();

        // Devuelve los datos obtenidos como un String
        return datos;
    }

    public String obtenerAutor(int a) {
        String datos = "";
        SQLiteDatabase db = getReadableDatabase();

        // Realiza una consulta para obtener los datos de la tabla TLibros
        Cursor cursor = db.rawQuery("SELECT Autor FROM TLibros WHERE id= "+a, null);

        // Itera a través del cursor para obtener los datos
        while (cursor.moveToNext()) {
            String autor = cursor.getString(cursor.getColumnIndex("Autor"));

            // Concatena los datos en el string "datos"
            datos = autor;
        }

        // Cierra el cursor después de obtener los datos
        cursor.close();

        // Cierra la base de datos
        db.close();

        // Devuelve los datos obtenidos como un String
        return datos;
    }

    public String obtenerRating(int a) {
        String datos = "";
        SQLiteDatabase db = getReadableDatabase();

        // Realiza una consulta para obtener los datos de la tabla TLibros
        Cursor cursor = db.rawQuery("SELECT Rating FROM TLibros WHERE id= "+a, null);

        // Itera a través del cursor para obtener los datos
        while (cursor.moveToNext()) {
            String Rating = cursor.getString(cursor.getColumnIndex("Rating"));

            // Concatena los datos en el string "datos"
            datos = Rating;
        }

        // Cierra el cursor después de obtener los datos
        cursor.close();

        // Cierra la base de datos
        db.close();

        // Devuelve los datos obtenidos como un String
        return datos;
    }


    public void eliminarLibro(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Elimina el registro
        db.delete("TLibros", "id = ?", new String[]{String.valueOf(id)});
        // Actualiza los IDs restantes

        db.close();
    }

    public void actualizarIDs(int variable) {
        SQLiteDatabase db = this.getWritableDatabase();
        String updateQuery = "UPDATE TLibros SET id = id - 1 WHERE id > ?";
        db.execSQL(updateQuery, new Object[]{variable});
        db.close();
    }






}







