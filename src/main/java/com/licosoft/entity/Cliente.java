package com.licosoft.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String nombre;

    private String telefono;

    private Boolean activo = true;
}