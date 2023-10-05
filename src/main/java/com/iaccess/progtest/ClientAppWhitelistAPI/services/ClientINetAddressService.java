package com.iaccess.progtest.ClientAppWhitelistAPI.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaccess.progtest.ClientAppWhitelistAPI.exceptions.ClientINetAddressAlreadyExistsException;
import com.iaccess.progtest.ClientAppWhitelistAPI.exceptions.ClientINetAddressNotFoundException;
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

	public ClientINetAddress get(ClientINetAddress inetAddress) throws ClientINetAddressNotFoundException {
		String ipv4 = inetAddress.getIpv4();
		Optional<ClientINetAddress> requestedInetAddress = clientInetAddressRepository.findById(ipv4);

		if (requestedInetAddress.isEmpty()) {
			throw new ClientINetAddressNotFoundException("Client IPv4 address [" + ipv4 + "] not found!");
		} else {
			return requestedInetAddress.get();
		}

	}

	public ClientINetAddress getByIpv4(String ipv4) throws ClientINetAddressNotFoundException {
		Optional<ClientINetAddress> requestedInetAddress = clientInetAddressRepository.findById(ipv4);

		if (requestedInetAddress.isEmpty()) {
			throw new ClientINetAddressNotFoundException("Client IPv4 address [" + ipv4 + "] not found!");
		} else {
			return requestedInetAddress.get();
		}
	}

	public void save(ClientINetAddress clientAddress) throws ClientINetAddressAlreadyExistsException {
		String ipv4 = clientAddress.getIpv4();
		if (!clientInetAddressRepository.existsByIpv4(ipv4)) {
			clientInetAddressRepository.save(clientAddress);
		} else {
			throw new ClientINetAddressAlreadyExistsException("Client Inet Address [" + ipv4 + "]  already exists!");
		}
	}

	public boolean exists(String ipv4) {
		return clientInetAddressRepository.existsByIpv4(ipv4);
	}

	public void deleteByIpv4(String ipv4Address) {
		clientInetAddressRepository.deleteByIpv4(ipv4Address);
	}

	public void delete(ClientINetAddress clientAddress) {
		clientInetAddressRepository.delete(clientAddress);
	}
}
