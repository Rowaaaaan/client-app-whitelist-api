package com.iaccess.progtest.ClientAppWhitelistAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaccess.progtest.ClientAppWhitelistAPI.ProductionEnvironment;
import com.iaccess.progtest.ClientAppWhitelistAPI.exceptions.AppNotFoundException;
import com.iaccess.progtest.ClientAppWhitelistAPI.exceptions.ClientNotFoundException;
import com.iaccess.progtest.ClientAppWhitelistAPI.exceptions.ResourceAlreadyExistsException;
import com.iaccess.progtest.ClientAppWhitelistAPI.exceptions.ResourceNotFoundException;
import com.iaccess.progtest.ClientAppWhitelistAPI.exceptions.WhitelistNotFoundException;
import com.iaccess.progtest.ClientAppWhitelistAPI.models.App;
import com.iaccess.progtest.ClientAppWhitelistAPI.models.Client;
import com.iaccess.progtest.ClientAppWhitelistAPI.models.ClientINetAddress;
import com.iaccess.progtest.ClientAppWhitelistAPI.models.Whitelist;
import com.iaccess.progtest.ClientAppWhitelistAPI.repositories.WhitelistRepository;
import com.iaccess.progtest.ClientAppWhitelistAPI.requests.WhitelistRequest;

/**
 * 
 */

@Service
public class WhitelistService {

	@Autowired
	private WhitelistRepository whitelistRepo;

	@Autowired
	private ClientService clientService;

	@Autowired
	private AppService appService;

	@Autowired
	private ClientINetAddressService clientINetAddressService;

	public void save(Whitelist whitelist) {
		whitelistRepo.save(whitelist);
	}

	public Whitelist save(WhitelistRequest whitelistRequest)
			throws ResourceNotFoundException, ResourceAlreadyExistsException {
		System.out.println(whitelistRequest.toString());

		Client client = clientService.get(whitelistRequest.getClientId());
		App app = appService.get(whitelistRequest.getAppId());
		ProductionEnvironment environment = whitelistRequest.getEnvironment();
		ClientINetAddress requestedInetAddress = whitelistRequest.getInetAddress();
		ClientINetAddress inetAddress = null;

		if (app == null) {
			throw new AppNotFoundException("App ID [" + whitelistRequest.getAppId() + "] does not exist!");
		}

		if (client == null) {
			throw new ClientNotFoundException("Client ID [" + whitelistRequest.getClientId() + "] does not exist!");
		}

		// Check if inetAddress already exists in the database, and use the request
		// inetAddress if it does not.
		// This prevents hibernate from saving an object that already exists.
		if (!clientINetAddressService.exists(requestedInetAddress.getIpv4())) {
			System.out.println("Inet address [" + requestedInetAddress + "] does not exist!");
			inetAddress = requestedInetAddress;
			System.out.println("Saving inet address: " + inetAddress.getIpv4());
			clientINetAddressService.save(inetAddress);
			inetAddress = clientINetAddressService.get(requestedInetAddress);
		} else {
			inetAddress = requestedInetAddress;
		}

		Whitelist whitelist = new Whitelist(client, app, environment, inetAddress);

		return whitelistRepo.save(whitelist);
	}

	public void delete(Long id) {
		whitelistRepo.deleteById(id);
	}

	public Whitelist update(WhitelistRequest whitelistRequest)
			throws ResourceNotFoundException, ResourceAlreadyExistsException {
		return this.save(whitelistRequest);
	}

	public Whitelist get(Long id) throws WhitelistNotFoundException {
		Optional<Whitelist> requestedWhitelist = whitelistRepo.findById(id);

		if (requestedWhitelist.isEmpty()) {
			throw new WhitelistNotFoundException("Whitelist id [" + id + "] not found!");
		} else {
			return requestedWhitelist.get();
		}
	}

	public List<Whitelist> getAll() {
		return whitelistRepo.findAll();
	}
}
