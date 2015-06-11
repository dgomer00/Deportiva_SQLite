package com.deportiva.database;

import android.content.ContentValues;
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
import android.widget.Spinner;
import android.widget.Toast;

import com.example.deportiva.main.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ModificarJugador extends ActionBarActivity {

    EditText ET_Nombre, ET_NombreDeportivo, ET_FechaNacimiento, ET_LugarNacimiento, ET_Peso, ET_Estatura, ET_Procedencia, ET_Dorsal ;
    int Id=0,Id_equipo;
    Spinner spinner;
    private AutoCompleteTextView ET_Posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_jugador);
        ET_NombreDeportivo = (EditText)findViewById(R.id.editTextNombreJugador);
        ET_Nombre  = (EditText)findViewById(R.id.editTextNombreCompletoJugador);
        ET_Posicion = (AutoCompleteTextView)findViewById(R.id.autoCompletePosicionJugador);
        ET_FechaNacimiento = (EditText)findViewById(R.id.editTextFechaJugador);
        ET_LugarNacimiento = (EditText)findViewById(R.id.editTextLugarNacimientoJugador);
        ET_Peso = (EditText)findViewById(R.id.editTextPesoJugador);
        ET_Estatura = (EditText)findViewById(R.id.editTextEstaturaJugador);
        ET_Procedencia = (EditText)findViewById(R.id.editTextProcedenciaJugador);
        ET_Dorsal = (EditText)findViewById(R.id.editTextDorsalJugador);

        //Obtener el Id
        Bundle b=this.getIntent().getExtras();
        if(b!=null){
            recuperaInformacion(b.getInt("IdModifica"));
        }

        //Cargamos los datos para el editText auto completado--------------------------------------------------------------------------------------
        // get the defined string-array
        String[] colors = getResources().getStringArray(R.array.posicion);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,colors);
        // set adapter for the auto complete fields
        ET_Posicion.setAdapter(adapter);
        // specify the minimum type of characters before drop-down list is shown
        ET_Posicion.setThreshold(1);
        //------------------------------------------------------------------------------------------------------------------------------------------

        //Cargamos los equipos de la liga en el spinner, más adelante, se cogerá el id del equipo seleccionado cuando se vaya a guardar un equipo en la base de datos.
        String[]equipos = cargarEquipos();
        spinner = (Spinner) findViewById(R.id.spinnerEquipos);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, equipos); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);

        //Para dejar seleccionado el equipo actual del jugador, tendremos que buscar que posicion equivale al equipo al que pertenece
        //para ello, tenemos que consultar a traves del id_equipo el nombre del equipo y posteriormente encontrarlo en el spinner y dejarlo
        //seleccionado
        String equipoEncontrado=buscarEquipo();

        //seleccionamos la posicion que nos devuelve el metodo, con el equipo que estabamos buscando.
        spinner.setSelection(getIndex(spinner, equipoEncontrado));

    }

    //Con este método devolvemos la posicion donde se encuentra el equipo selelcionado, para despues mostrarlo en el spinner.
    private int getIndex(Spinner spinner, String equipo){

        int index = 0;

        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).equals(equipo)){
                index = i;
            }
        }
        return index;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_modificar_jugador, menu);
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
            c.close();
        }

        return arreglo;
    }

    public String buscarEquipo() {
        String linea=null;
        BaseDatosOpenHelper baseHelper = new BaseDatosOpenHelper(this, "BaseDatosDeportiva", null, 1);
        SQLiteDatabase db = baseHelper.getReadableDatabase();
        if (db != null) {
            Cursor c = db.rawQuery("SELECT * FROM Equipos where Id="+Id_equipo, null);
            if (c.moveToFirst()) {
                do {
                    linea = c.getInt(0) + " " + c.getString(1);
                } while (c.moveToNext());
            }
            c.close();
        }
        return linea;
    }

    public void modificarDatos(View view){
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
            if(!posicionValida(posicion)){
                Toast.makeText(this, "Posicion incorrecta", Toast.LENGTH_SHORT).show();
                //Si la posición no es una posición correcta se mostrara el siguiente mensaje y no se guardara el jugador, hasta que sea correcta.
                return;
            }
            String lugarNacimiento = ET_LugarNacimiento.getText().toString();
            String procedencia = ET_Procedencia.getText().toString();

            BaseDatosOpenHelper baseHelper = new BaseDatosOpenHelper(this, "BaseDatosDeportiva", null, 1);
            SQLiteDatabase db = baseHelper.getWritableDatabase();
            if (db != null) {
                ContentValues modificaRegistro = new ContentValues();
                modificaRegistro.put("Nombre", nombre);
                modificaRegistro.put("Nombre_completo", nombreCompleto);
                modificaRegistro.put("Posicion", posicion);
                modificaRegistro.put("Fecha_nacimiento", fechaNacimiento);
                modificaRegistro.put("Nacido", lugarNacimiento);
                modificaRegistro.put("Peso", peso);
                modificaRegistro.put("Estatura", estatura);
                modificaRegistro.put("Procedencia", procedencia);
                modificaRegistro.put("Dorsal", dorsal);
                modificaRegistro.put("Id_equipo", id_equipo);
                long i = db.update("Jugadores", modificaRegistro, "Id=" + Id, null);
                if (i > 0) {
                    Toast.makeText(this, "Registro Modificado", Toast.LENGTH_SHORT).show();
                    super.onBackPressed();
                }
            }
        }else{
            Toast.makeText(this, "Compruebe los datos", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean posicionValida(String posicion){
        boolean valida = false;
        if (posicion.equals("Portero")|| posicion.equals("Defensa") || posicion.equals("Centrocampista") || posicion.equals("Delantero")){
            valida = true;
        }
        return valida;
    }

    public boolean campoVacio(){
        boolean vacio=false;
        if (ET_Nombre.getText().toString().isEmpty() || ET_LugarNacimiento.getText().toString().isEmpty() || ET_NombreDeportivo.getText().toString().isEmpty() || ET_Peso.getText().toString().isEmpty() ||
                ET_Dorsal.getText().toString().isEmpty() || ET_FechaNacimiento.getText().toString().isEmpty() || ET_Estatura.getText().toString().isEmpty() || ET_Posicion.getText().toString().isEmpty()
                || ET_Procedencia.getText().toString().isEmpty()){
            vacio = true;
        }
        return vacio;
    }

    public void recuperaInformacion(int id){
        BaseDatosOpenHelper baseHelper = new BaseDatosOpenHelper(this,"BaseDatosDeportiva",null,1);
        SQLiteDatabase db = baseHelper.getReadableDatabase();
        if(db!=null) {
            Cursor c = db.rawQuery("SELECT * FROM Jugadores where Id="+id, null);
            try {
                if(c.moveToFirst()){
                    Id = c.getInt(0);
                    ET_NombreDeportivo.setText(c.getString(1));
                    ET_Nombre.setText(c.getString(2));
                    ET_Posicion.setText(c.getString(3));
                    ET_FechaNacimiento.setText(c.getString(4));
                    ET_LugarNacimiento.setText(c.getString(5));
                    ET_Peso.setText(String.valueOf(c.getFloat(6)));
                    ET_Estatura.setText(String.valueOf(c.getFloat(7)));
                    ET_Procedencia.setText(c.getString(8));
                    ET_Dorsal.setText(String.valueOf(c.getInt(9)));
                    Id_equipo =c.getInt(10);

                }
            }finally{
                c.close();
            }
        }
    }
}