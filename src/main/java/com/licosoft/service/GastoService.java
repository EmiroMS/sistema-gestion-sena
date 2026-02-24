package com.licosoft.service;

import java.util.List;

import com.licosoft.entity.Gasto;

public interface GastoService {

	   Gasto crear(Gasto gasto);

	    List<Gasto> listar();

	    Gasto editar(Long id, Gasto gasto);

	    void eliminar(Long id); // Eliminación lógica
}
