package com.demorelaciones.service.impl;

import com.demorelaciones.model.Cliente;
import com.demorelaciones.repository.ClienteRepository;
import com.demorelaciones.service.abstraction.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente getCliente(Long clienteId) {
        return clienteRepository.findById(clienteId).orElseThrow(() -> new EntityNotFoundException("El cliente con id: " + clienteId + " no existe en base de datos"));
    }

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        Cliente clienteSave = new Cliente();
        clienteSave.setNickName(cliente.getNickName());
        clienteSave.setMail(cliente.getMail());
        clienteSave.setProfile(cliente.getProfile());
        return clienteRepository.save(clienteSave);
    }

    @Override
    public Cliente updateCliente(Long clienteId, Cliente cliente) {
        Cliente clienteUpdate = clienteRepository.findById(clienteId).orElseThrow(() -> new EntityNotFoundException("El cliente con id: " + clienteId + " no existe en base de datos"));
        if (clienteUpdate != null){
            clienteUpdate.setMail(cliente.getMail());
          clienteUpdate.setNickName(cliente.getNickName());
          clienteUpdate.setProfile(cliente.getProfile());
          clienteRepository.save(clienteUpdate);
          return clienteUpdate;
        }
        return null;
    }

    @Override
    public void deleteCliente(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }
}
