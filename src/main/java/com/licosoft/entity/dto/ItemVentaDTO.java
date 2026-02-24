package com.licosoft.entity.dto;

import lombok.Data;

@Data
public class ItemVentaDTO {

	private Long productoId;
	private Integer cantidad;
	private Double totalVendido; // 👈 TOTAL, no unitario
}
