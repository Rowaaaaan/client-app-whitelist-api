package com.iaccess.progtest.ClientAppWhitelistAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iaccess.progtest.ClientAppWhitelistAPI.models.ClientINetAddress;
import com.iaccess.progtest.ClientAppWhitelistAPI.services.ClientINetAddressService;

@RestController
public class ClientINetAddressController {

	@Autowired
	private ClientINetAddressService clientInetService;

	@GetMapping("/whitelisted-ips")
	public List<String> getAllAddresses() {
		return clientInetService.getAll();
	}

	@GetMapping("/whitelisted-ips/{ip}")
	public ClientINetAddress getClientsFromIp(@PathVariable String ip) {
		return clientInetService.get(ip);
	}

	@PostMapping("/whitelisted-ips")
	public void saveClientIp(@RequestBody ClientINetAddress clientAddress) {
		clientInetService.save(clientAddress);
	}

	@DeleteMapping("/whitelisted-ips/{ip}")
	public void deleteIp(@PathVariable String ip) {
		clientInetService.delete(ip);
	}

	@DeleteMapping("/whitelisted-ips")
	public void deleteClientFromIp(@RequestBody ClientINetAddress clientAddress) {
		clientInetService.delete(clientAddress);
	}
}
