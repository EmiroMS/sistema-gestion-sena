package com.licosoft.service;

import java.time.LocalDate;

import com.licosoft.entity.dto.GananciaDTO;

public interface ReporteService {

	GananciaDTO calcularGanancia(LocalDate inicio, LocalDate fin);
}
