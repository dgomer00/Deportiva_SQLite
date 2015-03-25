package com.deportiva.cuerpo;

import com.deportiva.ayuda.AcercaDe;

import com.example.deportiva.main.R;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class Cuerpo extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cuerpo);
		setTitle("Cuerpo Técnico-S.D.P.");
		 
		AdaptadorCuerpo adaptadorCuerpo = new AdaptadorCuerpo(this);
		 ListView listOpciones = (ListView)findViewById(R.id.cuerpo);
		 listOpciones.setAdapter(adaptadorCuerpo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cuerpo, menu);
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
			 inten = new Intent(Cuerpo.this, AcercaDe.class);
				startActivity(inten);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
