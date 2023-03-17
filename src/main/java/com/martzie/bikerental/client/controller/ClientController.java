package com.martzie.bikerental.client.controller;

import com.martzie.bikerental.client.controller.dto.ClientDTO;
import com.martzie.bikerental.client.model.Client;
import com.martzie.bikerental.client.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping(value = "/clients")
    public Client addClient(@RequestBody Client client){
        return clientService.addClient(client);
    }

    @GetMapping(value = "/clients")
    public List<ClientDTO> getClients(){
        return ClientDtoMapper.mapToClientDtos(clientService.getAllClients());
    }

    @GetMapping(value = "/clients/{id}")
    public Client getClientById(@PathVariable long id){
        return clientService.findById(id);
    }

    @PutMapping(value = "/clients/{id}")
    public Client updateClient(@PathVariable long id, @RequestBody Client client){
        return clientService.updateClient(id, client);
    }

    @DeleteMapping(value = "/clients/{id}")
    public void deleteClient(@PathVariable long id){
        clientService.deleteClient(id);
    }
}
