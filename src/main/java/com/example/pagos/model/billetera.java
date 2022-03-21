package com.example.pagos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "billetera")
public class billetera {
	
	@Id
	private String cod_billetera;
	@Column(name = "monto_actual")
	private String monto_actual;
	@Column(name = "monto_comision")
	private String monto_comision;
	@Column(name = "ruc_comercio")
	private String ruc_comercio;
	
	public billetera(String cod_billetera, String monto_actual, String monto_comision, String ruc_comercio) {
		super();
		this.cod_billetera = cod_billetera;
		this.monto_actual = monto_actual;
		this.monto_comision = monto_comision;
		this.ruc_comercio = ruc_comercio;
	}
	public billetera() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public String getCod_billetera() {
		return cod_billetera;
	}
	public void setCod_billetera(String cod_billetera) {
		this.cod_billetera = cod_billetera;
	}
	public String getMonto_actual() {
		return monto_actual;
	}
	public void setMonto_actual(String monto_actual) {
		this.monto_actual = monto_actual;
	}
	public String getMonto_comision() {
		return monto_comision;
	}
	public void setMonto_comision(String monto_comision) {
		this.monto_comision = monto_comision;
	}
	public String getRuc_comercio() {
		return ruc_comercio;
	}
	public void setRuc_comercio(String ruc_comercio) {
		this.ruc_comercio = ruc_comercio;
	}
}
