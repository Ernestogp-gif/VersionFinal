package com.example.pagos.model;

import java.sql.Time;
import java.util.Date;

public class Transaccion {

	private float monto_transaccion;
	private String ruc_comercio;
	private String servicio;
	private String codcliente;
	
	
	public Transaccion() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Transaccion(float monto_transaccion, String ruc_comercio, String servicio, String codcliente) {
		super();
		this.monto_transaccion = monto_transaccion;
		this.ruc_comercio = ruc_comercio;
		this.servicio = servicio;
		this.codcliente = codcliente;
	}


	public float getMonto_transaccion() {
		return monto_transaccion;
	}


	public void setMonto_transaccion(float monto_transaccion) {
		this.monto_transaccion = monto_transaccion;
	}


	public String getRuc_comercio() {
		return ruc_comercio;
	}


	public void setRuc_comercio(String ruc_comercio) {
		this.ruc_comercio = ruc_comercio;
	}


	public String getServicio() {
		return servicio;
	}


	public void setServicio(String servicio) {
		this.servicio = servicio;
	}


	public String getCodcliente() {
		return codcliente;
	}


	public void setCodcliente(String codcliente) {
		this.codcliente = codcliente;
	}
	
	
	
	
}
