package com.example.pagos.model;

public class Servicio_Cliente {

	private String costo;
	private String cod_cliente;
	private String cod_servicio;
	public Servicio_Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Servicio_Cliente(String costo, String cod_cliente, String cod_servicio) {
		super();
		this.costo = costo;
		this.cod_cliente = cod_cliente;
		this.cod_servicio = cod_servicio;
	}
	public String getCosto() {
		return costo;
	}
	public void setCosto(String costo) {
		this.costo = costo;
	}
	public String getCod_cliente() {
		return cod_cliente;
	}
	public void setCod_cliente(String cod_cliente) {
		this.cod_cliente = cod_cliente;
	}
	public String getCod_servicio() {
		return cod_servicio;
	}
	public void setCod_servicio(String cod_servicio) {
		this.cod_servicio = cod_servicio;
	}
	
	
}
