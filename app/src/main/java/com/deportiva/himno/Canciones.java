package com.deportiva.himno;

import com.deportiva.ayuda.AcercaDe;
import com.example.deportiva.main.R;


import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Canciones extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_canciones);
		setTitle("Canciones - S.D.Ponferradina");
		
		//Para que no se gire la pantalla al poner el movil en horizontal
		//setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		Button himno=(Button) findViewById(R.id.himno);
		Button virgenEncina = (Button) findViewById(R.id.virgen);
		himno.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent inten;
				inten = new Intent(Canciones.this,Himno.class);
				startActivity(inten);
				
			}
		});
		
		virgenEncina.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent inten;
				inten = new Intent(Canciones.this,VirgenEncina.class);
				startActivity(inten);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.canciones, menu);
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
			 inten = new Intent(Canciones.this, AcercaDe.class);
				startActivity(inten);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
