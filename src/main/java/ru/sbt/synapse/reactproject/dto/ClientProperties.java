package ru.sbt.synapse.reactproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientProperties {
    private String email;
    private String name;
    private String surname;
    private String phone;
}
