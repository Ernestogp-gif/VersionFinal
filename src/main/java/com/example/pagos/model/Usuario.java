package com.example.pagos.model;

public class Usuario {
	private String correo;
	private String pass;
	public Usuario(String correo, String pass) {
		super();
		this.correo = correo;
		this.pass = pass;
	}
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
