package com.example.springdemo.controllers;

import com.example.springdemo.dto.request.UpdateClientRequest;
import com.example.springdemo.dto.response.ClientDTO;
import com.example.springdemo.dto.request.CreateClientRequest;
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
    public List<ClientDTO> get(){
        return clientService.get();
    }

    @GetMapping("/{id}")
    public ClientDTO getById(@PathVariable Long id) {
        return clientService.getById(id)
                .orElse(null);
    }

    @PostMapping
    public ClientDTO post(@RequestBody @Valid CreateClientRequest request) {
        return clientService.post(request);
    }

    @PutMapping("/{id}")
    public ClientDTO update(
            @PathVariable Long id,
            @RequestBody @Valid UpdateClientRequest request
            ) {
        return clientService.update(id, request)
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        boolean deleted = clientService.delete(id);

        if (deleted) {
            return "Client Deleted Successfully";
        }

        return "Client not found";

        /**
        return clientService.deleteClient(id)
                ? "Client Deleted Successfully"
                : "Client not found";
         **/
    }
}
