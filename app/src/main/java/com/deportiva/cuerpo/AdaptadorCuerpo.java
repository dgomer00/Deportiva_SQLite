package com.deportiva.cuerpo;

import com.example.deportiva.main.R;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdaptadorCuerpo extends ArrayAdapter<Object> {
	private static String  labelNombreDeportivo = "Nombre Deportivo:";
	private static String labelPuesto = "Puesto:";
	
	private static ArrayDatosCuerpo[] datos = new ArrayDatosCuerpo[]{
		new ArrayDatosCuerpo("José Manuel Díaz Fernández", labelNombreDeportivo, "Manolo Díaz", labelPuesto, "Entrenador", R.drawable.manolo_diaz),
		new ArrayDatosCuerpo("Carlos Lasheras", labelNombreDeportivo,  "Carlos Lasheras", labelPuesto, "Director Deportivo", R.drawable.lasheras),
		new ArrayDatosCuerpo("Rubén Vega Fuertes", labelNombreDeportivo, "Rubén Vega", labelPuesto, "2ºEntrenador", R.drawable.ruben_vega),
		new ArrayDatosCuerpo("Tomás Nistal García", labelNombreDeportivo, "Tomás Nistal", labelPuesto, "Secretario Técnico", R.drawable.tomas_nistal),
		new ArrayDatosCuerpo("José Antonio Blanco", labelNombreDeportivo, "José Antonio", labelPuesto, "Delegado", R.drawable.delegado),
		new ArrayDatosCuerpo("Alberto Ramón Casal Arante", labelNombreDeportivo, "Alberto Casal", labelPuesto, "Entrenador de porteros", R.drawable.alberto_ramon),
		new ArrayDatosCuerpo("Carlos Fernández Salmiento", labelNombreDeportivo, "Carlos", labelPuesto, "Fisioterapeuta", R.drawable.carlos_salmiento),
		new ArrayDatosCuerpo("Carlos Álvarez Leite", labelNombreDeportivo, "Carlos", labelPuesto, "Fisioterapeuta", R.drawable.carlos_alvarez),
		new ArrayDatosCuerpo("Jose Manuel Santos Rodriguez", labelNombreDeportivo, "Manolo", labelPuesto, "Preparador físico", R.drawable.manolo),
		new ArrayDatosCuerpo("José Franganillo Espeso", labelNombreDeportivo, "Franganillo", labelPuesto, "Utillero", R.drawable.franganillo),
		new ArrayDatosCuerpo("Ricardo Velez Silva", labelNombreDeportivo, "Ricardo", labelPuesto, "Jefe Servicios Médicos", R.drawable.ricardo),
		new ArrayDatosCuerpo("Antonio Domingo Bodelón", labelNombreDeportivo, "Antonio", labelPuesto, "Médico", R.drawable.antonio_domingo_bodelon),
		new ArrayDatosCuerpo("César Fernández Álvarez", labelNombreDeportivo, "César", labelPuesto, "Readaptador Físico-Deportivo", R.drawable.cesar),
		new ArrayDatosCuerpo("Raúl Herrero Franganillo", labelNombreDeportivo, "Raúl", labelPuesto, "2ºUtillero", R.drawable.raul_herrero)
	};
	
	
	Activity context;
	AdaptadorCuerpo(Activity context){
		super(context,R.layout.activity_cuerpo,datos);
		this.context = context;
	}

	public View getView(int position, View contView, ViewGroup parent){
		LayoutInflater inflater = context.getLayoutInflater();
		View item = inflater.inflate(R.layout.cuerpo,null);//cogemos el xml de el formato de la ventana del cuerpo t?cnico
		
		ImageView icono = (ImageView) item.findViewById(R.id.icono);
		icono.setImageResource(datos[position].getImage());
		
		TextView nombre = (TextView) item.findViewById(R.id.nombre);
		nombre.setText(datos[position].getNombre());
		
		TextView labelNombreDepor = (TextView) item.findViewById(R.id.label_nombre_deportivo);
		labelNombreDepor.setText(datos[position].getLabel_nombre_deportivo());
		
		TextView nombreDepor = (TextView) item.findViewById(R.id.nombre_deportivo);
		nombreDepor.setText(datos[position].getNombreDeportivo());
		
		TextView labelPuesto = (TextView) item.findViewById(R.id.label_puesto);
		labelPuesto.setText(datos[position].getLabel_puesto());
		
		TextView puesto = (TextView) item.findViewById(R.id.puesto);
		puesto.setText(datos[position].getPuesto());
		
		return item;
	}
}
