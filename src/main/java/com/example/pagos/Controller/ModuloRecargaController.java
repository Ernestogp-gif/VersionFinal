package com.example.pagos.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pagos.model.*;
import com.example.pagos.service.*;

@RestController
@RequestMapping(path = "Recarga/")
public class ModuloRecargaController {
	@Autowired(required = true)
	private ModuloRecargaService service;
	
	@PostMapping(value = "ConfirmarRecarga",produces = "application/json")
	public @ResponseBody String ConfirmarRecarga(@RequestBody String MontoRuc) {
		String[] parts = MontoRuc.split("-");
		String monto = parts[0]; 
		String ruc = parts[1]; 
		float f_Val = Float.valueOf(monto.substring(1));
		return service.ConfirmarRecarga(f_Val,ruc.substring(0, ruc.length()-1));		
	}
	
}
