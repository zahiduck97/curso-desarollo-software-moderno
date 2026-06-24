package com.example.springdemo.services;

import com.example.springdemo.dto.ClientDTO;
import com.example.springdemo.dto.ClientRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    // Simulacion DB
    private final List<ClientDTO> clientsDB = new ArrayList<>();
    private Long nextId = 1L;

    public ClientService(){
        clientsDB.add(new ClientDTO(
                nextId++,
                "Juan Perez",
                "juan@gmail.com",
                "5512345678"
        ));

        clientsDB.add(new ClientDTO(
                nextId++,
                "Ana Lopez",
                "ana@gmail.com",
                "559987642"
        ));
    }

    public List<ClientDTO> getClients() {
        return clientsDB;
    }

    public Optional<ClientDTO> getClientById(Long id) {
        return clientsDB.stream()
                .filter(client -> client.id().equals(id))
                .findFirst();
    }

    public ClientDTO postClient(ClientRequest request){
        ClientDTO newClient = new ClientDTO(
                nextId++,
                request.name(),
                request.email(),
                request.phone()
        );

        clientsDB.add(newClient);

        return newClient;
    }
}
