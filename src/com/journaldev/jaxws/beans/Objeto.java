package com.journaldev.jaxws.beans;

import java.io.Serializable;

public class Objeto implements Serializable{
	
	private static final long serialVersionUID = -5585579081128070494L;
	
	private String nombre;
	private String color;
	private int id;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
