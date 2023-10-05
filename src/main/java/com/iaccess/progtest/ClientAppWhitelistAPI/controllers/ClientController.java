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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iaccess.progtest.ClientAppWhitelistAPI.exceptions.ClientNotFoundException;
import com.iaccess.progtest.ClientAppWhitelistAPI.models.Client;
import com.iaccess.progtest.ClientAppWhitelistAPI.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping
	public List<Client> getAllClients() {
		return clientService.getAll();
	}

	@GetMapping("/{id}")
	public Client getClient(@PathVariable Long id) throws ClientNotFoundException {
		return clientService.get(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createClient(@RequestBody Client client) {
		clientService.save(client);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteClient(@PathVariable long id) {
		clientService.delete(id);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void updateClient(@RequestBody Client client) {
		clientService.update(client);
	}

}
