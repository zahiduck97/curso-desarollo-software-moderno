package com.example.springdemo.services;

import com.example.springdemo.dto.request.UpdateClientRequest;
import com.example.springdemo.dto.response.ClientDTO;
import com.example.springdemo.dto.request.CreateClientRequest;
import com.example.springdemo.entities.Client;
import com.example.springdemo.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;


    public ClientService(
            ClientRepository clientRepository
    ){
        this.clientRepository = clientRepository;
    }

    public List<ClientDTO> get() {
        return clientRepository.findAll()
                .stream()
                //.map(client -> convert(client))
                .map(this::convert)
                .toList();
    }

    public Optional<ClientDTO> getById(Long id) {
        return clientRepository.findById(id)
                .map(this::convert);
    }

    public ClientDTO post(CreateClientRequest request){
        Client client = Client.builder()
                .name(request.name())
                .email(request.email())
                .phone(request.phone())
                .build();

        Client clientSaved = clientRepository.save(client);

        return convert(clientSaved);
    }

    public Optional<ClientDTO> update(Long id, UpdateClientRequest request) {
        return clientRepository.findById(id)
                .map( client -> {
                    client.setName(request.name());
                    client.setEmail(request.email());
                    //client.setPhone(client.getPhone());

                    Client clientUpdated = clientRepository.save(client);

                    return convert(clientUpdated);
                });

    }

    public boolean delete(Long id) {
        if(!clientRepository.existsById(id)) {
            return false;
        }

        clientRepository.deleteById(id);

        return true;
    }

    private ClientDTO convert(Client client) {
        return new ClientDTO(
                client.getId(),
                client.getName(),
                client.getEmail(),
                client.getPhone()
        );
    }
}
