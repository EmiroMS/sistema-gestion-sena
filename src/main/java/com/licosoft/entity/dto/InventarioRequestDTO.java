package com.licosoft.entity.dto;

import java.util.List;

import lombok.Data;

@Data
public class InventarioRequestDTO {

	 private String tipo; // ENTRADA | AJUSTE
	    private String observacion;
	    private List<ItemInventarioDTO> items;
}
