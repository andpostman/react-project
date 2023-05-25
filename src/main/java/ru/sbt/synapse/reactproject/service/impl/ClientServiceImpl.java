package ru.sbt.synapse.reactproject.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sbt.synapse.reactproject.dto.ClientProperties;
import ru.sbt.synapse.reactproject.exception.NotFoundClientException;
import ru.sbt.synapse.reactproject.model.Client;
import ru.sbt.synapse.reactproject.repository.ClientRepository;
import ru.sbt.synapse.reactproject.service.ClientService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    @Override
    public Client getClientByEmail(String email) {
        return repository.findClientByEmail(email).orElseThrow(NotFoundClientException::new);
    }

    @Override
    public List<Client> getAllClients() {
        return repository.findAllClients().orElseThrow(NotFoundClientException::new);
    }

    @Override
    public void createClient(ClientProperties client) {
        repository.saveClient(client.getEmail(),client.getName(), client.getSurname(), client.getPhone());
    }

    @Override
    public void updateClient(ClientProperties client) {
        repository.updateClientByEmail(client.getEmail(), client.getName(), client.getSurname(), client.getPhone());
    }

    @Override
    public void deleteClient(String email) {
        repository.deleteClientByEmail(email);
    }
}
