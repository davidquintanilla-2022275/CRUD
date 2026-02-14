package com.DavidQuintanilla.RepuestosAutomotrices.Controller;

import com.DavidQuintanilla.RepuestosAutomotrices.entity.Proveedores;
import com.DavidQuintanilla.RepuestosAutomotrices.Service.ProveedorService;
import jakarta.validation.Valid;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")

public class ProveedoresController {

    private final ProveedorService proveedorService;

    public ProveedoresController(ProveedorService proveedorService){this.proveedorService = proveedorService;}

    @GetMapping
    public List<Proveedores> getAllProveedores(){return proveedorService.getallProveedores();}

    @PostMapping
    public ResponseEntity<Object>createProveedor(@Valid @RequestBody Proveedores proveedores){
        try{
            Proveedores createProveedores = proveedorService.saveProveedores(proveedores);
            return new ResponseEntity<>(createProveedores, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object>deleteProveedores(@PathVariable Integer id){
        try{
            proveedorService.deleteProveedores(id);
            return ResponseEntity.noContent().build();
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProveedores (@PathVariable Integer id , @RequestBody Proveedores proveedores){
        Proveedores proveedoresActualizar = proveedorService.updateProveedores(id, proveedores);
        return ResponseEntity.ok(proveedoresActualizar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProveedoresId(@PathVariable Integer id){
        try{
            Proveedores proveedores = proveedorService.getProveedores(id);
            return ResponseEntity.ok(proveedores);
        }catch (ObjectNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }


}
