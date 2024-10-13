package com.example.contacts_directory.controllers;

import com.example.contacts_directory.customExceptions.ClientNotFoundException;
import com.example.contacts_directory.customExceptions.NoClientOrContactException;
import com.example.contacts_directory.customExceptions.TheClientListsIEmptyException;
import com.example.contacts_directory.models.Client;
import com.example.contacts_directory.models.Contact;
import com.example.contacts_directory.models.ContactType;
import com.example.contacts_directory.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<String> addClient(@RequestBody Client client) {
        clientService.addClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body("Клиент успешно создан");
    }

    @PostMapping("/{clientId}/contacts")
    public ResponseEntity<String> addContact(@PathVariable Long clientId, @RequestBody Contact contact) {
        clientService.addContact(clientId, contact);
        return ResponseEntity.status(HttpStatus.CREATED).body("Контакт успешно добавлен клиенту");
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @GetMapping("/{clientId}/contacts")
    public ResponseEntity<List<Contact>> getContactsByClientId(@PathVariable Long clientId) {
        return ResponseEntity.ok(clientService.getContactsByClientId(clientId));
    }

    @GetMapping("/{clientId}/contacts/type/{type}")
    public ResponseEntity<List<Contact>> getContactsByType(@PathVariable Long clientId, @PathVariable ContactType type) {
        return ResponseEntity.ok(clientService.getContactsByType(clientId, type));
    }

    @ExceptionHandler
    public ResponseEntity<String> notFoundException(ClientNotFoundException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Клиент не найден");
    }

    @ExceptionHandler
    public ResponseEntity<String> notFoundException(TheClientListsIEmptyException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Список клиентов пуст");
    }

    @ExceptionHandler
    public ResponseEntity<String> notFoundException(NoClientOrContactException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Клиент не найден или у него нет контактной информации");
    }


}
