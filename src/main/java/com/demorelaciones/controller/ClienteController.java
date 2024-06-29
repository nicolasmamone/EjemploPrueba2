package com.demorelaciones.controller;


import com.demorelaciones.model.Cliente;
import com.demorelaciones.service.abstraction.ClienteService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable Long clienteId){
        return new ResponseEntity<>(clienteService.getCliente(clienteId), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Cliente>> obtenerClientes(){
        return new ResponseEntity<>(clienteService.getAllClientes(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente){
        return new ResponseEntity<>(clienteService.createCliente(cliente), HttpStatus.CREATED);
    }
    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long clienteId, @RequestBody Cliente cliente){
        return new ResponseEntity<>(clienteService.updateCliente(clienteId, cliente), HttpStatus.OK);
    }
    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long clienteId){
        clienteService.deleteCliente(clienteId);
        return ResponseEntity.ok().build();
    }

}
