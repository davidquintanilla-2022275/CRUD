package com.DavidQuintanilla.RepuestosAutomotrices.Controller;

import com.DavidQuintanilla.RepuestosAutomotrices.entity.Empleado;
import com.DavidQuintanilla.RepuestosAutomotrices.Service.EmpleadoService;
import jakarta.validation.Valid;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/empleados")

public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService){this.empleadoService = empleadoService;


    }
    @GetMapping
    public List<Empleado> getAllEmpleado(){return empleadoService.getAllEmpleados();}

    @PostMapping
    public ResponseEntity<Object> createEmpleado( @Valid @RequestBody Empleado empleado){
        try{
            Empleado createdEmpleado = empleadoService.saveEmpleado(empleado);
            return new ResponseEntity<>(createdEmpleado, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmpleado(@PathVariable Integer id){
        try {
            empleadoService.daleteEmpleado(id);
            return ResponseEntity.noContent().build();
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable Integer id, @RequestBody Empleado empleado) {
        Empleado empleadoActualizar = empleadoService.updateEmpleado(id, empleado);
        return ResponseEntity.ok(empleadoActualizar);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getEmpleadoId(@PathVariable Integer id){
        try{
            Empleado empleado = empleadoService.getEmpleadoById(id);
            return ResponseEntity.ok(empleado);
        }catch (ObjectNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

}
