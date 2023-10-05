package com.iaccess.progtest.ClientAppWhitelistAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaccess.progtest.ClientAppWhitelistAPI.models.ClientINetAddress;

@Repository
public interface ClientINetAddressRepository extends JpaRepository<ClientINetAddress, String> {

	void deleteByIpv4(String ipv4Address);

	boolean existsByIpv4(String ipv4);
}
