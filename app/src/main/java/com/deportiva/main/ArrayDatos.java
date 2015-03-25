package com.deportiva.main;

public class ArrayDatos {

	private String title;
	private String description;
	private int image;
	
	public ArrayDatos(String t, String d, int i){
		this.title=t;
		this.description=d;
		this.image=i;
	}
	
	public void setTitle(String t){
		
		this.title=t;
	}
	
	public void setDescription(String d){
		this.description = d;
	}
	
	public void setImage(int i){
	
		this.image = i;
	}
	
	public String getTitle(){
		
		return this.title;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public int getImage(){
		return this.image;
	}
}
