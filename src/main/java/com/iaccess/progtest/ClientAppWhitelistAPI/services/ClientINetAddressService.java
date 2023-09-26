package com.iaccess.progtest.ClientAppWhitelistAPI.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaccess.progtest.ClientAppWhitelistAPI.models.ClientINetAddress;
import com.iaccess.progtest.ClientAppWhitelistAPI.repositories.ClientINetAddressRepository;

@Service
public class ClientINetAddressService {

	@Autowired
	private ClientINetAddressRepository clientInetAddressRepository;

	public List<String> getAll() {
		List<String> ipv4Addresses = clientInetAddressRepository
				.findAll()
				.stream()
				.map(clientInet -> clientInet.getIpv4())
				.collect(Collectors.toList());

		return ipv4Addresses;
	}

	public ClientINetAddress get(String ip) {
		return null;
	}

	public void save(ClientINetAddress clientAddress) {
		clientInetAddressRepository.save(clientAddress);
	}

	public void delete(String ip) {
		clientInetAddressRepository.deleteById(ip);
	}

	public void delete(ClientINetAddress clientAddress) {
		clientInetAddressRepository.delete(clientAddress);
	}

	// public Set<Client> getClientsByIp(String ip) {
	// }
}
