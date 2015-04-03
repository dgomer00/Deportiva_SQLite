package com.deportiva.main;

import com.example.deportiva.main.R;


import com.deportiva.ayuda.AcercaDe;
import com.deportiva.calendario.IntroCalendario;
import com.deportiva.clasificacion.Clasificacion;
import com.deportiva.cuentas.Cuentas;
import com.deportiva.cuerpo.Cuerpo;

import com.deportiva.directiva.Directiva;
import com.deportiva.enlaces.Enlaces;
import com.deportiva.entradas.Entradas;
import com.deportiva.estadio.Estadio;
import com.deportiva.galeria.Galeria;
import com.deportiva.himno.Canciones;
import com.deportiva.historia.Historia;
import com.deportiva.marcadores.Marcador;
import com.deportiva.plantilla.MenuPlantilla;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
//import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MenuDeportiva extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menudeportiva);
		setTitle("Menu-S.D.Ponferradina");
		
		
		 Adaptador adaptador = new Adaptador(this);
		 ListView listOpciones = (ListView)findViewById(R.id.lista);
		 
		 listOpciones.setAdapter(adaptador);
		 
		 listOpciones.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> a, View v, int position,
					long id) {
				
				Intent inten;
				switch(position){
				
				case 0:
					inten = new Intent(MenuDeportiva.this,Marcador.class);
					startActivity(inten);
					break;
				case 1:
					inten = new Intent(MenuDeportiva.this,Clasificacion.class);
					startActivity(inten);
					break;
				case 2:
					inten = new Intent(MenuDeportiva.this,MenuPlantilla.class);
					startActivity(inten);
					break;	
				case 3:
					 inten = new Intent(MenuDeportiva.this, Cuerpo.class);
					startActivity(inten);
					break;
				case 4:
					inten = new Intent(MenuDeportiva.this,Directiva.class);
					startActivity(inten);
					break;
				case 5:
					inten = new Intent(MenuDeportiva.this,Galeria.class);
					startActivity(inten);
					break;
				case 6:
					inten = new Intent(MenuDeportiva.this,IntroCalendario.class);
					startActivity(inten);
					break;
				case 7:
					inten = new Intent(MenuDeportiva.this,Entradas.class);
					startActivity(inten);
					break;
				case 8:
					inten = new Intent(MenuDeportiva.this,Cuentas.class);
					startActivity(inten);
					break;
				case 9:
					inten = new Intent(MenuDeportiva.this,Enlaces.class);
					startActivity(inten);
					break;
				case 10:
					inten = new Intent(MenuDeportiva.this,Canciones.class);
					startActivity(inten);
					break;
				case 11:
					inten = new Intent(MenuDeportiva.this,Historia.class);
					startActivity(inten);
					break;
				case 12:
					inten = new Intent(MenuDeportiva.this,Estadio.class);
					startActivity(inten);
					break;
                case 13:
                   // inten = new Intent(MenuDeportiva.this,SignIn.class);
                   // startActivity(inten);
                    break;
				case 14:
					finish();
					break;
				default:
						
					break;
				
				}
				
			}
 
		});
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.acerca_de, menu);
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
			 inten = new Intent(MenuDeportiva.this, AcercaDe.class);
				startActivity(inten);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
