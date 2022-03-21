package com.example.pagos.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pagos.dao.*;

@Service
@Transactional
public class ModuloRecargaServiceImpl implements ModuloRecargaService{

	@Autowired
	private ModuloRecargadao dao;


	public String ConfirmarRecarga(float monto, String ruc) {		
		return dao.ConfirmarRecarga(monto, ruc);
	}
	
	
}
