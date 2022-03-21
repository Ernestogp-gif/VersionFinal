package com.example.pagos.dao;

import com.example.pagos.model.Transaccion;

public interface ModuloRecargadao {
	public abstract String ConfirmarRecarga(float monto, String ruc);
}
