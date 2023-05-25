package ru.sbt.synapse.reactproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.sbt.synapse.reactproject.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(nativeQuery = true, value = "select * from react_market.clients client where client.email = ?1")
    Optional<Client> findClientByEmail(String email);

    @Query(nativeQuery = true, value = "select * from react_market.clients clients")
    Optional<List<Client>> findAllClients();

    @Modifying
    @Query(nativeQuery = true, value = "insert into react_market.clients(email, name, surname, phone)" +
    " values (:email,:name,:surname,:phone)")
    void saveClient(@Param("email") String email, @Param("name") String name, @Param("surname") String surname,@Param("phone") String phone);

    @Modifying
    @Query(nativeQuery = true, value = "delete from react_market.clients client where client.email = ?1")
    void deleteClientByEmail(String email);

    @Modifying
    @Query(nativeQuery = true, value = "update react_market.clients set email=:email,name=:name,surname=:surname,phone=:phone where email =:email")
    void updateClientByEmail(@Param("email") String email, @Param("name") String name, @Param("surname") String surname,@Param("phone") String phone);

}
