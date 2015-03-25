package com.deportiva.historia;


import com.deportiva.ayuda.AcercaDe;
import com.example.deportiva.main.R;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TabHost;

public class Historia extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_historia);
		
		Resources res = getResources();
		TabHost tabs = (TabHost)findViewById(android.R.id.tabhost);
		tabs.setup();
		TabHost.TabSpec spec = tabs.newTabSpec("Pestaña 1");
		spec.setContent(R.id.ScrollViewPestana1);
		spec.setIndicator("Fundación\na 1960");
		tabs.addTab(spec);

		tabs.setup();
		TabHost.TabSpec spec1 = tabs.newTabSpec("Pestaña 2");
		spec1.setContent(R.id.ScrollViewPestana2);
		spec1.setIndicator("Años 1970\na 2000");
		tabs.addTab(spec1);
		
		tabs.setup();
		TabHost.TabSpec spec2 = tabs.newTabSpec("Pestaña 3");
		spec2.setContent(R.id.ScrollViewPestana3);
		spec2.setIndicator("Últimos\naños ");
		tabs.addTab(spec2);
		
		tabs.setup();
		TabHost.TabSpec spec3 = tabs.newTabSpec("Pestaña 4");
		spec3.setContent(R.id.ScrollViewPestana4);
		spec3.setIndicator("Presidentes");
		tabs.addTab(spec3);
		
		tabs.setup();
		TabHost.TabSpec spec4 = tabs.newTabSpec("Pestaña 5");
		spec4.setContent(R.id.ScrollViewPestana5);
		spec4.setIndicator("Hitos\nDeportivos");
		tabs.addTab(spec4);
		
		ImageButton temporadas=(ImageButton) findViewById(R.id.imageButton2);
		temporadas.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent inten;
				inten = new Intent(Historia.this,Temporadas.class);
				startActivity(inten);
				
			}
		});
		
		//Capturar el evento para ir a la pagina del pdf de la Historia
		Button bt_historia = (Button) findViewById(R.id.boton_historia);
		bt_historia.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
            	Intent browserIntent = 
	            		new Intent(Intent.ACTION_VIEW, 
	            				Uri.parse("https://www.dropbox.com/s/yb4ta7lmspl69km/Historia%20Ponferradina.pdf?dl=0"));
	            	startActivity(browserIntent);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.historia, menu);
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
			 inten = new Intent(Historia.this, AcercaDe.class);
				startActivity(inten);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
