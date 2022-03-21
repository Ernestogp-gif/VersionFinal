package com.example.pagos.dao;

import java.util.List;

import com.example.pagos.model.*;


public interface ModuloPagosdao {
	public abstract Servicios ObtenerServicios(Servicios servicio);
	public abstract List<Empresa> TraerEmpresas();
	public abstract List<Servicios> TraerServicios(String Empresa);
	public abstract List<Cliente> TraerTipIdentificador(String Empresa);
	public abstract List<Servicio_Cliente> TraerDeuda(String Servicio,String Identificador);
	public abstract String ConfirmarTransaccion(Transaccion transaccion);
	public abstract String TraerSaldo(String RucComercio);
}
