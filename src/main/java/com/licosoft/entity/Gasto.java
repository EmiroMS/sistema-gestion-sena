package com.licosoft.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "gastos")
public class Gasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    private Double monto;

    private LocalDate fecha;

    // NOMINA, SERVICIOS, ARRIENDO, OTROS
    private String tipo;

    private Boolean activo = true;

    // =====================================
    // ✅ FECHA AUTOMÁTICA
    // =====================================
    @PrePersist
    public void asignarFecha() {

        if (this.fecha == null) {
            this.fecha = LocalDate.now();
        }
    }
}