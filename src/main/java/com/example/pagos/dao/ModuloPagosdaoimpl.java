package com.example.pagos.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.pagos.model.*;
import com.example.pagos.model.*;


@Repository
public class ModuloPagosdaoimpl implements ModuloPagosdao {

	/*
	@Autowired
	private JdbcTemplate jdbcTemplate;
	*/
	 
	public Servicios ObtenerServicios(Servicios servicio) {

		String url = "jdbc:postgresql://localhost:5432/SistemaDePagos";
        String user = "postgres";
        String password = "postgres";
        String query = "select nombre_servicio from servicio where nombre_servicio = ?";
        
        Servicios servicio1 = new Servicios();
        
		try (Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pst = con.prepareStatement(query)){
			pst.setString(1, servicio.getNombre());			
			ResultSet rs = pst.executeQuery(); 			
			while(rs.next()) {

				servicio1.setNombre(servicio.getNombre());
			}
			rs.close();
			pst.close();
			con.close();
		}catch(SQLException throwables) {
			throwables.printStackTrace();		
		}		
		return servicio1;
	}	
	
	public List<Empresa> TraerEmpresas() {
		
		String url = "jdbc:postgresql://localhost:5432/SistemaDePagos";
        String user = "postgres";
        String password = "postgres";
        String query = "Select nombre_negocio from empresa A left join negocio B on A.ruc_empresa = B.ruc";
        List<Empresa> empresa = new ArrayList<Empresa>();
        
		try (Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pst = con.prepareStatement(query)){			
			ResultSet rs = pst.executeQuery(); 			
			while(rs.next()) {
				Empresa Emp = new Empresa();
				Emp.setNombre(rs.getString("nombre_negocio"));
				empresa.add(Emp);
			}
			rs.close();
			pst.close();
			con.close();
		}catch(SQLException throwables) {
			throwables.printStackTrace();			
		}		
		return empresa;		
	}
	
	public List<Servicios> TraerServicios(String Empresa) {
		String url = "jdbc:postgresql://localhost:5432/SistemaDePagos";
        String user = "postgres";
        String password = "postgres";
        String query = "select nombre_servicio from public.servicio where cod_servicio in "
        		+ " (select cod_servicio from public.servicio_empresa where ruc_empresa = "
        		+ " (select B.ruc from empresa A left join negocio B on A.ruc_empresa = B.ruc "
        		+ " where  B.nombre_negocio = ?))";
        List<Servicios> servicio = new ArrayList<Servicios>();        
        
		try (Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pst = con.prepareStatement(query)){
			pst.setString(1, Empresa);
			ResultSet rs = pst.executeQuery(); 			
			while(rs.next()) {
				Servicios servi = new Servicios();
				servi.setNombre(rs.getString("nombre_servicio"));
				servicio.add(servi);
			}
			rs.close();
			pst.close();
			con.close();
		}catch(SQLException throwables) {
			throwables.printStackTrace();			
		}		
		return servicio;
	}
	
