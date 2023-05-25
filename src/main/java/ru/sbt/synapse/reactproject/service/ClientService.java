package ru.sbt.synapse.reactproject.service;

import ru.sbt.synapse.reactproject.dto.ClientProperties;
import ru.sbt.synapse.reactproject.model.Client;

import java.util.List;

public interface ClientService {
    Client getClientByEmail(String email);
    List<Client> getAllClients();
    void createClient(ClientProperties client);
    void updateClient(ClientProperties client);
    void deleteClient(String email);
}
