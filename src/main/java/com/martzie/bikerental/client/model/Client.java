package com.martzie.bikerental.client.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String login;
    private String firstName;
    private String lastName;

    @Email
    @Column(unique = true, nullable = false)
    private String emailAddress;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "client_id")
    private List<Address> addresses = new ArrayList<>();

    @Tolerate
    public Client(){}
}
