package com.example.pagos.service;

import java.util.List;

import com.example.pagos.model.*;


public interface ModuloPagosService {
	
	public abstract Servicios ObtenerServicios(Servicios servicio);
	public abstract List<Servicios> TraerServicios(String Empresa);
	public abstract List<Empresa> TraerEmpresas();
	public abstract List<Cliente> TraerTipIdentificador(String Empresa);
	public abstract List<Servicio_Cliente> TraerDeuda(String Servicio, String Identificador);
	public abstract String ConfirmarTransaccion(Transaccion transaccion);
	public abstract String TraerSaldo(String RucComercio);


	
}