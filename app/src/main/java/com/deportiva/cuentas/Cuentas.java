package com.deportiva.cuentas;


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

public class Cuentas extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cuentas);
		
		//Para que no se gire la pantalla al poner el movil en horizontal
		//setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		Button ingresos=(Button) findViewById(R.id.ingresos);
		Button gastos = (Button) findViewById(R.id.gastos);
		Button cuentas = (Button) findViewById(R.id.cuentas);
		ingresos.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent inten;
				inten = new Intent(Cuentas.this,Ingresos.class);
				startActivity(inten);
				
			}
		});
		
		gastos.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent inten;
				inten = new Intent(Cuentas.this,Gastos.class);
				startActivity(inten);
			}
		});
		cuentas.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent browserIntent = 
	            		new Intent(Intent.ACTION_VIEW, 
	            				Uri.parse("http://www.sdponferradina.com/documents/30276/33579941/Cuentas_SDP_1314.pdf/a17d9874-c1aa-47a4-a76d-55b92e30686b?version=1.0"));
	            	startActivity(browserIntent);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cuentas, menu);
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
			 inten = new Intent(Cuentas.this, AcercaDe.class);
				startActivity(inten);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
