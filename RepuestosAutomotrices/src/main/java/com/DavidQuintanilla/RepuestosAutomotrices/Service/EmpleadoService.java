package com.DavidQuintanilla.RepuestosAutomotrices.Service;

import com.DavidQuintanilla.RepuestosAutomotrices.entity.Empleado;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface EmpleadoService {
    List<Empleado> getAllEmpleados();
    Empleado getEmpleadoById(Integer id);
    Empleado saveEmpleado (Empleado empleado) throws RuntimeException;
    Empleado updateEmpleado (Integer id, Empleado empleado);
    void daleteEmpleado (Integer id);
}
