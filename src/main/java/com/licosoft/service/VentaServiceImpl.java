package com.licosoft.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.licosoft.entity.DetalleVenta;
import com.licosoft.entity.Producto;
import com.licosoft.entity.Venta;
import com.licosoft.entity.dto.ItemVentaDTO;
import com.licosoft.entity.dto.VentaRequestDTO;
import com.licosoft.exception.StockInsuficienteException;
import com.licosoft.repository.ProductoRepository;
import com.licosoft.repository.VentaRepository;

@Service
public class VentaServiceImpl implements VentaService {

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private VentaRepository ventaRepository;
	
    @Override
    public List<Venta> listarVentas() {
        return ventaRepository.findAll();
    }
    
    @Override
    public List<Venta> listarVentasPorFecha(
            LocalDateTime inicio,
            LocalDateTime fin) {

        return ventaRepository.findByFechaBetween(inicio, fin);
    }

	@Override
	public Venta registrarVenta(VentaRequestDTO dto) {

		Venta venta = new Venta();
		venta.setFecha(LocalDateTime.now());

		double totalSinDescuento = 0;
		double totalFinal = 0;
		double descuentoTotal = 0;

		List<DetalleVenta> detalles = new ArrayList<>();

		for (ItemVentaDTO item : dto.getItems()) {

			Producto producto = productoRepository.findById(item.getProductoId())
					.orElseThrow(() -> new RuntimeException("Producto no encontrado"));

			int cantidad = item.getCantidad();

			if (producto.getStock() < cantidad) {
				throw new StockInsuficienteException("Stock insuficiente para el producto: " + producto.getNombre());
			}

			double precioNormalUnitario = producto.getPrecioVenta();
			double totalNormal = precioNormalUnitario * cantidad;

			double totalVendido = item.getTotalVendido();

			if (totalVendido > totalNormal) {
				throw new RuntimeException("El total vendido no puede ser mayor al precio normal");
			}

			double precioUnitarioVendido = totalVendido / cantidad;
			double descuentoItem = totalNormal - totalVendido;

			totalSinDescuento += totalNormal;
			totalFinal += totalVendido;
			descuentoTotal += descuentoItem;

			// descontar stock
			producto.setStock(producto.getStock() - cantidad);
			productoRepository.save(producto);

			DetalleVenta detalle = new DetalleVenta();
			detalle.setProducto(producto);
			detalle.setCantidad(cantidad);
			detalle.setPrecioUnitario(precioNormalUnitario);
			detalle.setPrecioVendido(precioUnitarioVendido);
			detalle.setSubtotal(totalVendido);
			detalle.setVenta(venta);

			detalles.add(detalle);
		}

		venta.setTotalSinDescuento(totalSinDescuento);
		venta.setDescuento(descuentoTotal);
		venta.setTotalFinal(totalFinal);
		venta.setDetalles(detalles);

		return ventaRepository.save(venta);
	}

}
