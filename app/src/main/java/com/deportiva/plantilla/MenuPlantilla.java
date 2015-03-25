package com.deportiva.plantilla;


import com.deportiva.ayuda.AcercaDe;
import com.example.deportiva.main.R;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

	public class MenuPlantilla extends ActionBarActivity {
		
		String[] porteros = {"Pincha para ver los porteros","25-Dinu Moldovan","13-Prieto","1-Kepa Arrizabalaga"};
		String[] defensas = {"Pincha para ver los defensas","2-Javier Carpio","15-Alan Baró","4-Lucas Domínguez","3-Julen Castañeda","24-Camille","20-Óscar Ramírez","22-Alberto Aguilar"};
		String[] centros = {"Pincha para ver los centrocampistas","14-Jonathan Ruiz","16-Acorán","8-Rueda","17-Andy","26-Adán","6-Gaztañaga","19-Tete","23-Gonzalo Melero"};
		String[] delanteros = {"Pincha para ver los delanteros","11-Rubén Sobrino","7-Cristian F.","9-Berrocal","21-Pablo Infante","10-Yuri"};

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_menuplantilla);
			setTitle("Plantilla-S.D.Ponferradina");
			
			//Para que no se gire la pantalla al poner el movil en horizontal
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	
			//Se obtiene el objeto Spinner de los porteros
			Spinner objSpinnerPorteros =(Spinner) findViewById(R.id.spinner1);
			//El adaptador para cargar la lista desde el array
			//y usa un layout de una lista simple
			ArrayAdapter<String> adaptadorPorteros = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,porteros);
			objSpinnerPorteros.setAdapter(adaptadorPorteros);
			
			//Se obtiene el objeto Spinner de los defensas
			Spinner objSpinnerDefensas =(Spinner) findViewById(R.id.spinner2);
			ArrayAdapter<String> adaptadorDefensas = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,defensas);
			objSpinnerDefensas.setAdapter(adaptadorDefensas);
			
			//Se obtiene el objeto Spinner de los centrocampistas
			Spinner objSpinnerCentros =(Spinner) findViewById(R.id.spinner3);
			ArrayAdapter<String> adaptadorCentros = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,centros);
			objSpinnerCentros.setAdapter(adaptadorCentros);
			
			//Se obtiene el objeto Spinner de los delanteros
			Spinner objSpinnerDelanteros =(Spinner) findViewById(R.id.spinner4);
			ArrayAdapter<String> adaptadorDelanteros = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,delanteros);
			objSpinnerDelanteros.setAdapter(adaptadorDelanteros);
			
			//se gestiona el evento onItemSelected para el spinner de porteros
			objSpinnerPorteros.setOnItemSelectedListener(new OnItemSelectedListener(){
				
				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					Intent inten;
					int index = arg0.getSelectedItemPosition();
				
					if(index==1){
						 inten = new Intent(MenuPlantilla.this,Dinu.class);
							startActivity(inten);
					}
					if(index==2){
						 inten = new Intent(MenuPlantilla.this,Prieto.class);
							startActivity(inten);
					}
					if(index==3){
						 inten = new Intent(MenuPlantilla.this,Kepa.class);
							startActivity(inten);
					}
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}
				
			});
			
			//se gestiona el evento onItemSelected para el spinner de defensas
			objSpinnerDefensas.setOnItemSelectedListener(new OnItemSelectedListener(){
				
				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					Intent inten;
					int index = arg0.getSelectedItemPosition();
				
					if(index==1){
						inten = new Intent(MenuPlantilla.this,Carpio.class);
						startActivity(inten);
					}
					if(index==2){
						inten = new Intent(MenuPlantilla.this,Alan.class);
						startActivity(inten);
					}
					if(index==3){
						inten = new Intent(MenuPlantilla.this,Lucas.class);
						startActivity(inten);
					}
					if(index==4){
						inten = new Intent(MenuPlantilla.this,Castaneda.class);
						startActivity(inten);
					}
					if(index==5){
						inten = new Intent(MenuPlantilla.this,Camille.class);
						startActivity(inten);
					}
					if(index==6){
						inten = new Intent(MenuPlantilla.this,Oscar.class);
						startActivity(inten);
					}
					if(index==7){
						inten = new Intent(MenuPlantilla.this,Aguilar.class);
						startActivity(inten);
					}
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}
				
			});
			
			//se gestiona el evento onItemSelected para el spinner de centrocampistas
			objSpinnerCentros.setOnItemSelectedListener(new OnItemSelectedListener(){
				
				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					Intent inten;
					int index = arg0.getSelectedItemPosition();
				
					if(index==1){
						inten = new Intent(MenuPlantilla.this,Jonathan.class);
						startActivity(inten);
					}
					if(index==2){
						inten = new Intent(MenuPlantilla.this,Acoran.class);
						startActivity(inten);
					}
					if(index==3){
						inten = new Intent(MenuPlantilla.this,Rueda.class);
						startActivity(inten);
					}
					if(index==4){
						inten = new Intent(MenuPlantilla.this,Andy.class);
						startActivity(inten);
					}
					if(index==5){
						inten = new Intent(MenuPlantilla.this,Adan.class);
						startActivity(inten);
					}
					if(index==6){
						inten = new Intent(MenuPlantilla.this,Gaztanaga.class);
						startActivity(inten);
					}
					if(index==7){
						inten = new Intent(MenuPlantilla.this,Tete.class);
						startActivity(inten);
					}
					if(index==8){
						inten = new Intent(MenuPlantilla.this,Melero.class);
						startActivity(inten);
					}
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}
				
			});
			
			//se gestiona el evento onItemSelected para el spinner de delanteros
			objSpinnerDelanteros.setOnItemSelectedListener(new OnItemSelectedListener(){
				
				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					Intent inten;
					int index = arg0.getSelectedItemPosition();
				
					if(index==1){
						inten = new Intent(MenuPlantilla.this,Sobrino.class);
						startActivity(inten);
					}
					if(index==2){
						inten = new Intent(MenuPlantilla.this,Cristian.class);
						startActivity(inten);
					}
					if(index==3){
						inten = new Intent(MenuPlantilla.this,Berrocal.class);
						startActivity(inten);
					}
					if(index==4){
						inten = new Intent(MenuPlantilla.this,Infante.class);
						startActivity(inten);
					}
					if(index==5){
						inten = new Intent(MenuPlantilla.this,Yuri.class);
						startActivity(inten);
					}
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}
				
			});
			
		}

		//@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.menu_plantilla, menu);
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
				 inten = new Intent(MenuPlantilla.this, AcercaDe.class);
					startActivity(inten);
				return true;
			}
			return super.onOptionsItemSelected(item);
		}
	}


