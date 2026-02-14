package com.DavidQuintanilla.RepuestosAutomotrices.Service;

import com.DavidQuintanilla.RepuestosAutomotrices.entity.Ventas;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface VentaService {
    List<Ventas> getAllVentas();
    Ventas getVenta(Integer id);
    Ventas saveVenta(Ventas ventas) throws RuntimeException;
    Ventas updateVenta(Integer id, Ventas ventas);
    void deleteVenta(Integer id);
}
