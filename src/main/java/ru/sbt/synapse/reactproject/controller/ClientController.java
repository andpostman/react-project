package ru.sbt.synapse.reactproject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.sbt.synapse.reactproject.dto.ClientProperties;
import ru.sbt.synapse.reactproject.model.Client;
import ru.sbt.synapse.reactproject.service.impl.ClientServiceImpl;
import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
@Slf4j
public class ClientController {

    private final ClientServiceImpl service;

    @GetMapping()
    public List<Client> getClients(){
        return service.getAllClients();
    }

    @GetMapping("/{email}")
    public Client getClient(@PathVariable("email") String email){
        return service.getClientByEmail(email);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@RequestBody ClientProperties client){
        service.createClient(client);
        return getClient(client.getEmail());
    }

    @PutMapping("/{email}")
    public Client updateClient(@PathVariable("email") String email, @RequestBody ClientProperties client ){
        service.updateClient(client);
        return getClient(client.getEmail());
    }

    @DeleteMapping("/{email}")
    public List<Client> deleteClient(@PathVariable("email") String email){
        service.deleteClient(email);
        return getClients();
    }

}
