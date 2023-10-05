package com.iaccess.progtest.ClientAppWhitelistAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iaccess.progtest.ClientAppWhitelistAPI.exceptions.ResourceAlreadyExistsException;
import com.iaccess.progtest.ClientAppWhitelistAPI.exceptions.ResourceNotFoundException;
import com.iaccess.progtest.ClientAppWhitelistAPI.exceptions.WhitelistNotFoundException;
import com.iaccess.progtest.ClientAppWhitelistAPI.requests.WhitelistRequest;
import com.iaccess.progtest.ClientAppWhitelistAPI.services.WhitelistService;

@RestController
@RequestMapping("/whitelists")
public class WhitelistController {

	@Autowired
	private WhitelistService whitelistService;

	@PostMapping
	public void addWhitelist(@RequestBody WhitelistRequest whitelistRequest)
			throws ResourceNotFoundException, ResourceAlreadyExistsException {
		System.out.println(whitelistRequest.toString());
		whitelistService.save(whitelistRequest);
	}

	@DeleteMapping("/{id}")
	public void removeWhitelist(@PathVariable Long id) {
		whitelistService.delete(id);
	}

	@PutMapping
	public void updateWhitelist(@RequestBody WhitelistRequest whitelistRequest)
			throws ResourceNotFoundException, ResourceAlreadyExistsException {
		whitelistService.update(whitelistRequest);
	}

	@GetMapping("/{id}")
	public void getWhitelist(@PathVariable Long id) throws WhitelistNotFoundException {
		whitelistService.get(id);
	}

	@GetMapping
	public void getAllWhitelists() {
		whitelistService.getAll();
	}
}
