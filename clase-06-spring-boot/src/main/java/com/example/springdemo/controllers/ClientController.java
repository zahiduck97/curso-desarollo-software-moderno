package com.example.springdemo.controllers;

import com.example.springdemo.dto.ClientDTO;
import com.example.springdemo.dto.ClientRequest;
import com.example.springdemo.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(
            ClientService clientService
    ){
        this.clientService = clientService;
    }

    // Routes

    @GetMapping
    public List<ClientDTO> getClients(){
        return clientService.getClients();
    }

    @GetMapping("/{id}")
    public ClientDTO getClientById(@PathVariable Long id) {
        return clientService.getClientById(id)
                .orElse(null);
    }

    @PostMapping
    public ClientDTO postClient(@RequestBody @Valid ClientRequest request) {
        return clientService.postClient(request);
    }
}
