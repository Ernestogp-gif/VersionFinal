package com.example.pagos.Controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.pagos.model.*;
import com.example.pagos.service.*;

@RestController
@RequestMapping(path = "api/")
public class ModuloPagosController {
	
	@Autowired(required = true)
	private ModuloPagosService service;
	/*
	@RequestMapping(value = "search",produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody Servicios ObtenerServicios(@RequestBody String nombre) { 
		Servicios servicio = new Servicios();
		servicio.setNombre(nombre);
		System.out.println(servicio.getNombre());
		return service.ObtenerServicios(servicio);
	}
	*/
	@RequestMapping(value = "search",produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody Servicios ObtenerServicios(@RequestBody Servicios servicio) { 
		return service.ObtenerServicios(servicio);
	}
	
	@RequestMapping(value = "Empresas",produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<Empresa> TraerEmpresas() { 		
		return service.TraerEmpresas();
	}
	
	@PostMapping(value = "Servicios",produces = "application/json")
	public @ResponseBody List<Servicios> TraerServicios(@RequestBody String Empresa) { 
		return service.TraerServicios(Empresa);
	}
	
	@PostMapping(value = "TipIdent",produces = "application/json")
	public @ResponseBody List<Cliente> TraerTipIdentificador(@RequestBody String Empresa) { 
		return service.TraerTipIdentificador(Empresa);
	}
	
	@PostMapping(value = "Deuda",produces = "application/json")
	public @ResponseBody List<Servicio_Cliente> TraerDeuda(@RequestBody String Servicio_Identificador) { 		
		String[] parts = Servicio_Identificador.split("-");
		String Servicio = parts[0]; 
		String Identificador = parts[1]; 
		return service.TraerDeuda(Servicio,Identificador);
	}
	
	@PostMapping(value = "Confirmar",produces = "application/json")
	public @ResponseBody String ConfirmarTransaccion(@RequestBody Transaccion transaccion) {
		return service.ConfirmarTransaccion(transaccion);		
	}
	
	@PostMapping(value = "Saldo",produces = "application/json")
	public @ResponseBody String TraerSaldo(@RequestBody String RucComercio) {
		RucComercio = RucComercio.substring(1, RucComercio.length()-1);	
		return service.TraerSaldo(RucComercio);
	}
	
	/*
	System.out.println(transaccion.getMonto_transaccion());
	System.out.println(transaccion.getRuc_comercio());
	System.out.println(transaccion.getServicio());
	System.out.println(transaccion.getCodcliente());
	String valor = service.ConfirmarTransaccion(transaccion);
	System.out.println(valor);
	*/
	
	/*
	System.out.println(transaccion.getMonto_transaccion());
	System.out.println(transaccion.getRuc_comercio());
	String valor = service.ConfirmarTransaccion(transaccion);
	System.out.println(valor);
	*/
	
	//Servicios.class.
	//System.out.println(service.TraerServicios(Empresa)[0].nombre);
	/*
	System.out.println(Empresa);
	List<Servicios> service1 = new ArrayList<Servicios>();     
	service1 = service.TraerServicios(Empresa);
	for(int i = 0; i<service1.size();i++) {
		System.out.println(service1.get(i).getNombre());
	}
	*/
	
	
}
