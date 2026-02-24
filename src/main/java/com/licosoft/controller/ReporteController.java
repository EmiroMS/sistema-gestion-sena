package com.licosoft.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.licosoft.entity.dto.GananciaDTO;
import com.licosoft.service.ReporteService;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping("/ganancia")
    public ResponseEntity<GananciaDTO> obtenerGanancia(
            @RequestParam LocalDate inicio,
            @RequestParam LocalDate fin) {

        return ResponseEntity.ok(
                reporteService.calcularGanancia(inicio, fin)
        );
    }
}