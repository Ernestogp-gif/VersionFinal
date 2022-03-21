package com.example.pagos.service;

import java.sql.Date;
import java.util.List;

import com.example.pagos.model.*;


public interface ModuloConsultaComercioService {
	
	public abstract List<Pagos> TraerPagos();
	public abstract List<Pagos> TraerPagosxFechas(Date fecini, Date fecfin);
	public abstract List<Pagos> TraerPagosxServicios(String servicio);
	
	public abstract List<Recargas> TraerRecargas();
	public abstract List<Recargas> TraerRecargasxfecha(Date fecini, Date fecfin);
	
}
