package com.example.pagos.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pagos.model.*;

import com.example.pagos.dao.*;

@Service
@Transactional
public class ModuloPagosServiceimpl implements ModuloPagosService {

	@Autowired
	private ModuloPagosdao dao;
	
	public Servicios ObtenerServicios(Servicios servicio) {
		return dao.ObtenerServicios(servicio);		
	}
	
	public List<Empresa> TraerEmpresas() {
		return dao.TraerEmpresas();		
	}
	
	public List<Servicios> TraerServicios(String Empresa) {
		return dao.TraerServicios(Empresa);		
	}
	
	public List<Cliente> TraerTipIdentificador(String Empresa) {
		return dao.TraerTipIdentificador(Empresa);		
	} 	
	
	public List<Servicio_Cliente> TraerDeuda(String Servicio, String Identificador){
		return dao.TraerDeuda(Servicio,Identificador);
	}
	
	public String ConfirmarTransaccion(Transaccion transaccion){
		return dao.ConfirmarTransaccion(transaccion);
	}

	public String TraerSaldo(String RucComercio){
		return dao.TraerSaldo(RucComercio);
	}
	
}