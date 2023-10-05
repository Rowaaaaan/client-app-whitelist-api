package com.iaccess.progtest.ClientAppWhitelistAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaccess.progtest.ClientAppWhitelistAPI.exceptions.ClientNotFoundException;
import com.iaccess.progtest.ClientAppWhitelistAPI.models.Client;
import com.iaccess.progtest.ClientAppWhitelistAPI.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public List<Client> getAll() {
		return clientRepository.findAll();
	}

	public Client get(Long id) throws ClientNotFoundException {
		Optional<Client> requestedClient = clientRepository.findById(id);

		if (requestedClient.isEmpty()) {
			throw new ClientNotFoundException("Client not found!");
		} else {
			return requestedClient.get();
		}
	}

	public void save(Client client) {
		clientRepository.save(client);
	}

	public void delete(Long id) {
		clientRepository.deleteById(id);
	}

	public void update(Client client) {
		clientRepository.save(client);
	}
}
