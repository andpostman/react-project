package ru.sbt.synapse.reactproject.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sbt.synapse.reactproject.model.Client;

import java.util.List;

@FeignClient(value = "client-page", url = "${main-page.url}")
@RequestMapping("/clients")
public interface UserClient {

    @GetMapping("/{email}")
    Client getClient(@PathVariable("email") String email);

    @GetMapping
    List<Client> getClients();

}
