package com.example.contacts_directory.repositories;

import com.example.contacts_directory.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
