package com.deportiva.directiva;

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

public class Directiva extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_directiva);
		setTitle("Directiva-S.D.Ponferradina");
		
		//Capturar el evento para ir a la pagina del organigrama y descargarlo
				Button organigrama = (Button) findViewById(R.id.boton_organigrama);
				organigrama.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
		            	Intent browserIntent = 
			            		new Intent(Intent.ACTION_VIEW, 
			            				Uri.parse("http://www.sdponferradina.com/documents/30276/33579941/organigramaSDP.pdf/747846d0-460e-4303-a1fd-4aad5f387dd1?version=1.0"));
			            	startActivity(browserIntent);
						
					}
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.directiva, menu);
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
			 inten = new Intent(Directiva.this, AcercaDe.class);
				startActivity(inten);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
