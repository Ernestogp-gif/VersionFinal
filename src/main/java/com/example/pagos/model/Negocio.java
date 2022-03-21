package com.example.pagos.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class Negocio {

	@Id
	private String ruc;
	@Column(name = "nombre_negocio")
	private String nombre_negocio;
	@Column(name = "fecha_afiliacion")
	private String fecha_afiliacion;
	@Column(name = "cuenta_bank")
	String ruc_comercio = "cuenta_bank";
	public Negocio(String ruc, String nombre_negocio, String fecha_afiliacion, String ruc_comercio) {
		super();
		this.ruc = ruc;
		this.nombre_negocio = nombre_negocio;
		this.fecha_afiliacion = fecha_afiliacion;
		this.ruc_comercio = ruc_comercio;
	}
	public Negocio() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getNombre_negocio() {
		return nombre_negocio;
	}
	public void setNombre_negocio(String nombre_negocio) {
		this.nombre_negocio = nombre_negocio;
	}
	public String getFecha_afiliacion() {
		return fecha_afiliacion;
	}
	public void setFecha_afiliacion(String fecha_afiliacion) {
		this.fecha_afiliacion = fecha_afiliacion;
	}
	public String getRuc_comercio() {
		return ruc_comercio;
	}
	public void setRuc_comercio(String ruc_comercio) {
		this.ruc_comercio = ruc_comercio;
	}
	
	
	
}
