package com.iaccess.progtest.ClientAppWhitelistAPI.models;

import com.iaccess.progtest.ClientAppWhitelistAPI.ProductionEnvironment;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "WHITELIST")
public class Whitelist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "client_id", nullable = false)
	Client client;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "app_id", nullable = false)
	App app;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	ProductionEnvironment environment;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(nullable = false, name = "ipv4_address")
	ClientINetAddress inetAddress;

	public Whitelist(Client client, App app,
			ProductionEnvironment environment, ClientINetAddress inetAddress) {
		this.client = client;
		this.app = app;
		this.environment = environment;
		this.inetAddress = inetAddress;
	}
}
