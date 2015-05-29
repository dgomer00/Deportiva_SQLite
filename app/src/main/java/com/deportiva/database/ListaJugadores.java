package com.deportiva.database;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.deportiva.main.R;

public class ListaJugadores extends ActionBarActivity {

    String[] arreglo;
    ListView listaJugadores;
    protected Object mActionMode;
    public int selectedItem = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_jugadores);
        cargar();//Las cosas se van a listar en esta ventana que sera llamada desde un item del menu principal
        listaJugadores = (ListView)findViewById(R.id.ListaJugadores);
        listaJugadores.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listaJugadores.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                if(mActionMode != null){
                    return false;
                }

                selectedItem = position;

                mActionMode = ListaJugadores.this.startActionMode(amc);//amc es el callback nombrado al final
                view.setSelected(true);
                return true;
            }
        });

        listaJugadores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // selectedItem = position;
                int idModificar = Integer.parseInt(arreglo[position].split(" ")[0]);
                Intent intent = new Intent(ListaJugadores.this, ModificarJugador.class);
                intent.putExtra("IdModifica", idModificar);
                startActivity(intent);
            }
        });
    }
//------------------------mirar este bien------------------------------------------
    //--En el método cargar de la clase BaseDatosOpenHelper se leen todos los registros como string
    public void cargar(){
        BaseDatosOpenHelper baseHelper = new BaseDatosOpenHelper(this,"BaseDatosDeportiva",null,1);
        SQLiteDatabase db = baseHelper.getReadableDatabase();
        if(db!=null){
            Cursor c = db.rawQuery("SELECT * FROM Jugadores", null);
            int cantidad = c.getCount();//Cantidad de registros
            int i=0;
            arreglo = new String[cantidad];
            if (c.moveToFirst()){
                do{
                    String linea =c.getInt(0)+" Nombre deportivo: "+ c.getString(1)+"\nNombre  completo: "+ c.getString(2)+"\nPosición: "+ c.getString(3)+"\nFecha nacimiento: "+ c.getString(4)
                            +"\nNació en: "+ c.getString(5)+ "\nPeso :"+ c.getFloat(6)+ " Estatura: "+ c.getFloat(7)+"\nProcedencia: "+ c.getString(8)+"\nDorsal: "+ c.getInt(9);

                    arreglo[i]=linea;
                    i++;

                }while(c.moveToNext());
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arreglo);
            ListView lista = (ListView)findViewById(R.id.ListaJugadores);
            lista.setAdapter(adapter);
        }
    }


    private ActionMode.Callback amc = new ActionMode.Callback() {

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.menu_lista_jugadores,menu);//Con esto inflamos el menu y le ponemos la linea que queremos con el icono que queremos
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch(item.getItemId()){
                case R.id.menu_borrado_jugador:
                    borrar();
                    mode.finish();
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
            selectedItem = -1;
        }
    };

    private void borrar(){
        BaseDatosOpenHelper baseHelper = new BaseDatosOpenHelper(this,"BaseDatosDeportiva",null,1);
        SQLiteDatabase db = baseHelper.getReadableDatabase();
        int id = Integer.parseInt(arreglo[selectedItem].split(" ")[0]);
        if(db!=null){
            long res = db.delete("Jugadores", "Id="+id,null);
            if(res>0){
                Toast.makeText(this, "Registro Eliminado", Toast.LENGTH_SHORT).show();
                cargar();
            }
        }
    }
}