	public List<Cliente> TraerTipIdentificador(String Empresa) {
		String url = "jdbc:postgresql://localhost:5432/SistemaDePagos";
        String user = "postgres";
        String password = "postgres";
        String query = "select distinct(tipo_codigo) from cliente where cod_cliente in "
        		+ " (select distinct(cod_cliente) from servicio_cliente where cod_servicio = "
        		+ " (select cod_servicio from servicio where nombre_servicio = ?))";
        List<Cliente> cliente = new ArrayList<Cliente>();        
        
		try (Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pst = con.prepareStatement(query)){
			pst.setString(1, Empresa);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Cliente cli = new Cliente();
				cli.setTipo_codigo(rs.getString("tipo_codigo"));
				cliente.add(cli);
			}
			rs.close();
			pst.close();
			con.close();
		}catch(SQLException throwables) {
			throwables.printStackTrace();			
		}		
		return cliente;
	}
	
	
	public List<Servicio_Cliente> TraerDeuda(String Servicio,String Identificador) {
		String url = "jdbc:postgresql://localhost:5432/SistemaDePagos";
        String user = "postgres";
        String password = "postgres";
        String query = "select A.nombre_cliente,B.nombre_servicio,A.costo from ( "
        		+ " select costo,nombre_cliente,cod_servicio from ( "
        		+ " select * from servicio_cliente "
        		+ " where cod_cliente = ? and cod_servicio = "
        		+ " (select cod_servicio from servicio where nombre_servicio = ?) "
        		+ " ) A left join Cliente B on A.cod_cliente = B.cod_cliente "
        		+ " ) A left join servicio B on A.cod_servicio = B.cod_servicio";
        
        List<Servicio_Cliente> Servicio_Cliente = new ArrayList<Servicio_Cliente>();        
        
		try (Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pst = con.prepareStatement(query)){
			pst.setString(1, Identificador);
			pst.setString(2, Servicio);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Servicio_Cliente servicio_cliente = new Servicio_Cliente();				
				servicio_cliente.setCod_cliente(rs.getString("nombre_cliente"));
				servicio_cliente.setCod_servicio(rs.getString("nombre_servicio"));
				servicio_cliente.setCosto(rs.getString("costo"));
				Servicio_Cliente.add(servicio_cliente);
			}
			rs.close();
			pst.close();
			con.close();
		}catch(SQLException throwables) {
			throwables.printStackTrace();			
		}		
		return Servicio_Cliente;
	}
	
	
	public String ConfirmarTransaccion(Transaccion transaccion) {
		String url = "jdbc:postgresql://localhost:5432/SistemaDePagos?call";
        String user = "postgres";
        String password = "postgres"; 

		String retorno ="";
		try (Connection con = DriverManager.getConnection(url, user, password);
				Statement statement = con.createStatement()){
			
			ResultSet resultSet = null;

	        resultSet = statement.executeQuery("SELECT llamarsp('"+transaccion.getRuc_comercio()+"'," 
	        									+ transaccion.getMonto_transaccion() + ",'" 
	        									+ transaccion.getServicio() +"','"
	        									+ transaccion.getCodcliente() +	"');");
	        resultSet.toString();
	        if (resultSet.next()) {
	        	retorno = resultSet.getString("llamarsp");
	        }
		}catch(SQLException throwables) {
			throwables.printStackTrace();			
		}		
		return retorno;
	}	
	
	
	public String TraerSaldo(String RucComercio) {
		String url = "jdbc:postgresql://localhost:5432/SistemaDePagos";
        String user = "postgres";
        String password = "postgres"; 
        String query = "select monto_actual from billetera where ruc_comercio = ?";
        
		String retorno ="";
		try (Connection con = DriverManager.getConnection(url, user, password);
				PreparedStatement pst = con.prepareStatement(query)){
			
			pst.setString(1, RucComercio);			
			ResultSet resultSet = pst.executeQuery();
			//retorno = Float.toString(resultSet.getFloat("monto_actual"));
			if (resultSet.next()) {
	        	retorno = Float.toString(resultSet.getFloat("monto_actual"));
			}
			resultSet.close();
			pst.close();
			con.close();
		}catch(SQLException throwables) {
			throwables.printStackTrace();			
		}		
		return retorno;
	}	


}

/*
Connection con = jdbcTemplate.getDataSource().getConnection();
String SQL= "select nombre_servicio from servicio where nombre_servicio = ?";
//Statement ps = con.createStatement();
PreparedStatement ps = con.prepareStatement(SQL);
ps.setString(1, servicio.getNombre());

ResultSet rs = ps.executeQuery();

while(rs.next()) {
	servicio = new Servicios();
	servicio.setNombre(rs.getString("nombre_servicio"));
	servicio.setNombre("Si trajo datos");
}
servicio.setNombre("No trajo nada");
//servicio.setNombre(rs.getString("nombre_servicio"));
rs.close();
ps.close();
con.close();
*/

