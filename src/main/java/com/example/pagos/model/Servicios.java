package com.example.pagos.model;

import lombok.Data;

@Data
public class Servicios {
	private String nombre;	

	public Servicios() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Servicios(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
