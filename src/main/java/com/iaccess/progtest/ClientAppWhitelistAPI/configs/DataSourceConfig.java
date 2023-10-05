package com.iaccess.progtest.ClientAppWhitelistAPI.configs;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration
public class DataSourceConfig {

	// @Bean
	public DataSource getDataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("org.h2.Driver");
		dataSourceBuilder
				.url("jdbc:h2:file:./target/db/client-app-whitelist;INIT=runscript from 'classpath:import.sql'");
		dataSourceBuilder.username("user");
		dataSourceBuilder.password("");
		// dataSourceBuilder.url("jdbc:h2:mem:test");

		return dataSourceBuilder.build();
	}
}
