package com.example.contacts_directory.models;

import jakarta.persistence.*;

@Entity
@Table(name = "clients_contacts")
public class ClientContact {
    @EmbeddedId
    private ClientContactId id;

    @ManyToOne
    @MapsId("clientId")
    private Client client;

    @ManyToOne
    @MapsId("contactId")
    private Contact contact;

    public ClientContactId getId() {
        return id;
    }

    public void setId(ClientContactId id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
