package com.deportiva.plantilla;

import com.deportiva.ayuda.AcercaDe;
import com.deportiva.database.BaseDatosOpenHelper;
import com.example.deportiva.main.R;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Kepa extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kepa);
		//Para que no se gire la pantalla al poner el movil en horizontal
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        //Cargamos los datos
        cargar();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.kepa, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.acercaDe) {
			Intent inten;
			 inten = new Intent(Kepa.this, AcercaDe.class);
				startActivity(inten);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

    public void cargar() {

        //Identificar los textView para despues rellenarlos con los que leamos de la base de datos
        TextView nombre = (TextView)findViewById(R.id.textView2);
        TextView nombre_completo = (TextView)findViewById(R.id.textView4);
        TextView posicion = (TextView)findViewById(R.id.textView6);
        TextView fecha_nacimiento = (TextView)findViewById(R.id.textView8);
        TextView nacido = (TextView)findViewById(R.id.textView10);
        TextView peso = (TextView)findViewById(R.id.textView12);
        TextView estatura = (TextView)findViewById(R.id.textView14);
        TextView procedencia = (TextView)findViewById(R.id.textView16);
        TextView dorsal = (TextView)findViewById(R.id.textView18);

        BaseDatosOpenHelper baseHelper = new BaseDatosOpenHelper(this, "BaseDatosDeportiva", null, 1);
        SQLiteDatabase db = baseHelper.getReadableDatabase();
        if (db != null) {
            Cursor c = db.rawQuery("SELECT * FROM Jugadores WHERE Nombre='Arrizabalaga' AND Dorsal=1", null);
            int cantidad = c.getCount();//Cantidad de registros
            int i = 0;
            // arreglo = new String[cantidad];
            if (c.moveToFirst()) {
                do {
                    nombre.setText(c.getString(1));
                    nombre_completo.setText(c.getString(2));
                    posicion.setText(c.getString(3));
                    fecha_nacimiento.setText(c.getString(4));
                    nacido.setText(c.getString(5));
                    peso.setText(c.getString(6));
                    estatura.setText(c.getString(7));
                    procedencia.setText(c.getString(8));
                    dorsal.setText(c.getString(9));
                    //String linea = c.getInt(0) + " " + c.getString(1) + " " + c.getString(2) + " " + c.getInt(3);

                    //arreglo[i]=linea;
                    //i++;

                } while (c.moveToNext());
            }

            // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arreglo);
            // ListView lista = (ListView)findViewById(R.id.Lista);
            // lista.setAdapter(adapter);
        }
    }
}
