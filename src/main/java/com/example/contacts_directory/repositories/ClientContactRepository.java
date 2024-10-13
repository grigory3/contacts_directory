package com.example.contacts_directory.repositories;

import com.example.contacts_directory.models.ClientContact;
import com.example.contacts_directory.models.ClientContactId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientContactRepository extends JpaRepository<ClientContact, ClientContactId> {

}
