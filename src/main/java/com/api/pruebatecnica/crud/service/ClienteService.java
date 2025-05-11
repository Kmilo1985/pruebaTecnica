
package com.api.pruebatecnica.crud.service;

import com.api.pruebatecnica.crud.exception.BadRequestException;
import com.api.pruebatecnica.crud.model.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClienteService {
    public Cliente buscarPorDocumento(String tipo, String numero) {
        System.out.println("Tipo: " + tipo + ", Número: " + numero);
        if (tipo == null || numero == null || tipo.isBlank() || numero.isBlank()) {
            throw new BadRequestException("Tipo y número de documento son obligatorios");
        }
        if (!tipo.equals("C") && !tipo.equals("P")) {
            throw new BadRequestException("Tipo de documento inválido, solo C o P");
        }
        if (tipo.equals("C") && numero.equals("23445322")) {
            return new Cliente();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado");
    }
}