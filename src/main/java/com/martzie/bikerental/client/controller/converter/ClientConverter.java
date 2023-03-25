package com.martzie.bikerental.client.controller.converter;

import com.martzie.bikerental.client.controller.dto.ClientRequest;
import com.martzie.bikerental.client.controller.dto.ClientResponse;
import com.martzie.bikerental.client.model.Client;

import java.util.List;
import java.util.stream.Collectors;

public class ClientConverter {

    private ClientConverter(){}

    public static Client mapToClientEntity(ClientRequest request) {
        return Client.builder()
                .emailAddress(request.getEmailAddress())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .street(request.getStreet())
                .streetNumber(request.getStreetNumber())
                .city(request.getCity())
                .postcode(request.getPostcode())
                .phoneNumber(request.getPhoneNumber())
                .isActive(true)
                .build();
    }

    public static List<ClientResponse> mapToClientResponses(List<Client> clients) {
        return clients.stream()
                .map(ClientConverter::mapToClientResponse)
                .collect(Collectors.toList());
    }

    public static ClientResponse mapToClientResponse(Client client) {
        return ClientResponse.builder()
                .id(client.getId())
                .emailAddress(client.getEmailAddress())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .build();
    }
}
