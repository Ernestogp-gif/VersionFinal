package com.example.pagos.dao;


import java.util.Date;
import java.util.List;

import com.example.pagos.model.*;

public interface ModuloConsultaEmpresadao {
	
	public abstract List<TransaccionesEmpresa> TraerTransacciones();
	public abstract List<TransaccionesEmpresa> TraerTransaccionesxfechas(java.sql.Date fecini,java.sql.Date fecfin);

}

