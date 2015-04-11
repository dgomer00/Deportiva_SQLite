package com.deportiva.calendario;

import com.deportiva.ayuda.AcercaDe;

import com.example.deportiva.main.R;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IntroCalendario extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intro_calendario);
		
		//Capturar el evento para ir a la pagina de la LFP
				Button bt_lfp = (Button) findViewById(R.id.boton_lfp);
				bt_lfp.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
		            	Intent browserIntent = 
			            		new Intent(Intent.ACTION_VIEW, 
			            				Uri.parse("http://www.lfp.es/calendario-horario"));
			            	startActivity(browserIntent);
						
					}
				});
				
				//Captura del evento para la pagina del diario marca correspondiente a la liga adelante
				Button bt_marca = (Button) findViewById(R.id.boton_marca);
				bt_marca.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
		            	Intent browserIntent = 
			            		new Intent(Intent.ACTION_VIEW, 
			            				Uri.parse("http://www.marca.com/movil/tabla_marcadores.html?c=futbol_2adivision"));
			            	startActivity(browserIntent);
						
					}
				});
				
				//Captura del evento para la pagina del diario mundo deportivo correspondiente a la liga adelante
				Button bt_mundo_deportivo = (Button) findViewById(R.id.boton_mundo_deportivo);
				bt_mundo_deportivo.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
		            	Intent browserIntent = 
			            		new Intent(Intent.ACTION_VIEW, 
			            				Uri.parse("http://www.mundodeportivo.com/futbol/liga-segunda-division/calendario.html"));
			            	startActivity(browserIntent);
						
					}
				});
				
				//Captura del evento para la pagina del diario el pais correspondiente a la liga adelante
				Button bt_el_pais = (Button) findViewById(R.id.boton_el_pais);
				bt_el_pais.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
		            	Intent browserIntent = 
			            		new Intent(Intent.ACTION_VIEW, 
			            				Uri.parse("http://www.elpais.com/especial/calendario-liga-futbol/segunda/"));
			            	startActivity(browserIntent);
						
					}
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.intro_calendario, menu);
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
			 inten = new Intent(IntroCalendario.this, AcercaDe.class);
				startActivity(inten);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
