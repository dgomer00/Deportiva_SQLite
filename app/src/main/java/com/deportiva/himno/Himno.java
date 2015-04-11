package com.deportiva.himno;

import com.deportiva.ayuda.AcercaDe;

import com.example.deportiva.main.R;



import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Himno extends ActionBarActivity {
	MediaPlayer mp;
	boolean estaParado=false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_himno);
		setTitle("Himno S.D.Ponferradina");
		//Para que no se gire la pantalla al poner el movil en horizontal
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.himno, menu);
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
			 inten = new Intent(Himno.this, AcercaDe.class);
				startActivity(inten);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	//Este metodo es llamado cuando se pulsa el boton back
	public void onBackPressed()
    {
		//terminamos la cancion y lo demas lo dejamos por defecto.LLamamos al metodo destruir que terminara con la cancion si existe y sino, no hara nada.
        destruir();
        super.onBackPressed();
        return;
    } 
	
	public void destruir() {
		if (mp != null)
			mp.release();
	}
	
	public void iniciar(View v) {
	if(estaParado==true){
			destruir();
			mp = MediaPlayer.create(this, R.raw.himno);
			mp.start();
			estaParado=false;
		}
	else if (mp != null && mp.isPlaying() == false) {
			mp.start();
		}else{
			destruir();
			mp = MediaPlayer.create(this, R.raw.himno);
			mp.start();
			estaParado=false;
		}
	}

	public void continuar(View v) {
		if (mp != null && mp.isPlaying() == false) {
			mp.start();
		}
	}
	
	public void pausar(View v) {
		if (mp != null && mp.isPlaying() == false) {
			mp.start();
		}else if(mp != null && mp.isPlaying()){
			mp.pause();
		 }
		
	}

	public void detener(View v) {
		if (mp != null) {
			mp.stop();
			estaParado=true;
		}
	}
}
