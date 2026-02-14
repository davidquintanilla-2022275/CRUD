package com.DavidQuintanilla.RepuestosAutomotrices.Controller;

import com.DavidQuintanilla.RepuestosAutomotrices.entity.Ventas;
import com.DavidQuintanilla.RepuestosAutomotrices.Service.VentaService;
import jakarta.validation.Valid;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentasController {

    private final VentaService ventaService;

    public VentasController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @GetMapping
    public List<Ventas> getAllVentas() {
        return ventaService.getAllVentas();
    }

    @PostMapping
    public ResponseEntity<Object> createVenta(@Valid @RequestBody Ventas ventas) {
        try {
            Ventas ventaCreada = ventaService.saveVenta(ventas);
            return new ResponseEntity<>(ventaCreada, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVenta(@PathVariable Integer id) {
        try {
            ventaService.deleteVenta(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateVenta(@PathVariable Integer id,
                                              @RequestBody Ventas ventas) {
        Ventas ventaActualizada = ventaService.updateVenta(id, ventas);
        return ResponseEntity.ok(ventaActualizada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getVentaById(@PathVariable Integer id) {
        try {
            Ventas venta = ventaService.getVenta(id);
            return ResponseEntity.ok(venta);
        } catch (ObjectNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
