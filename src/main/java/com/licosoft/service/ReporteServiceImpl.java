package com.licosoft.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.licosoft.entity.DetalleVenta;
import com.licosoft.entity.Venta;
import com.licosoft.entity.dto.GananciaDTO;
import com.licosoft.repository.GastoRepository;
import com.licosoft.repository.VentaRepository;

@Service
public class ReporteServiceImpl implements ReporteService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private GastoRepository gastoRepository;

    @Override
    public GananciaDTO calcularGanancia(
            LocalDate fechaInicio,
            LocalDate fechaFin) {

        LocalDateTime inicio = fechaInicio.atStartOfDay();
        LocalDateTime fin = fechaFin.atTime(23, 59, 59);

        List<Venta> ventas =
                ventaRepository.findByFechaBetween(inicio, fin);

        double totalVentas = 0;
        double costoProductos = 0;

        for (Venta venta : ventas) {

            totalVentas += venta.getTotalFinal();

            for (DetalleVenta detalle : venta.getDetalles()) {

                costoProductos +=
                        detalle.getCantidad()
                        * detalle.getProducto().getPrecioCosto();
            }
        }

        Double gastos = gastoRepository
                .sumarGastosPorFecha(fechaInicio, fechaFin);

        if (gastos == null) {
            gastos = 0.0;
        }

        double utilidadBruta = totalVentas - costoProductos;
        double utilidadNeta = utilidadBruta - gastos;

        GananciaDTO dto = new GananciaDTO();
        dto.setTotalVentas(totalVentas);
        dto.setCostoProductos(costoProductos);
        dto.setUtilidadBruta(utilidadBruta);
        dto.setGastos(gastos);
        dto.setUtilidadNeta(utilidadNeta);

        return dto;
    }
}

