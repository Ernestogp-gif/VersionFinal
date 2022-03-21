package com.example.pagos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.pagos.model.*;

@Repository
public class ModuloConsultaComerciodaoimpl implements ModuloConsultaComerciodao{
	
	public List<Pagos> TraerPagos() {
		
		String url = "jdbc:postgresql://localhost:5432/SistemaDePagos";
        String user = "postgres";
        String password = "postgres";
        String query = "select A.fecha,A.codigo,B.nombre_servicio,A.monto from ( "
        		+ "select JUNTAR_FECHA_HORA(A.fecha_transaccion,a.hora_transaccion) as Fecha, "
        		+ "A.cod_transaccion as Codigo,A.monto_transaccion as Monto, "
        		+ "B.cod_servicio, A.ruc_comercio "
        		+ "from transaccion A right join pago B on A.cod_transaccion = B.cod_transaccion "
        		+ "where A.fecha_transaccion > (SELECT NOW() - INTERVAL '2 days') "
        		+ "and A.ruc_comercio = '12876543928') A "
        		+ "left join servicio B on A.cod_servicio = B.cod_servicio "
        		+ "order by codigo desc ";
        
        List<Pagos> Pago = new ArrayList<Pagos>();
        
		try (Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pst = con.prepareStatement(query)){
			ResultSet rs = pst.executeQuery();  			
			while(rs.next()) {
				Pagos pago = new Pagos();
				pago.setFecha(rs.getString("fecha"));
				pago.setCod(rs.getString("codigo"));
				pago.setServicio(rs.getString("nombre_servicio"));
				pago.setMonto(rs.getFloat("monto"));
				Pago.add(pago);
			}
			rs.close();
			pst.close();
			con.close();
			
		}catch(SQLException throwables) {
			throwables.printStackTrace();		
		}
		return Pago;
	}


	public List<Pagos> TraerPagosxFechas(Date fecini, Date fecfin) {
		String url = "jdbc:postgresql://localhost:5432/SistemaDePagos";
        String user = "postgres";
        String password = "postgres";
        String query = "select A.fecha,A.codigo,B.nombre_servicio,A.monto from ( "
        		+ "select JUNTAR_FECHA_HORA(A.fecha_transaccion,a.hora_transaccion) as Fecha, "
        		+ "A.cod_transaccion as Codigo,A.monto_transaccion as Monto, "
        		+ "B.cod_servicio, A.ruc_comercio "
        		+ "from transaccion A right join pago B on A.cod_transaccion = B.cod_transaccion "
        		+ "where A.fecha_transaccion between ? and ?  "
        		+ "and A.ruc_comercio = '12876543928') A "
        		+ "left join servicio B on A.cod_servicio = B.cod_servicio  "
        		+ "order by codigo desc ";
        
        List<Pagos> Pago = new ArrayList<Pagos>();
        
		try (Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pst = con.prepareStatement(query)){
			
			pst.setDate(1, fecini);
			pst.setDate(2, fecfin);
			
			
			ResultSet rs = pst.executeQuery();  			
			while(rs.next()) {
				Pagos pago = new Pagos();
				pago.setFecha(rs.getString("fecha"));
				pago.setCod(rs.getString("codigo"));
				pago.setServicio(rs.getString("nombre_servicio"));
				pago.setMonto(rs.getFloat("monto"));
				Pago.add(pago);
			}
			rs.close();
			pst.close();
			con.close();
			
		}catch(SQLException throwables) {
			throwables.printStackTrace();		
		}
		return Pago;
	}


