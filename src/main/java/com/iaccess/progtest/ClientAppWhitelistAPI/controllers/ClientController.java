package com.iaccess.progtest.ClientAppWhitelistAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iaccess.progtest.ClientAppWhitelistAPI.models.Client;
import com.iaccess.progtest.ClientAppWhitelistAPI.services.ClientService;

@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping(path = "/clients")
	public List<Client> getAllClients() {
		return clientService.getAll();
	}

	@GetMapping(path = "/clients/{id}")
	public Client getClient(@PathVariable Long id) {
		return clientService.get(id);
	}

	@PostMapping(path = "/clients")
	@ResponseStatus(HttpStatus.CREATED)
	public void createClient(@RequestBody Client client) {
		clientService.save(client);
	}

	@DeleteMapping(path = "/clients/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteClient(@PathVariable long id) {
		clientService.delete(id);
	}

	@PutMapping(path = "/clients")
	@ResponseStatus(HttpStatus.OK)
	public void updateClient(@RequestBody Client client) {
		clientService.update(client);
	}

}
