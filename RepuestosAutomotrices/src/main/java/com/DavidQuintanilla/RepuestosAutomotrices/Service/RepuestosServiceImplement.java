package com.DavidQuintanilla.RepuestosAutomotrices.Service;

import com.DavidQuintanilla.RepuestosAutomotrices.entity.Repuestos;
import com.DavidQuintanilla.RepuestosAutomotrices.Repository.RepuestosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepuestosServiceImplement implements RepuestosService {

    private final RepuestosRepository repuestosRepository;

    public RepuestosServiceImplement(RepuestosRepository repuestosRepository){
        this.repuestosRepository = repuestosRepository;
    }

    @Override
    public List<Repuestos> getallRepuestos(){
        return repuestosRepository.findAll();
    }

    @Override
    public Repuestos getRepuestos (Integer id){
        return repuestosRepository.findById(id).orElse(null);
    }

    @Override
    public Repuestos saveRepuestos (Repuestos repuestos){
        return repuestosRepository.save(repuestos);
    }

    @Override
    public Repuestos updateRepuestos(Integer id, Repuestos repuestosDetalles) {

        Repuestos repuestoExistente = repuestosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Repuesto no encontrado con id " + id));

        repuestoExistente.setNombreRepuesto(repuestosDetalles.getNombreRepuesto());
        repuestoExistente.setCategoriaRepuesto(repuestosDetalles.getCategoriaRepuesto());
        repuestoExistente.setPrecioCompra(repuestosDetalles.getPrecioCompra());
        repuestoExistente.setPrecioVenta(repuestosDetalles.getPrecioVenta());
        repuestoExistente.setIdProveedor(repuestosDetalles.getIdProveedor());

        return repuestosRepository.save(repuestoExistente);
    }

    @Override
    public void deleteRepuestos(Integer id) {
        repuestosRepository.deleteById(id);
    }
}
