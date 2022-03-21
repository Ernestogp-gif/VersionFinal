package com.example.pagos.service;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pagos.dao.ModuloConsultaComerciodao;
import com.example.pagos.model.*;

@Service
@Transactional
public class ModuloConsultaComercioServiceImpl implements ModuloConsultaComercioService {

	@Autowired
	private ModuloConsultaComerciodao dao;
	
	public List<Pagos> TraerPagos() {
		return dao.TraerPagos();		
	}
	public List<Pagos> TraerPagosxFechas(Date fecini, Date fecfin) {
		return dao.TraerPagosxFechas(fecini,fecfin);		
	}
	public List<Pagos> TraerPagosxServicios(String servicio) {
		return dao.TraerPagosxServicios(servicio);		
	}
	
	public List<Recargas> TraerRecargas() {
		return dao.TraerRecargas();		
	}
	public List<Recargas> TraerRecargasxfecha(Date fecini, Date fecfin) {
		return dao.TraerRecargasxfecha(fecini, fecfin);		
	}
	
	
}
