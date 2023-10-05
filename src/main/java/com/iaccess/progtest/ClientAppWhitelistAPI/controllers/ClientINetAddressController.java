package com.iaccess.progtest.ClientAppWhitelistAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iaccess.progtest.ClientAppWhitelistAPI.exceptions.ClientINetAddressAlreadyExistsException;
import com.iaccess.progtest.ClientAppWhitelistAPI.exceptions.ClientINetAddressNotFoundException;
import com.iaccess.progtest.ClientAppWhitelistAPI.models.ClientINetAddress;
import com.iaccess.progtest.ClientAppWhitelistAPI.services.ClientINetAddressService;

@RestController
@RequestMapping("/whitelists/ips")
public class ClientINetAddressController {

	@Autowired
	private ClientINetAddressService clientInetService;

	@GetMapping
	public List<String> getAllAddresses() {
		return clientInetService.getAll();
	}

	@GetMapping("/{ip}")
	public ClientINetAddress getClientsFromIp(@PathVariable String ip) throws ClientINetAddressNotFoundException {
		return clientInetService.getByIpv4(ip);
	}

	@PostMapping
	public void saveClientIp(@RequestBody ClientINetAddress clientAddress)
			throws ClientINetAddressAlreadyExistsException {
		clientInetService.save(clientAddress);
	}

	@DeleteMapping("/{ip}")
	public void deleteIp(@PathVariable String ip) {
		clientInetService.deleteByIpv4(ip);
	}

	@DeleteMapping
	public void deleteClientFromIp(@RequestBody ClientINetAddress clientAddress) {
		clientInetService.delete(clientAddress);
	}
}
