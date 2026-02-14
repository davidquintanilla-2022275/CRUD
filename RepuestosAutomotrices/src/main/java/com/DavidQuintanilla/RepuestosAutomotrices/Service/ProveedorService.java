package com.DavidQuintanilla.RepuestosAutomotrices.Service;

import com.DavidQuintanilla.RepuestosAutomotrices.entity.Proveedores;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface ProveedorService {
    List<Proveedores> getallProveedores();
    Proveedores getProveedores(Integer id);
    Proveedores saveProveedores (Proveedores proveedores) throws RuntimeException;
    Proveedores updateProveedores (Integer id, Proveedores proveedores);
    void deleteProveedores (Integer id);
}
