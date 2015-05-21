package com.deportiva.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.deportiva.main.R;

public class ModificarEquipo extends ActionBarActivity {
    EditText ET_Nombre;
    int Id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_equipo);
        ET_Nombre = (EditText)findViewById(R.id.editTextModificarEquipo);
        //Obtener el Id
        Bundle b=this.getIntent().getExtras();
        if(b!=null){
            recuperaInformacion(b.getInt("IdModifica"));
        }

    }

    public void modificarDatos(View view){
        String Nombre = ET_Nombre.getText().toString();


        BaseDatosOpenHelper baseHelper = new BaseDatosOpenHelper(this,"BaseDatosDeportiva",null,1);
        SQLiteDatabase db = baseHelper.getWritableDatabase();
        if(db!=null){
            ContentValues modificaRegistro = new ContentValues();
            modificaRegistro.put("Nombre",Nombre);
            long i = db.update("Equipos",modificaRegistro,"Id="+Id,null);
            if(i>0){
                Toast.makeText(this, "Registro Modificado", Toast.LENGTH_SHORT).show();
                super.onBackPressed();
            }

        }
    }

    public void recuperaInformacion(int id){
        BaseDatosOpenHelper baseHelper = new BaseDatosOpenHelper(this,"BaseDatosDeportiva",null,1);
        SQLiteDatabase db = baseHelper.getReadableDatabase();
        if(db!=null) {
            Cursor c = db.rawQuery("SELECT Id,Nombre FROM Equipos where Id="+id, null);
            try {
                if(c.moveToFirst()){
                    Id = c.getInt(0);
                    ET_Nombre.setText(c.getString(1));
                }
            }finally{
                c.close();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_modificar_equipo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}