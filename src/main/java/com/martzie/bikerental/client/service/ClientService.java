package com.martzie.bikerental.client.service;

import com.martzie.bikerental.client.exception.ClientNotFoundException;
import com.martzie.bikerental.client.exception.IncorrectEmailException;
import com.martzie.bikerental.client.exception.UserAlreadyExistsException;
import com.martzie.bikerental.client.model.Client;
import com.martzie.bikerental.client.repository.ClientRepository;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client addClient(Client client) {
        if (clientRepository.existsByEmailAddressIgnoreCase(client.getEmailAddress())
                || clientRepository.existsByLoginIgnoreCase(client.getLogin())){
            throw new UserAlreadyExistsException();
        }
        try {
            return clientRepository.save(client);
        } catch (ConstraintViolationException e){
            throw new IncorrectEmailException(client.getEmailAddress());
        }
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client findById(long id) {
        return clientRepository.findById(id).orElseThrow(()-> new ClientNotFoundException(id));
    }
    @Transactional
    public Client updateClient(long id, Client client) {
        Client persistentClient = clientRepository
                .findById(id).orElseThrow(() -> new ClientNotFoundException(client.getId()));
        persistentClient.setEmailAddress(client.getEmailAddress());
        persistentClient.setFirstName(client.getFirstName());
        persistentClient.setLastName(client.getLastName());
        return persistentClient;
    }

    public void deleteClient(long id) {
        clientRepository.deleteById(id);
    }
}
