package com.iaccess.progtest.ClientAppWhitelistAPI.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public Optional<App> get(Long id) {
		return appRepository.findById(id);
	}

	public List<App> getAll() {
		List<App> appsList = new ArrayList<>();
		appRepository.findAll().forEach(appsList::add);
		return appsList;
	}

}
