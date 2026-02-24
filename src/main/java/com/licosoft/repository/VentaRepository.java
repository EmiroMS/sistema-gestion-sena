package com.licosoft.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.licosoft.entity.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {
	
	  List<Venta> findByFechaBetween(
		        LocalDateTime inicio,
		        LocalDateTime fin
		    );
}
