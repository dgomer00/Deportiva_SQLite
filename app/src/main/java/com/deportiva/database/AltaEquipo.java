package com.deportiva.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.deportiva.main.R;

public class AltaEquipo extends ActionBarActivity {
    EditText ET_Nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_equipo);

        ET_Nombre = (EditText)findViewById(R.id.editTextAltaEquipo);
    }

    public void guardarDatos(View view){

        if(!campoVacio()) {
            //Hacerlo dentro de try catch en el caso de leer un string y pasarlo a integer
            String Nombre = ET_Nombre.getText().toString();


            BaseDatosOpenHelper baseHelper = new BaseDatosOpenHelper(this, "BaseDatosDeportiva", null, 1);
            SQLiteDatabase db = baseHelper.getWritableDatabase();
            if (db != null) {
                ContentValues registroNuevo = new ContentValues();
                registroNuevo.put("Nombre", Nombre);
                long i = db.insert("Equipos", null, registroNuevo);
                if (i > 0) {
                    Toast.makeText(this, "Registro Insertado", Toast.LENGTH_SHORT).show();
                }

            }
        }else{
            Toast.makeText(this, "Rellene el dato", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean campoVacio(){
        boolean vacio =false;
        if(ET_Nombre.getText().toString().isEmpty()){
            vacio=true;
            return vacio;
        }
        return vacio;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_alta_equipo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
