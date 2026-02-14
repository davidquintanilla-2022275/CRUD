package com.DavidQuintanilla.RepuestosAutomotrices.Controller;

import com.DavidQuintanilla.RepuestosAutomotrices.entity.Repuestos;
import com.DavidQuintanilla.RepuestosAutomotrices.Service.RepuestosService;
import jakarta.validation.Valid;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repuestos")
public class RepuestosController {

    private final RepuestosService repuestosService;

    public RepuestosController(RepuestosService repuestosService){
        this.repuestosService = repuestosService;
    }

    @GetMapping
    public List<Repuestos> getAllRepuestos(){
        return repuestosService.getallRepuestos();
    }

    @PostMapping
    public ResponseEntity<Object> createRepuestos(@Valid @RequestBody Repuestos repuestos){
        try{
            Repuestos createRepuesto = repuestosService.saveRepuestos(repuestos);
            return new ResponseEntity<>(createRepuesto, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRepuesto(@PathVariable Integer id) {
        try {
            repuestosService.deleteRepuestos(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRepuesto(
            @PathVariable Integer id,
            @RequestBody Repuestos repuestos) {

        Repuestos repuestoActualizado = repuestosService.updateRepuestos(id, repuestos);
        return ResponseEntity.ok(repuestoActualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getRepuestoById(@PathVariable Integer id) {
        try {
            Repuestos repuesto = repuestosService.getRepuestos(id);
            return ResponseEntity.ok(repuesto);
        } catch (ObjectNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
