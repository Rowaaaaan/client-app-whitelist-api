package com.iaccess.progtest.ClientAppWhitelistAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaccess.progtest.ClientAppWhitelistAPI.models.Client;
import com.iaccess.progtest.ClientAppWhitelistAPI.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public List<Client> getAll() {
		return clientRepository.findAll();
	}

	public Client get(Long id) {
		return clientRepository.getReferenceById(id);
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
