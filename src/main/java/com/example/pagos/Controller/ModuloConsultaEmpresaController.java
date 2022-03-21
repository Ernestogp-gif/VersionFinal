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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pagos.model.*;

import com.example.pagos.service.*;

@RestController
@RequestMapping(path = "ReporteEmpresa/")
public class ModuloConsultaEmpresaController {

	@Autowired(required = true)
	private ModuloConsultaEmpresaService service;
	
	@RequestMapping(value = "ConsultarTransacciones",produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<TransaccionesEmpresa> TraerTransacciones() {
		return service.TraerTransacciones();
	}
	
	@RequestMapping(value = "ConsultarTransaccionesxfecha",produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody List<TransaccionesEmpresa> TraerTransaccionesxfechas(String fecha) {
		String[] parts = fecha.split("-");	
		Date fec1 = null;
		Date fec2 = null;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		LocalDate fecini = LocalDate.parse(parts[0], formato);
		LocalDate fecfin = LocalDate.parse(parts[1], formato);
		fec1 = Date.valueOf(fecini);
		fec2 = Date.valueOf(fecfin);	
		
		return service.TraerTransaccionesxfechas(fec1,fec2);
	}
	
	
	
}









