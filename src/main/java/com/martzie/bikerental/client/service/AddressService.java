package com.martzie.bikerental.client.service;

import com.martzie.bikerental.client.repository.ClientRepository;
import com.martzie.bikerental.client.exception.AddressNotFoundException;
import com.martzie.bikerental.client.exception.ClientNotFoundException;
import com.martzie.bikerental.client.model.Address;
import com.martzie.bikerental.client.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final ClientRepository clientRepository;

    public List<Address> getAddressesForClientById(long id) {
        Client client = getClient(id);
        return client.getAddresses();
    }

    private Client getClient(long id) {
        return clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
    }

    @Transactional
    public Client addAddressToClient(long id, Address address) {
        Client client = getClient(id);
        client.getAddresses().add(address);
        return client;
    }
    @Transactional
    public List<Address> updateAddress(long client_id, long address_id, Address newAddress) {
        Address editedAddress = findAddress(client_id, address_id);
        editedAddress.setCity(newAddress.getCity());
        editedAddress.setPostcode(newAddress.getPostcode());
        editedAddress.setStreet(newAddress.getStreet());
        editedAddress.setStreetNumber(newAddress.getStreetNumber());
        return getAddressesForClientById(client_id);
    }

    private Address findAddress(long client_id, long address_id) {
        List<Address> addressesForClientById = getAddressesForClientById(client_id);
        Address editedAddress = addressesForClientById.stream()
                .filter(address -> address.getId() == address_id)
                .findAny()
                .orElseThrow(AddressNotFoundException::new);
        return editedAddress;
    }

    @Transactional
    public void deleteAddress(long client_id, long address_id) {
        Client client = getClient(client_id);
        Address addressToDelete = findAddress(client_id, address_id);
        client.getAddresses().remove(addressToDelete);
    }
}
