package ru.sbt.synapse.reactproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

@Entity
@Table(name = "clients", schema = "react_market")
@Getter
@NoArgsConstructor
public class Client {

    @Id
    private String email;

    @Column( name = "name")
    private String name;

    @Column( name = "surname")
    private String surname;

    @Column( name = "phone")
    private String phone;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("email", email)
                .append("name", name)
                .append("surname", surname)
                .append("phone", phone)
                .toString();
    }
}
