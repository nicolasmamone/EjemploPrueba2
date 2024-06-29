package com.demorelaciones.service.abstraction;

import com.demorelaciones.model.Factura;

import java.util.List;

public interface FacturaService {
    Factura getFacturaById(Long facturaId);
    List<Factura> getAllFacturas();
    Factura createFactura(Factura factura);
    Factura updateFactura(Long facturaId, Factura factura);
    void deleteFactura(Long facturaId);
}
