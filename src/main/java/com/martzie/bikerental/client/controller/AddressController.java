package com.martzie.bikerental.client.controller;

import com.martzie.bikerental.client.model.Address;
import com.martzie.bikerental.client.model.Client;
import com.martzie.bikerental.client.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/clients/{id}/addresses")
    public List<Address> getAllClientAddress(@PathVariable long id){
        return addressService.getAddressesForClientById(id);
    }

    @PostMapping("/clients/{id}/addresses")
    public Client addAddress(@PathVariable long id, @RequestBody Address address){
        return addressService.addAddressToClient(id, address);
    }

    @PutMapping("/clients/{client_id}/addresses/{address_id}")
    public List<Address> updateAddress(@PathVariable long client_id, @PathVariable long address_id, @RequestBody Address address){
        return addressService.updateAddress(client_id, address_id, address);
    }

    @DeleteMapping("/clients/{client_id}/addresses/{address_id}")
    public void deleteAddress(@PathVariable long client_id, @PathVariable long address_id){
        addressService.deleteAddress(client_id, address_id);
    }
}
