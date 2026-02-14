package com.DavidQuintanilla.RepuestosAutomotrices.Service;

import com.DavidQuintanilla.RepuestosAutomotrices.entity.Ventas;
import com.DavidQuintanilla.RepuestosAutomotrices.Repository.VentasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

@Service
public class VentasServiceImplement implements VentaService {

    private final VentasRepository ventasRepository;

    public VentasServiceImplement(VentasRepository ventasRepository){
        this.ventasRepository = ventasRepository;
    }

    @Override
    public List<Ventas> getAllVentas() {
        return ventasRepository.findAll();
    }

    @Override
    public Ventas getVenta(Integer id) {
        return ventasRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Venta no encontrada con id " + id));
    }

    @Override
    public Ventas saveVenta(Ventas venta) {
        venta.setFechaVenta(new Date());
        return ventasRepository.save(venta);
    }

    @Override
    public Ventas updateVenta(Integer id, Ventas ventaDetalles) {

        Ventas ventaExistente = ventasRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Venta no encontrada con id " + id));

        ventaExistente.setFechaVenta(ventaDetalles.getFechaVenta());
        ventaExistente.setCantidad(ventaDetalles.getCantidad());
        ventaExistente.setTotal(ventaDetalles.getTotal());
        ventaExistente.setIdEmpleado(ventaDetalles.getIdEmpleado());
        ventaExistente.setIdRepuesto(ventaDetalles.getIdRepuesto());

        return ventasRepository.save(ventaExistente);
    }

    @Override
    public void deleteVenta(Integer id) {
        ventasRepository.deleteById(id);
    }

}
