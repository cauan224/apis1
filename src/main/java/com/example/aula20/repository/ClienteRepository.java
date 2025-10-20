package com.example.aula20.repository;

import com.example.aula20.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository <ClienteModel,Long > {
    Optional<ClienteModel>findByEmail(String email);
}
