package com.example.pagos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.pagos.model.*;

@Repository
public class ModuloConsultaEmpresadaoImpl implements ModuloConsultaEmpresadao{

	
	public List<TransaccionesEmpresa> TraerTransacciones() {
		String url = "jdbc:postgresql://localhost:5432/SistemaDePagos";
        String user = "postgres";
        String password = "postgres";
        String query = "select A.cod_transaccion,JUNTAR_FECHA_HORA(A.fecha_transaccion,A.hora_transaccion) as fecha, "
        		+ "A.monto_transaccion,A.tipo_pago,B.nombre_negocio,B.tipo_comercio,B.distrito,B.departamento, "
        		+ "A.nombre_servicio "
        		+ "from ( select A.*,B.nombre_servicio from ( "
        		+ "select A.*,B.tipo_pago,B.cod_servicio "
        		+ "from transaccion A left join pago B on A.cod_transaccion = B.cod_transaccion) A "
        		+ "left join servicio B on A.cod_servicio = B.cod_servicio ) A "
        		+ "left join (select * from negocio A left join comercio B on A.ruc = B.ruc_comercio) B "
        		+ "on A.ruc_comercio = B.ruc_comercio "
        		+ "where JUNTAR_FECHA_HORA(A.fecha_transaccion,A.hora_transaccion) > (SELECT NOW() - INTERVAL '1 months') "
        		+ " order by A.cod_transaccion desc";
        
        List<TransaccionesEmpresa> Transaccion = new ArrayList<TransaccionesEmpresa>();
        
		try (Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pst = con.prepareStatement(query)){
			ResultSet rs = pst.executeQuery();  			
			while(rs.next()) {
				TransaccionesEmpresa transaccion = new TransaccionesEmpresa();
				transaccion.setCod(rs.getString("cod_transaccion"));
				transaccion.setFecha(rs.getString("fecha"));
				transaccion.setMonto(rs.getFloat("monto_transaccion"));
				transaccion.setTipopago(rs.getString("tipo_pago"));
				transaccion.setNombre(rs.getString("nombre_negocio"));
				transaccion.setTipocomercio(rs.getString("tipo_comercio"));
				transaccion.setDistrito(rs.getString("distrito"));
				transaccion.setDepartamento(rs.getString("departamento"));
				transaccion.setServicio(rs.getString("nombre_servicio"));
				Transaccion.add(transaccion);
			}
			rs.close();
			pst.close();
			con.close();
			
		}catch(SQLException throwables) {
			throwables.printStackTrace();		
		}
		
		return Transaccion;
	}
	
	public List<TransaccionesEmpresa> TraerTransaccionesxfechas(java.sql.Date fecini,java.sql.Date fecfin) {
		String url = "jdbc:postgresql://localhost:5432/SistemaDePagos";
        String user = "postgres";
        String password = "postgres";
        String query = "select A.cod_transaccion,JUNTAR_FECHA_HORA(A.fecha_transaccion,A.hora_transaccion) as fecha, "
        		+ "A.monto_transaccion,A.tipo_pago,B.nombre_negocio,B.tipo_comercio,B.distrito,B.departamento, "
        		+ "A.nombre_servicio "
        		+ "from ( select A.*,B.nombre_servicio from ( "
        		+ "select A.*,B.tipo_pago,B.cod_servicio "
        		+ "from transaccion A left join pago B on A.cod_transaccion = B.cod_transaccion) A "
        		+ "left join servicio B on A.cod_servicio = B.cod_servicio ) A "
        		+ "left join (select * from negocio A left join comercio B on A.ruc = B.ruc_comercio) B "
        		+ "on A.ruc_comercio = B.ruc_comercio "
        		+ "where JUNTAR_FECHA_HORA(A.fecha_transaccion,A.hora_transaccion) between ? and ? "
        		+ " order by A.cod_transaccion desc";
        
        List<TransaccionesEmpresa> Transaccion = new ArrayList<TransaccionesEmpresa>();
        
		try (Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pst = con.prepareStatement(query)){
			
			pst.setDate(1, fecini);
			pst.setDate(2, fecfin);
			
			ResultSet rs = pst.executeQuery();  			
			while(rs.next()) {
				TransaccionesEmpresa transaccion = new TransaccionesEmpresa();
				transaccion.setCod(rs.getString("cod_transaccion"));
				transaccion.setFecha(rs.getString("fecha"));
				transaccion.setMonto(rs.getFloat("monto_transaccion"));
				transaccion.setTipopago(rs.getString("tipo_pago"));
				transaccion.setNombre(rs.getString("nombre_negocio"));
				transaccion.setTipocomercio(rs.getString("tipo_comercio"));
				transaccion.setDistrito(rs.getString("distrito"));
				transaccion.setDepartamento(rs.getString("departamento"));
				transaccion.setServicio(rs.getString("nombre_servicio"));
				Transaccion.add(transaccion);
			}
			rs.close();
			pst.close();
			con.close();
			
		}catch(SQLException throwables) {
			throwables.printStackTrace();		
		}
		
		return Transaccion;
	}



	
}
