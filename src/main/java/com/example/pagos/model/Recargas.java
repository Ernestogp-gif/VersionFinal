package com.example.pagos.model;

public class Recargas {
	private String fecha;
	private String codigo;
	private float monto;
	public Recargas(String fecha, String codigo, float monto) {
		super();
		this.fecha = fecha;
		this.codigo = codigo;
		this.monto = monto;
	}
	public Recargas() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	
	
}
