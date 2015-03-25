package com.deportiva.marcadores;

import com.deportiva.ayuda.AcercaDe;
import com.example.deportiva.main.R;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Marcador extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_marcador);
		 WebView resultados = (WebView) findViewById(R.id.webViewResultados);

	        resultados.setWebViewClient(new WebViewClient());
	        //resultados.getSettings().setJavaScriptEnabled(true);
		    WebSettings webSettings = resultados.getSettings();
		    webSettings.setBuiltInZoomControls(true);
	        resultados.loadUrl("http://www.movil.resultados-futbol.com/segunda");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.marcador, menu);
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
			 inten = new Intent(Marcador.this, AcercaDe.class);
				startActivity(inten);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
