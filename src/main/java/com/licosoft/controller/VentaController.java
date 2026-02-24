package com.licosoft.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.licosoft.entity.Venta;
import com.licosoft.entity.dto.VentaRequestDTO;
import com.licosoft.service.VentaService;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

	@Autowired
	private VentaService ventaService;

	@GetMapping
	public ResponseEntity<List<Venta>> listarVentas() {
		return ResponseEntity.ok(ventaService.listarVentas());
	}

	@GetMapping("/filtrar")
	public ResponseEntity<List<Venta>> filtrarVentas(@RequestParam String fechaInicio, @RequestParam String fechaFin) {

		LocalDateTime inicio = LocalDate.parse(fechaInicio).atStartOfDay();

		LocalDateTime fin = LocalDate.parse(fechaFin).atTime(23, 59, 59);

		return ResponseEntity.ok(ventaService.listarVentasPorFecha(inicio, fin));
	}

	@PostMapping
	public ResponseEntity<Venta> registrarVenta(@RequestBody VentaRequestDTO dto) {
		return ResponseEntity.ok(ventaService.registrarVenta(dto));
	}
}
