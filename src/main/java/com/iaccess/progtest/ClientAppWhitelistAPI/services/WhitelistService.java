package com.iaccess.progtest.ClientAppWhitelistAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public void add(Whitelist whitelist) {
		whitelistRepo.save(whitelist);
	}

	public void add(WhitelistRequest whitelistRequest) {
		Whitelist whitelist = new Whitelist(whitelistRequest.getClient(),
				whitelistRequest.getApp(), whitelistRequest.getEnvironment(),
				whitelistRequest.getInetAddress());

		System.out.println(whitelist.toString());

		whitelistRepo.save(whitelist);
	}

	public void remove(Long id) {
		whitelistRepo.deleteById(id);
	}

	public void update(Whitelist whitelist) {
		whitelistRepo.save(whitelist);
	}

	public Whitelist get(Long id) {
		return whitelistRepo.getReferenceById(id);
	}

	public List<Whitelist> getAll() {
		return whitelistRepo.findAll();
	}
}
