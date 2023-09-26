package com.iaccess.progtest.ClientAppWhitelistAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// import com.fasterxml.jackson.databind.JsonNode;
import com.iaccess.progtest.ClientAppWhitelistAPI.models.Whitelist;
import com.iaccess.progtest.ClientAppWhitelistAPI.requests.WhitelistRequest;
import com.iaccess.progtest.ClientAppWhitelistAPI.services.WhitelistService;

@RestController
public class WhitelistController {

	@Autowired
	private WhitelistService whitelistService;

	@PostMapping("/whitelist")
	public void addWhitelist(@RequestBody WhitelistRequest whitelistRequest) {
		System.out.println(whitelistRequest.toString());
		whitelistService.add(whitelistRequest);
	}

	// @PostMapping("/whitelist")
	// public void testJson(@RequestBody JsonNode request) {
	// System.out.println(request.toString());
	// }

	@DeleteMapping("/whitelist/{id}")
	public void removeWhitelist(@PathVariable long id) {
		whitelistService.remove(id);
	}

	@PutMapping("/whitelist")
	public void updateWhitelist(@RequestBody WhitelistRequest whitelistRequest) {
		// whitelistService.update(whitelistRequest);
	}

	@GetMapping("/whitelist/{id}")
	public void getWhitelist(@PathVariable long id) {
		whitelistService.get(id);
	}

	@GetMapping("/whitelist")
	public void getAllWhitelists() {
		whitelistService.getAll();
	}
}
