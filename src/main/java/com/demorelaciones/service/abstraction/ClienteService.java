package com.demorelaciones.service.abstraction;

import com.demorelaciones.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ClienteService {
    Cliente getCliente(Long clienteId);
    List<Cliente> getAllClientes();
    Cliente createCliente(Cliente cliente);
    Cliente updateCliente(Long clienteID, Cliente cliente);
    void deleteCliente(Long clienteId);
}
