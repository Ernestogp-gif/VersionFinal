package com.example.pagos.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class Cliente {

	@Id
	private String cod_cliente;
	@Column(name = "nombre_cliente")
	private String nombre_cliente;
	@Column(name = "tipo_codigo")
	private String tipo_codigo;
	@Column(name = "ruc_empresa")
	private String ruc_empresa;
		
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(String cod_cliente, String nombre_cliente, String tipo_codigo, String ruc_empresa) {
		super();
		this.cod_cliente = cod_cliente;
		this.nombre_cliente = nombre_cliente;
		this.tipo_codigo = tipo_codigo;
		this.ruc_empresa = ruc_empresa;
	}

	public String getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(String cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getTipo_codigo() {
		return tipo_codigo;
	}

	public void setTipo_codigo(String tipo_codigo) {
		this.tipo_codigo = tipo_codigo;
	}

	public String getRuc_empresa() {
		return ruc_empresa;
	}

	public void setRuc_empresa(String ruc_empresa) {
		this.ruc_empresa = ruc_empresa;
	}


	
}
