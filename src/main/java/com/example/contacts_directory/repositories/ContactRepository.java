package com.example.contacts_directory.repositories;

import com.example.contacts_directory.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
