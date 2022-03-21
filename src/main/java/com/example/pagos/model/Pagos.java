package com.example.pagos.model;

public class Pagos {
	private String fecha;
	private String cod;
	private String servicio;
	private float monto;	
	
	public Pagos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pagos(String fecha, String cod, String servicio, float monto) {
		super();
		this.fecha = fecha;
		this.cod = cod;
		this.servicio = servicio;
		this.monto = monto;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}
	
	
	
}
