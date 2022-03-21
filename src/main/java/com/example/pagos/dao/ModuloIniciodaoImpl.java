package com.example.pagos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.example.pagos.model.*;

@Repository
public class ModuloIniciodaoImpl  implements ModuloIniciodao{
	
    public String ValidarDatos(String correo, String pass) {
        String url = "jdbc:postgresql://localhost:5432/SistemaDePagos";
        String user = "postgres";
        String password = "postgres";
        String query = "select ruc_comercio from comercio where num_documento = ( "
        		+ "select num_documento from persona where cod_usuario = ( "
        		+ "select cod_usuario from usuario "
        		+ "where correo = ? and contraseña = ? ) )";
        
        Usuario usuario = new Usuario();
        String Respuesta = "";
		try (Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pst = con.prepareStatement(query)){
			
			pst.setString(1, correo);
			pst.setString(2, pass);	
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				usuario.setCorreo(rs.getString("ruc_comercio"));
				Respuesta = rs.getString("ruc_comercio");
			}
			rs.close();
			pst.close();
			con.close();
		}catch(SQLException throwables) {
			throwables.printStackTrace();		
		}		
		return Respuesta;
    }
}
