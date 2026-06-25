package com.example.springdemo.services;

import com.example.springdemo.dto.request.UpdateClientRequest;
import com.example.springdemo.dto.response.ClientDTO;
import com.example.springdemo.dto.request.CreateClientRequest;
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

    public List<ClientDTO> get() {
        return clientsDB;
    }

    public Optional<ClientDTO> getById(Long id) {
        return clientsDB.stream()
                .filter(client -> client.id().equals(id))
                .findFirst();
    }

    public ClientDTO post(CreateClientRequest request){
        ClientDTO newClient = new ClientDTO(
                nextId++,
                request.name(),
                request.email(),
                request.phone()
        );

        clientsDB.add(newClient);

        return newClient;
    }

    public Optional<ClientDTO> update(Long id, UpdateClientRequest request) {
        Optional<ClientDTO> client = getById(id);

        if (client.isEmpty()) {
            return Optional.empty();
        }

        ClientDTO clientUpdated = new ClientDTO(
                id,
                request.name(),
                request.email(),
                client.get().phone()
        );

        clientsDB.removeIf(cliente -> cliente.id().equals(id));
        clientsDB.add(clientUpdated);

        return Optional.of(clientUpdated);

    }

    public boolean delete(Long id) {
        return clientsDB.removeIf(cliente -> cliente.id().equals(id));
    }
}
