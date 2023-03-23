package com.martzie.bikerental.client.service;

import com.martzie.bikerental.client.controller.dto.ClientRequest;
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

    public Client addClient(Client client) {
        checkEmail(client.getEmailAddress());
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
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
    public void deactivateClient(long id) {
        Client deactivatedClient = findById(id);
        deactivatedClient.setIsActive(false);
    }

    private void checkEmail(String email) {
        if (clientRepository.existsByEmailAddressIgnoreCase(email)) {
            throw new UserAlreadyExistsException();
        }
    }
}
