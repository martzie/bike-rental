package com.martzie.bikerental.client.controller;

import com.martzie.bikerental.client.controller.dto.ClientRequest;
import com.martzie.bikerental.client.controller.dto.ClientResponse;
import com.martzie.bikerental.client.service.ClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Clients")
@RequestMapping("/clients")
@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ClientResponse addClient(@RequestBody @Valid ClientRequest request) {
        return clientService.addClient(request);
    }

    @GetMapping
    public List<ClientResponse> getClients(){
        return clientService.getAllClients();
    }

    @GetMapping(value = "/{id}")
    public ClientResponse getClientById(@PathVariable long id) {
        return clientService.getClientById(id);
    }

    @PutMapping(value = "/{id}")
    public void updateClient(@PathVariable long id, @RequestBody ClientRequest request) {
        clientService.updateClient(id, request);
    }

    @DeleteMapping(value = "/{id}")
    public void removeClient(@PathVariable long id) {
        clientService.removeClient(id);
    }
}
