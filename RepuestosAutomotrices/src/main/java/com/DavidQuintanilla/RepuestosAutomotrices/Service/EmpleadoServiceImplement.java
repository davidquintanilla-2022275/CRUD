package com.DavidQuintanilla.RepuestosAutomotrices.Service;

import com.DavidQuintanilla.RepuestosAutomotrices.entity.Empleado;
import com.DavidQuintanilla.RepuestosAutomotrices.Repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImplement implements EmpleadoService {
    private final EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImplement(EmpleadoRepository empleadoRepository){
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado getEmpleadoById(Integer id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    @Override
    public Empleado saveEmpleado(Empleado empleado) throws RuntimeException {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado updateEmpleado(Integer id, Empleado empleadoDetalles) {

        Empleado empleadoExistente = empleadoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado con id: " + id));

        empleadoExistente.setNombreEmpleado(empleadoDetalles.getNombreEmpleado());
        empleadoExistente.setApellidoEmpleado(empleadoDetalles.getApellidoEmpleado());
        empleadoExistente.setEmailEmpleado(empleadoDetalles.getEmailEmpleado());
        empleadoExistente.setPuestoEmpleado(empleadoDetalles.getPuestoEmpleado());

        return empleadoRepository.save(empleadoExistente);
    }


    @Override
    public void daleteEmpleado(Integer id) {
        empleadoRepository.deleteById(id);
    }
}

