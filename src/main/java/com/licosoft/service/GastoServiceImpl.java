package com.licosoft.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.licosoft.entity.Gasto;
import com.licosoft.repository.GastoRepository;

@Service
public class GastoServiceImpl implements GastoService {

    @Autowired
    private GastoRepository gastoRepository;

    @Override
    public Gasto crear(Gasto gasto) {

        if (gasto.getFecha() == null) {
            gasto.setFecha(LocalDate.now());
        }

        gasto.setActivo(true);
        return gastoRepository.save(gasto);
    }

    @Override
    public List<Gasto> listar() {
        return gastoRepository.findByActivoTrue();
    }

    @Override
    public Gasto editar(Long id, Gasto gasto) {

        Gasto existente = gastoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gasto no encontrado"));

        existente.setDescripcion(gasto.getDescripcion());
        existente.setMonto(gasto.getMonto());
        existente.setTipo(gasto.getTipo());
        existente.setFecha(gasto.getFecha());

        return gastoRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {

        Gasto gasto = gastoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gasto no encontrado"));

        gasto.setActivo(false);
        gastoRepository.save(gasto);
    }
}