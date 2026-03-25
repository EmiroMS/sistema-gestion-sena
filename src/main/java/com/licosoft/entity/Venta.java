package com.licosoft.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Numero de factura POS

    private LocalDateTime fecha; // Fecha de la venta

    private Double totalSinDescuento; // subtotal

    private Double descuento; // descuento aplicado

    private Double totalFinal; // total a pagar

    private Boolean activa = true;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<DetalleVenta> detalles;
    
    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

}