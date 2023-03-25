package com.martzie.bikerental.client.service;

import com.martzie.bikerental.client.controller.converter.ClientConverter;
import com.martzie.bikerental.client.controller.dto.ClientRequest;
import com.martzie.bikerental.client.controller.dto.ClientResponse;
import com.martzie.bikerental.client.exception.ClientNotFoundException;
import com.martzie.bikerental.client.exception.UserAlreadyExistsException;
import com.martzie.bikerental.client.model.Client;
import com.martzie.bikerental.client.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientResponse addClient(ClientRequest request) {
        checkEmail(request.getEmailAddress());
        Client perstistentClient = clientRepository.save(ClientConverter.mapToClientEntity(request));
        return ClientConverter.mapToClientResponse(perstistentClient);
    }

    public List<ClientResponse> getAllClients() {
        List<Client> allClients = clientRepository.findAll();
        return ClientConverter.mapToClientResponses(allClients);
    }

    public Client findById(long id) {
        return clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
    }

    @Transactional
    public void updateClient(long id, ClientRequest request) {
        checkEmail(request.getEmailAddress());
        Client persistentClient = findById(id);
        persistentClient.setEmailAddress(request.getEmailAddress());
        persistentClient.setFirstName(request.getFirstName());
        persistentClient.setLastName(request.getLastName());
        persistentClient.setCity(request.getCity());
        persistentClient.setPostcode(request.getPostcode());
        persistentClient.setStreet(request.getStreet());
        persistentClient.setPhoneNumber(request.getPhoneNumber());
    }

    @Transactional
    public void removeClient(long id) {
        Client clientToDelete = findById(id);
        clientRepository.delete(clientToDelete);
    }

    private void checkEmail(String email) {
        if (clientRepository.existsByEmailAddressIgnoreCase(email)) {
            throw new UserAlreadyExistsException();
        }
    }

    public ClientResponse getClientById(long id) {
        Client persistentResponse = findById(id);
        return ClientConverter.mapToClientResponse(persistentResponse);
    }
}
