package com.licosoft.entity.dto;

import java.util.List;

import lombok.Data;

@Data
public class VentaRequestDTO {

    private List<ItemVentaDTO> items;
    

    // getters y setters
}
