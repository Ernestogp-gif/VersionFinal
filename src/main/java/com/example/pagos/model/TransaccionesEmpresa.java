package com.example.pagos.model;

public class TransaccionesEmpresa {
	
	private String cod;
	private String fecha;
	private float monto;
	private String tipopago;
	private String nombre;
	private String tipocomercio;
	private String distrito;
	private String departamento;
	private String servicio;
	public TransaccionesEmpresa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransaccionesEmpresa(String cod, String fecha, float monto, String tipopago, String nombre,
			String tipocomercio, String distrito, String departamento, String servicio) {
		super();
		this.cod = cod;
		this.fecha = fecha;
		this.monto = monto;
		this.tipopago = tipopago;
		this.nombre = nombre;
		this.tipocomercio = tipocomercio;
		this.distrito = distrito;
		this.departamento = departamento;
		this.servicio = servicio;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public String getTipopago() {
		return tipopago;
	}
	public void setTipopago(String tipopago) {
		this.tipopago = tipopago;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipocomercio() {
		return tipocomercio;
	}
	public void setTipocomercio(String tipocomercio) {
		this.tipocomercio = tipocomercio;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	
}
