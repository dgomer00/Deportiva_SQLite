package com.deportiva.plantilla;

import com.deportiva.ayuda.AcercaDe;
import com.deportiva.database.BaseDatosOpenHelper;
import com.example.deportiva.main.R;



import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Sobrino extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sobrino);
		setTitle("R.Sobrino");
		//Para que no se gire la pantalla al poner el movil en horizontal
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Cargamos los datos
        String nombre_jugador = "R.Sobrino";
        int dorsal_jugador = 11;
        int id_equipo = 15;//ID_equipo de la S.D.Ponferradina.
        //Este array de String lo usaremos para almacenar los datos leidos de la base de datos
        String[] jugador;
        BaseDatosOpenHelper baseHelper = new BaseDatosOpenHelper(this, "BaseDatosDeportiva", null, 1);
        jugador=BaseDatosOpenHelper.cargar(baseHelper, nombre_jugador, dorsal_jugador, id_equipo);

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

        //Identificamos el resto de elementos de la ventana para ocultarlos en casa de que no se encuentre el jugador.
        ImageView imagen_jugador = (ImageView)findViewById(R.id.imageView1);
        TextView texto1 = (TextView)findViewById(R.id.textView1);
        TextView texto2 = (TextView)findViewById(R.id.textView3);
        TextView texto3 = (TextView)findViewById(R.id.textView5);
        TextView texto4 = (TextView)findViewById(R.id.textView7);
        TextView texto5 = (TextView)findViewById(R.id.textView9);
        TextView texto6 = (TextView)findViewById(R.id.textView11);
        TextView texto7 = (TextView)findViewById(R.id.textView13);
        TextView texto8 = (TextView)findViewById(R.id.textView15);
        TextView texto9 = (TextView)findViewById(R.id.textView17);

        if(jugador[0].equals("Jugador Inexistente") || jugador[0].equals("Error")){//Sino se encuentra el jugador se ocultaran todos los elementos y solo se mostrara un mensaje

            if(jugador[0].equals("Jugador Inexistente")) {//El mensaje que se muestra sino se encontro ningun jugador.
                nombre.setText(jugador[0]);
            }else{//El mensaje que se mostrara si hay varios jugadores con las mismas caracteristicas.
                nombre.setText("Varios jugadores con las mismas caracteristicas");
            }
            //En cualquiera de los 2 casos ocultaremos es resto de elementos de la ventana
            posicion.setVisibility(View.INVISIBLE);
            fecha_nacimiento.setVisibility(View.INVISIBLE);
            nacido.setVisibility(View.INVISIBLE);
            peso.setVisibility(View.INVISIBLE);
            estatura.setVisibility(View.INVISIBLE);
            procedencia.setVisibility(View.INVISIBLE);
            dorsal.setVisibility(View.INVISIBLE);
            imagen_jugador.setVisibility(View.INVISIBLE);
            texto1.setVisibility(View.INVISIBLE);
            texto2.setVisibility(View.INVISIBLE);
            texto3.setVisibility(View.INVISIBLE);
            texto4.setVisibility(View.INVISIBLE);
            texto5.setVisibility(View.INVISIBLE);
            texto6.setVisibility(View.INVISIBLE);
            texto7.setVisibility(View.INVISIBLE);
            texto8.setVisibility(View.INVISIBLE);
            texto9.setVisibility(View.INVISIBLE);

        }else {
            nombre.setText(jugador[0]);
            nombre_completo.setText(jugador[1]);
            posicion.setText(jugador[2]);
            fecha_nacimiento.setText(jugador[3]);
            nacido.setText(jugador[4]);
            peso.setText(jugador[5]);
            estatura.setText(jugador[6]);
            procedencia.setText(jugador[7]);
            dorsal.setText(jugador[8]);
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sobrino, menu);
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
			 inten = new Intent(Sobrino.this, AcercaDe.class);
				startActivity(inten);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
