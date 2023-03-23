package com.martzie.bikerental.client.repository;

import com.martzie.bikerental.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long > {

    Boolean existsByEmailAddressIgnoreCase(String emailAddress);

}