	public List<Pagos> TraerPagosxServicios(String servicio) {
		String url = "jdbc:postgresql://localhost:5432/SistemaDePagos";
        String user = "postgres";
        String password = "postgres";
        String query = "select A.fecha,A.codigo,B.nombre_servicio,A.monto from ( "
        		+ "select JUNTAR_FECHA_HORA(A.fecha_transaccion,a.hora_transaccion) as Fecha, "
        		+ "A.cod_transaccion as Codigo,A.monto_transaccion as Monto, "
        		+ "B.cod_servicio, A.ruc_comercio "
        		+ "from transaccion A right join pago B on A.cod_transaccion = B.cod_transaccion "
        		+ "where A.fecha_transaccion > (SELECT NOW() - INTERVAL '2 days') "
        		+ "and A.ruc_comercio = '12876543928') A left join servicio B "
        		+ "on A.cod_servicio = B.cod_servicio where B.nombre_servicio = ? "
        		+ "order by codigo desc ";
        
        List<Pagos> Pago = new ArrayList<Pagos>();
        
		try (Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pst = con.prepareStatement(query)){
			pst.setString(1, servicio);
			ResultSet rs = pst.executeQuery();  			
			while(rs.next()) {
				Pagos pago = new Pagos();
				pago.setFecha(rs.getString("fecha"));
				pago.setCod(rs.getString("codigo"));
				pago.setServicio(rs.getString("nombre_servicio"));
				pago.setMonto(rs.getFloat("monto"));
				Pago.add(pago);
			}
			rs.close();
			pst.close();
			con.close();
			
		}catch(SQLException throwables) {
			throwables.printStackTrace();		
		}
		return Pago;
	}	
	
	
	
	
	public List<Recargas> TraerRecargas() {
		String url = "jdbc:postgresql://localhost:5432/SistemaDePagos";
        String user = "postgres";
        String password = "postgres";
        String query = "select B.fecha,B.codigo,B.monto from recarga A left join "
        		+ "(select JUNTAR_FECHA_HORA(fecha_transaccion,hora_transaccion) AS fecha, "
        		+ " cod_transaccion AS codigo, monto_transaccion AS monto, ruc_comercio "
        		+ "from transaccion A where A.fecha_transaccion > (SELECT NOW() - INTERVAL '24 months') ) B "
        		+ "on A.cod_transaccion = B.codigo where B.ruc_comercio = '12876543928' "
        		+ "order by cod_transaccion desc";
        
        List<Recargas> Recarga = new ArrayList<Recargas>();
        
		try (Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pst = con.prepareStatement(query)){
			ResultSet rs = pst.executeQuery();  			
			while(rs.next()) {
				Recargas recarga = new Recargas();
				recarga.setFecha(rs.getString("fecha"));
				recarga.setCodigo(rs.getString("codigo"));
				recarga.setMonto(rs.getFloat("monto"));
				Recarga.add(recarga);
			}
			rs.close();
			pst.close();
			con.close();
			
		}catch(SQLException throwables) {
			throwables.printStackTrace();		
		}
		return Recarga;
	}
	
	
	
	public List<Recargas> TraerRecargasxfecha(Date fecini, Date fecfin) {
		String url = "jdbc:postgresql://localhost:5432/SistemaDePagos";
        String user = "postgres";
        String password = "postgres";
        String query = "select B.fecha,B.codigo,B.monto from recarga A left join "
        		+ "(select JUNTAR_FECHA_HORA(fecha_transaccion,hora_transaccion) AS fecha, "
        		+ " cod_transaccion AS codigo, monto_transaccion AS monto, ruc_comercio\r\n"
        		+ "from transaccion A where A.fecha_transaccion between ? and ? ) B "
        		+ "on A.cod_transaccion = B.codigo where B.ruc_comercio = '12876543928' "
        		+ "order by cod_transaccion desc";
        
        List<Recargas> Recarga = new ArrayList<Recargas>();
        
		try (Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pst = con.prepareStatement(query)){
			pst.setDate(1, fecini);
			pst.setDate(2, fecfin);
			
			ResultSet rs = pst.executeQuery();  			
			while(rs.next()) {
				Recargas recarga = new Recargas();
				recarga.setFecha(rs.getString("fecha"));
				recarga.setCodigo(rs.getString("codigo"));
				recarga.setMonto(rs.getFloat("monto"));
				Recarga.add(recarga);
			}
			rs.close();
			pst.close();
			con.close();
			
		}catch(SQLException throwables) {
			throwables.printStackTrace();		
		}
		return Recarga;
	}
	
	
	
}
