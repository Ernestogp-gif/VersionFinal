package com.example.pagos.model;


import java.util.Date;

public class Empresa {

	private String correo;
	private String RUC;
	private String nombre;
	private Date fechaafiliacion;
	private String cuentabank;
	public Empresa(String correo, String rUC, String nombre, Date fechaafiliacion, String cuentabank) {
		super();
		this.correo = correo;
		RUC = rUC;
		this.nombre = nombre;
		this.fechaafiliacion = fechaafiliacion;
		this.cuentabank = cuentabank;
	}
	public Empresa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getRUC() {
		return RUC;
	}
	public void setRUC(String rUC) {
		RUC = rUC;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaafiliacion() {
		return fechaafiliacion;
	}
	public void setFechaafiliacion(Date fechaafiliacion) {
		this.fechaafiliacion = fechaafiliacion;
	}
	public String getCuentabank() {
		return cuentabank;
	}
	public void setCuentabank(String cuentabank) {
		this.cuentabank = cuentabank;
	}	
}
