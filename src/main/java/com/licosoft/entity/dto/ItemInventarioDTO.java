package com.licosoft.entity.dto;

import lombok.Data;

@Data
public class ItemInventarioDTO {

	private Long productoId;
    private Integer cantidad;
    private Double costoUnitario;
}
