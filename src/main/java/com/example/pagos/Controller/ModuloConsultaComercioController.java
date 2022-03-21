package com.example.pagos.Controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pagos.model.*;

import com.example.pagos.service.ModuloConsultaComercioService;

@RestController
@RequestMapping(path = "Reportes/")
public class ModuloConsultaComercioController {

	@Autowired(required = true)
	private ModuloConsultaComercioService service;
	
	@RequestMapping(value = "ConsultarPagos",produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<Pagos> TraerPagos() {
		return service.TraerPagos();
	}


	
	@PostMapping(value = "ConsultarPagosxfecha",produces = "application/json")
	public @ResponseBody List<Pagos> TraerPagosxfechas(@RequestBody String fecha) {
		fecha = fecha.replace("m", "/");
		String[] parts = fecha.split("-");	
		Date fec1 = null;
		Date fec2 = null;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		LocalDate fecini = LocalDate.parse(parts[0], formato);
		LocalDate fecfin = LocalDate.parse(parts[1], formato);
		fec1 = Date.valueOf(fecini);
		fec2 = Date.valueOf(fecfin);
		return service.TraerPagosxFechas(fec1,fec2);
	}
	
	@PostMapping(value = "ConsultarPagosxServicio",produces = "application/json")
	public @ResponseBody List<Pagos> TraerPagosxServicios(@RequestBody String servicio) {
		System.out.println(servicio);
		return service.TraerPagosxServicios(servicio);
	}
	
	
	@RequestMapping(value = "ConsultarRecargas",produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<Recargas> TraerRecargas() {
		return service.TraerRecargas();
	}
	
	
	@PostMapping(value = "ConsultarRecargasxfecha",produces = "application/json")
	public @ResponseBody List<Recargas> TraerRecargasxfecha(@RequestBody String fecha) {
		fecha = fecha.replace("m", "/");
		String[] parts = fecha.split("-");	
		Date fec1 = null;
		Date fec2 = null;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		LocalDate fecini = LocalDate.parse(parts[0], formato);
		LocalDate fecfin = LocalDate.parse(parts[1], formato);
		fec1 = Date.valueOf(fecini);
		fec2 = Date.valueOf(fecfin);
		return service.TraerRecargasxfecha(fec1,fec2);
	}
	
	

}
