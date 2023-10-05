package com.iaccess.progtest.ClientAppWhitelistAPI.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaccess.progtest.ClientAppWhitelistAPI.exceptions.AppNotFoundException;
import com.iaccess.progtest.ClientAppWhitelistAPI.models.App;
import com.iaccess.progtest.ClientAppWhitelistAPI.repositories.AppRepository;

/**
 * 
 */
@Service
public class AppService {

	@Autowired
	private AppRepository appRepository;

	public void delete(Long id) {
		appRepository.deleteById(id);
	}

	public void save(App app) {
		appRepository.save(app);
	}

	public App get(Long id) throws AppNotFoundException {
		Optional<App> requestedApp = appRepository.findById(id);

		if (requestedApp.isEmpty()) {
			throw new AppNotFoundException("App not found!");
		} else {
			return requestedApp.get();
		}
	}

	public List<App> getAll() {
		return appRepository.findAll();
	}

}
