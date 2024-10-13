package com.example.contacts_directory.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ClientContactId implements Serializable {
    private Long clientId;
    private Long contactId;

    public ClientContactId(Long clientId, Long contactId) {
        this.clientId = clientId;
        this.contactId = contactId;
    }

    public ClientContactId() {

    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientContactId that = (ClientContactId) o;
        return Objects.equals(clientId, that.clientId) && Objects.equals(contactId, that.contactId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, contactId);
    }
}
