package com.example.pagos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

@Repository
public class ModuloRecargadaoImpl implements ModuloRecargadao{

	@Override
	public String ConfirmarRecarga(float monto, String ruc) {
		String url = "jdbc:postgresql://localhost:5432/SistemaDePagos?call";
        String user = "postgres";
        String password = "postgres"; 

		String retorno ="";
		try (Connection con = DriverManager.getConnection(url, user, password);
				Statement statement = con.createStatement()){
			
			ResultSet resultSet = null;

	        resultSet = statement.executeQuery("SELECT confirmarrecarga("+ monto +",'" 
	        									+ ruc +"');");
	        resultSet.toString();
	        if (resultSet.next()) {
	        	retorno = resultSet.getString("confirmarrecarga");
	        }
		}catch(SQLException throwables) {
			throwables.printStackTrace();			
		}		
		return retorno;
	}

}
