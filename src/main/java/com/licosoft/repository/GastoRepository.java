package com.licosoft.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.licosoft.entity.Gasto;

public interface GastoRepository extends JpaRepository<Gasto, Long> {

	List<Gasto> findByActivoTrue();
	
    @Query("""
        SELECT SUM(g.monto)
        FROM Gasto g
        WHERE g.fecha BETWEEN :inicio AND :fin
    """)
    Double sumarGastosPorFecha(
        @Param("inicio") LocalDate inicio,
        @Param("fin") LocalDate fin
    );
}
