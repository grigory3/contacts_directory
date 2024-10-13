package com.example.contacts_directory.service;

import com.example.contacts_directory.customExceptions.ClientNotFoundException;
import com.example.contacts_directory.customExceptions.NoClientOrContactException;
import com.example.contacts_directory.customExceptions.TheClientListsIEmptyException;
import com.example.contacts_directory.models.*;
import com.example.contacts_directory.repositories.ClientContactRepository;
import com.example.contacts_directory.repositories.ClientRepository;
import com.example.contacts_directory.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ClientContactRepository clientContactRepository;

    public void addClient(Client client) {
        clientRepository.save(client);
    }

    public void addContact(Long clientId, Contact contact) {
        Client client = clientRepository.findById(clientId).orElseThrow(ClientNotFoundException::new);
        contact = contactRepository.save(contact);

        ClientContact clientContact = new ClientContact();
        ClientContactId id = new ClientContactId(client.getId(), contact.getId());
        clientContact.setId(id);
        clientContact.setClient(client);
        clientContact.setContact(contact);

        clientContactRepository.save(clientContact);
    }

    public List<Client> getAllClients() {
        if (clientRepository.findAll().isEmpty()) {
            throw new TheClientListsIEmptyException();
        } else {
            return clientRepository.findAll();
        }
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
    }

    public List<Contact> getContactsByClientId(Long clientId) {
        List<Contact> contacts = clientContactRepository.findAll()
                .stream()
                .filter(clientContact -> clientContact.getClient().getId().equals(clientId))
                .map(ClientContact::getContact)
                .collect(Collectors.toList());

        if (contacts.isEmpty()) {
            throw new NoClientOrContactException();
        } else return contacts;
    }

    public List<Contact> getContactsByType(Long clientId, ContactType type) {
        List<Contact> contacts = clientContactRepository.findAll()
                .stream()
                .filter(clientContact -> clientContact.getClient().getId().equals(clientId) &&
                        clientContact.getContact().getType() == type)
                .map(ClientContact::getContact)
                .collect(Collectors.toList());

        if (contacts.isEmpty()) {
            throw new NoClientOrContactException();
        } else return contacts;
    }
}

