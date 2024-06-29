package com.demorelaciones.service.impl;

import com.demorelaciones.model.Cliente;
import com.demorelaciones.model.Factura;
import com.demorelaciones.model.Producto;
import com.demorelaciones.repository.ClienteRepository;
import com.demorelaciones.repository.FacturaRepository;
import com.demorelaciones.repository.ProductoRepository;
import com.demorelaciones.service.abstraction.FacturaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FacturaServiceImpl implements FacturaService {
    private final FacturaRepository facturaRepository;
    private final ClienteRepository clienteRepository;
    private final ProductoRepository productoRepository;
    @Override
    public Factura getFacturaById(Long facturaId) {
        return facturaRepository.findById(facturaId).orElseThrow(() -> new EntityNotFoundException("La factura no fue encontrada"));
    }

    @Override
    public List<Factura> getAllFacturas() {
        return facturaRepository.findAll();
    }

    @Override
    public Factura createFactura(Factura factura) {
        Factura facturaSave = new Factura();
        Cliente cliente = clienteRepository.findById(factura.getCliente().getId())
                .orElseThrow(() -> new EntityNotFoundException("El cliente con id: " + factura.getCliente().getId() + " no existe en base de datos"));
        facturaSave.setCliente(cliente);
        for (Producto prod : factura.getProductos()) {
            Optional<Producto> producto = productoRepository.findById(prod.getId());
            producto.ifPresent(value -> facturaSave.getProductos().add(value));
        }
        return facturaRepository.save(facturaSave);
    }

    @Override
    public Factura updateFactura(Long facturaId, Factura factura) {
        return null;
    }

    @Override
    public void deleteFactura(Long facturaId) {

    }
}
