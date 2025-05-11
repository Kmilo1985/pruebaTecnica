package com.api.pruebatecnica.crud.controller;

import com.api.pruebatecnica.crud.model.Cliente;
import com.api.pruebatecnica.crud.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<Cliente> getCliente(
            @RequestParam String tipo,
            @RequestParam String numero) {
        Cliente c = service.buscarPorDocumento(tipo, numero);
        return ResponseEntity.ok(c);
    }
}