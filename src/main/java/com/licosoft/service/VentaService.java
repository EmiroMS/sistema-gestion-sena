package com.licosoft.service;

import java.time.LocalDateTime;
import java.util.List;

import com.licosoft.entity.Venta;
import com.licosoft.entity.dto.VentaRequestDTO;

public interface VentaService {

	Venta registrarVenta(VentaRequestDTO ventaRequestDTO);
	
	List<Venta> listarVentas();
	
	List<Venta> listarVentasPorFecha(
	        LocalDateTime inicio,
	        LocalDateTime fin
	);
}
