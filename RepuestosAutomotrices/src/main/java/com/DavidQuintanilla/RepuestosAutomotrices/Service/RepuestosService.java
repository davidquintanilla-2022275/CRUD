package com.DavidQuintanilla.RepuestosAutomotrices.Service;

import com.DavidQuintanilla.RepuestosAutomotrices.entity.Repuestos;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface RepuestosService {
    List<Repuestos> getallRepuestos();
    Repuestos getRepuestos (Integer id);
    Repuestos saveRepuestos (Repuestos repuestos) throws RuntimeException;
    Repuestos updateRepuestos (Integer id, Repuestos repuestos );
    void deleteRepuestos (Integer id);
}
