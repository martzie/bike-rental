package com.martzie.bikerental.client.controller;

import com.martzie.bikerental.client.controller.dto.ClientDTO;
import com.martzie.bikerental.client.model.Client;

import java.util.List;
import java.util.stream.Collectors;

public class ClientDtoMapper {

    private ClientDtoMapper(){}

    public static List<ClientDTO> mapToClientDtos(List<Client> clients) {
        return clients.stream()
                .map(ClientDtoMapper::mapToClientDto)
                .collect(Collectors.toList());
    }

    private static ClientDTO mapToClientDto(Client client) {
        return ClientDTO.builder()
                .id(client.getId())
                .login(client.getLogin())
                .emailAddress(client.getEmailAddress())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .build();
    }
}
