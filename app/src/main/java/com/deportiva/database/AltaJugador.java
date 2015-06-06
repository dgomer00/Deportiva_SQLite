package com.deportiva.database;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.deportiva.main.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AltaJugador extends ActionBarActivity {

    EditText ET_Nombre, ET_NombreDeportivo, ET_FechaNacimiento, ET_LugarNacimiento, ET_Peso, ET_Estatura, ET_Procedencia, ET_Dorsal ;
    Spinner spinner;
    private AutoCompleteTextView ET_Posicion;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_jugador);

        ET_NombreDeportivo = (EditText)findViewById(R.id.editTextNombreJugador);
        ET_Nombre = (EditText)findViewById(R.id.editTextNombreCompletoJugador);
        ET_Posicion = (AutoCompleteTextView)findViewById(R.id.AutoCompletePosicionJugador);
        ET_FechaNacimiento = (EditText)findViewById(R.id.editTextFechaJugador);
        ET_LugarNacimiento = (EditText)findViewById(R.id.editTextLugarNacimientoJugador);
        ET_Peso = (EditText)findViewById(R.id.editTextPesoJugador);
        ET_Estatura = (EditText)findViewById(R.id.editTextEstaturaJugador);
        ET_Procedencia = (EditText)findViewById(R.id.editTextProcedenciaJugador);
        ET_Dorsal = (EditText)findViewById(R.id.editTextDorsalJugador);
        //----------------------------------------Esto es para rellenar el texto de la posición que sera autocompletado-------------------------------------------------------
        // get the defined string-array
        String[] colors = getResources().getStringArray(R.array.posicion);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,colors);
        // set adapter for the auto complete fields
        ET_Posicion.setAdapter(adapter);
        // specify the minimum type of characters before drop-down list is shown
        ET_Posicion.setThreshold(1);

        //------------------------------------------------------------------------------------------------------------------------------------------------------------------

//Cargamos los equipos de la liga en el spinner, más adelante, se cogerá el id del equipo seleccionado cuando se vaya a guardar un equipo en la base de datos.
        String[]equipos = cargarEquipos();
        spinner = (Spinner) findViewById(R.id.spinnerEquipos);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, equipos); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);

    }


    public String[] cargarEquipos() {
        String [] arreglo=null;
        BaseDatosOpenHelper baseHelper = new BaseDatosOpenHelper(this, "BaseDatosDeportiva", null, 1);
        SQLiteDatabase db = baseHelper.getReadableDatabase();
        if (db != null) {
            Cursor c = db.rawQuery("SELECT * FROM Equipos", null);
            int cantidad = c.getCount();//Cantidad de registros
            int i = 0;
            arreglo = new String[cantidad];
            if (c.moveToFirst()) {
                do {
                    String linea = c.getInt(0) + " " + c.getString(1);

                    arreglo[i] = linea;
                    i++;

                } while (c.moveToNext());

            }
        }
        return arreglo;
    }

    public void guardarDatos(View view){

        if(!campoVacio()) {
            String mensaje = "";
            Float peso = null, estatura = null;
            int dorsal = 0, id_equipo = 0;
            //Dentro del try/catch pasaremos los string a int y a float de los campos peso, estatura, dorsal e id_equipo.
            try {
                peso = Float.parseFloat(ET_Peso.getText().toString());
                estatura = Float.parseFloat(ET_Estatura.getText().toString());
                dorsal = Integer.parseInt(ET_Dorsal.getText().toString());
                //Tenemos que coger el id de la posicion seleccionada, es decir coger el primer campo separado por espacio.
                //Cada item del spinner se compone del id del equipo y del nombre del equipo, por tanto cortamos por el espacio y cogemos el primero.
                id_equipo = Integer.parseInt(spinner.getSelectedItem().toString().split(" ")[0]);
            } catch (Exception ex) {
                mensaje = "Datos incorrectos";
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
            }

            //El siquiente try/catch es para pasar el string de la fecha a un formato correcto, si no es así se le avisara al usuario.
            String fechaNacimiento = ET_FechaNacimiento.getText().toString();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
            Date fechaDate = null;
            try {
                fechaDate = formato.parse(fechaNacimiento);
            } catch (ParseException ex) {
                mensaje = "Fecha nacimiento incorrecta";
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                //Si la fecha no esta en el formato correcto saldremos de este método mostrando el mensaje anterior.
                return;
            }

            String nombre = ET_NombreDeportivo.getText().toString();
            String nombreCompleto = ET_Nombre.getText().toString();
            String posicion = ET_Posicion.getText().toString();

            String lugarNacimiento = ET_LugarNacimiento.getText().toString();

            String procedencia = ET_Procedencia.getText().toString();

            if (!jugadorEncontrado(nombreCompleto)) {
                BaseDatosOpenHelper baseHelper = new BaseDatosOpenHelper(this, "BaseDatosDeportiva", null, 1);
                SQLiteDatabase db = baseHelper.getWritableDatabase();
                if (db != null) {
                    ContentValues registroNuevo = new ContentValues();
                    registroNuevo.put("Nombre", nombre);
                    registroNuevo.put("Nombre_completo", nombreCompleto);
                    registroNuevo.put("Posicion", posicion);
                    registroNuevo.put("Fecha_nacimiento", fechaNacimiento);
                    registroNuevo.put("Nacido", lugarNacimiento);
                    registroNuevo.put("Peso", peso);
                    registroNuevo.put("Estatura", estatura);
                    registroNuevo.put("Procedencia", procedencia);
                    registroNuevo.put("Dorsal", dorsal);
                    registroNuevo.put("Id_equipo", id_equipo);//Este dato se coge de la opcion seleccionada en el spinner.
                    long i = db.insert("Jugadores", null, registroNuevo);
                    if (i > 0) {
                        Toast.makeText(this, "Registro Insertado", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Error, comprueba los campos", Toast.LENGTH_SHORT).show();
                    }

                }
            }else{
                Toast.makeText(this, "Jugador ya dado de alta. Introduzca otro", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Compruebe los datos", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean jugadorEncontrado(String nombreCompleto){
        boolean encontrado = false;
        String dato="";
        BaseDatosOpenHelper baseHelper = new BaseDatosOpenHelper(this, "BaseDatosDeportiva", null, 1);
        SQLiteDatabase db = baseHelper.getReadableDatabase();
        if (db != null) {
            Cursor c = db.rawQuery("SELECT Nombre_completo FROM Jugadores WHERE Nombre_completo='"+nombreCompleto+"'", null);
            int cantidad = c.getCount();//Cantidad de registros
            if (c.moveToFirst()) {
                do {
                    dato = c.getString(0);
                } while (c.moveToNext());
            }
        }
        if(dato.equals(nombreCompleto)){
            encontrado = true;
            return encontrado;
        }
        return encontrado;
    }

    public boolean campoVacio(){
        boolean vacio=false;
        if (ET_Nombre.getText().toString().isEmpty() || ET_LugarNacimiento.getText().toString().isEmpty() || ET_NombreDeportivo.getText().toString().isEmpty() || ET_Peso.getText().toString().isEmpty() ||
                ET_Dorsal.getText().toString().isEmpty() || ET_FechaNacimiento.getText().toString().isEmpty() || ET_Estatura.getText().toString().isEmpty() || ET_Posicion.getText().toString().isEmpty()
                 || ET_Procedencia.getText().toString().isEmpty()){
            vacio = true;
            return vacio;
        }
        return vacio;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_alta_jugador, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.listadoJugadores) {
            Intent inten = new Intent(AltaJugador.this,ListaJugadores.class);
            startActivity(inten);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
