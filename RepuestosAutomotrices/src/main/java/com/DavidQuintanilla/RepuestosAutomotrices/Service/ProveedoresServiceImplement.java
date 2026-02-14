package com.DavidQuintanilla.RepuestosAutomotrices.Service;

import com.DavidQuintanilla.RepuestosAutomotrices.entity.Proveedores;
import com.DavidQuintanilla.RepuestosAutomotrices.Repository.ProvedoresRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedoresServiceImplement implements ProveedorService {

    private final ProvedoresRepository provedoresRepository;

    public ProveedoresServiceImplement(ProvedoresRepository provedoresRepository) {
        this.provedoresRepository = provedoresRepository;
    }

    @Override
    public List<Proveedores> getallProveedores() {
        return provedoresRepository.findAll();
    }

    @Override
    public Proveedores getProveedores(Integer id) {
        return provedoresRepository.findById(id).orElse(null) ;
    }

    @Override
    public Proveedores saveProveedores(Proveedores proveedores) {
        return provedoresRepository.save(proveedores);
    }

    @Override
    public Proveedores updateProveedores(Integer id, Proveedores proveedoresDetalles) {

        Proveedores proveedoresExistente = provedoresRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Proveedor no encontrado con id " + id));

        proveedoresExistente.setNombreProveedor(proveedoresDetalles.getNombreProveedor());
        proveedoresExistente.setTelefonoProveedor(proveedoresDetalles.getTelefonoProveedor());
        proveedoresExistente.setDireccionProveedor(proveedoresDetalles.getDireccionProveedor());
        proveedoresExistente.setEmailProveedor(proveedoresDetalles.getEmailProveedor());

        return provedoresRepository.save(proveedoresExistente);
    }

    @Override
    public void deleteProveedores(Integer id) {
        provedoresRepository.deleteById(id);
    }
}
