package com.example.pagos.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pagos.dao.ModuloIniciodao;
import com.example.pagos.model.Usuario;

@Service
@Transactional
public class ModuloInicioServiceImpl implements ModuloInicioService {
	
    @Autowired
    private ModuloIniciodao dao;

    public String ValidarDatos(String correo, String pass){
        return dao.ValidarDatos(correo, pass);
    }


}
