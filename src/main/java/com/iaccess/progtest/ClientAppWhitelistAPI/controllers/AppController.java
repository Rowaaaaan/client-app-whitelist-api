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

import com.iaccess.progtest.ClientAppWhitelistAPI.models.App;
import com.iaccess.progtest.ClientAppWhitelistAPI.services.AppService;

@RestController
@RequestMapping("/apps")
public class AppController {

	@Autowired
	private AppService appService;

	@GetMapping
	public List<App> getAllApps() {
		return appService.getAll();
	}

	@GetMapping("/{id}")
	public App getApp(@PathVariable Long id) throws Exception {
		return appService.get(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createApp(@RequestBody App app) {
		appService.save(app);
	}

	@PutMapping("/{id}")
	public void updateApp(@RequestBody App app) {
		appService.save(app);
	}

	@DeleteMapping("/{id}")
	public void deleteApp(@PathVariable long id) {
		appService.delete(id);
	}
}
