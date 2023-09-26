package com.iaccess.progtest.ClientAppWhitelistAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaccess.progtest.ClientAppWhitelistAPI.models.App;

@Repository
public interface AppRepository extends JpaRepository<App, Long> {
}
