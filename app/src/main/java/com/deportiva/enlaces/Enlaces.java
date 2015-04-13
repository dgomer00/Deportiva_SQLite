package com.deportiva.enlaces;

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
import android.widget.ImageButton;

public class Enlaces extends ActionBarActivity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enlaces);
		setTitle("Enlaces de Interés");
		//Para que no se gire la pantalla al poner el movil en horizontal
		//setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ImageButton bt_facebook;
        ImageButton bt_deportiva;
        ImageButton bt_instagram;
        ImageButton bt_twitter;
        ImageButton bt_ponfeTv;
		//Capturar el evento para ir a la pagina de facebook
		bt_facebook = (ImageButton) findViewById(R.id.bt_facebook);
		bt_facebook.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
            	Intent browserIntent = 
	            		new Intent(Intent.ACTION_VIEW, 
	            				Uri.parse("https://www.facebook.com/pages/SD-Ponferradina/200486356640899"));
	            	startActivity(browserIntent);
				
			}
		});
		
		//Captura del evento para la pagina oficial de la ponferradina
		bt_deportiva = (ImageButton) findViewById(R.id.bt_pagina_oficial);
		bt_deportiva.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
            	Intent browserIntent = 
	            		new Intent(Intent.ACTION_VIEW, 
	            				Uri.parse("http://www.sdponferradina.com/"));
	            	startActivity(browserIntent);
				
			}
		});
		
		//Captura del evento para el instagram oficial de la deportiva
		bt_instagram = (ImageButton) findViewById(R.id.bt_instagram);
		bt_instagram.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
            	Intent browserIntent = 
	            		new Intent(Intent.ACTION_VIEW, 
	            				Uri.parse("http://instagram.com/sdp_1922_sad"));
	            	startActivity(browserIntent);
				
			}
		});
		
		//Captura del evento para el twitter oficial de la deportiva
		bt_twitter = (ImageButton) findViewById(R.id.bt_twitter);
		bt_twitter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
            	Intent browserIntent = 
	            		new Intent(Intent.ACTION_VIEW, 
	            				Uri.parse("https://twitter.com/SDP_1922"));
	            	startActivity(browserIntent);
				
			}
		});		

		//Captura del evento para la p�gina de Ponferradina Tv
		bt_ponfeTv = (ImageButton) findViewById(R.id.bt_ponfetv);
		bt_ponfeTv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
            	Intent browserIntent = 
	            		new Intent(Intent.ACTION_VIEW, 
	            				Uri.parse("http://www.sdponferradina.tv/home.aspx"));
	            	startActivity(browserIntent);
				
			}
		});		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.enlaces, menu);
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
			 inten = new Intent(Enlaces.this, AcercaDe.class);
				startActivity(inten);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
