package com.licosoft.entity.dto;

import java.util.List;

import lombok.Data;

@Data
public class VentaRequestDTO {

    private String cliente;

    private List<ItemVentaDTO> items;

}