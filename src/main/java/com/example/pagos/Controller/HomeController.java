package com.example.pagos.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pagos.service.ModuloInicioService;
import com.example.pagos.service.ModuloPagosService;

@Controller
public class HomeController {

	@Autowired(required = true)
	private ModuloInicioService service;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String Inicio() {
		return "Inicio";
	}	
	
	@PostMapping(value = "ValidarUsuario",produces = "application/json")
	public @ResponseBody String ValidarDatos(@RequestBody String correopass) {
		String[] parts = correopass.split("-");
		String correo = parts[0]; 
		String pass = parts[1]; 
		return service.ValidarDatos(correo.substring(1),pass.substring(0,pass.length()-1));
	}	
		
	
	
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "Menu", method = RequestMethod.GET)
	public String Menu() {
		return "Menu";
	}
	
	@RequestMapping(value = "Pago", method = RequestMethod.GET)
	public String Pago() {
		return "Pago";
	}
	
	@RequestMapping(value = "Consulta", method = RequestMethod.GET)
	public String Consulta() {
		return "Consulta";
	}
	
	@RequestMapping(value = "Recarga", method = RequestMethod.GET)
	public String Recarga() {
		return "Recarga";
	}
	
	@RequestMapping(value = "Login", method = RequestMethod.GET)
	public String Login() {
		return "Login";
	}
	
	@RequestMapping(value = "ConsultaEmpresa", method = RequestMethod.GET)
	public String ConsultaEmpresa() {
		return "ConsultaEmpresa";
	}
	
	@RequestMapping(value = "ConsultaComercioPagos", method = RequestMethod.GET)
	public String ConsultaComercioPagos() {
		return "ConsultaComercioPagos";
	}	
	
	@RequestMapping(value = "ConsultaComercioRecargas", method = RequestMethod.GET)
	public String ConsultaComercioRecargas() {
		return "ConsultaComercioRecargas";
	}	
}


