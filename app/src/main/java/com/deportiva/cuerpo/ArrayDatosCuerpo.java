package com.deportiva.cuerpo;

public class ArrayDatosCuerpo {

	private String nombre;
	private String nombreDeportivo;
	private String puesto;
	private String label_puesto;
	private String label_nombre_deportivo;
	private int image;
	
	public ArrayDatosCuerpo(String nom, String label_nom_depor, String nomDep, String label_pues, String pues, int i){
		this.nombre=nom;
		this.nombreDeportivo=nomDep;
		this.puesto=pues;
		this.label_puesto=label_pues;
		this.label_nombre_deportivo= label_nom_depor;
		this.image=i;
	}

	public String getLabel_puesto() {
		return label_puesto;
	}

	public void setLabel_puesto(String label_puesto) {
		this.label_puesto = label_puesto;
	}

	public String getLabel_nombre_deportivo() {
		return label_nombre_deportivo;
	}

	public void setLabel_nombre_deportivo(String label_nombre_deportivo) {
		this.label_nombre_deportivo = label_nombre_deportivo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreDeportivo() {
		return nombreDeportivo;
	}

	public void setNombreDeportivo(String nombreDeportivo) {
		this.nombreDeportivo = nombreDeportivo;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}
	

}