package com.iaccess.progtest.ClientAppWhitelistAPI.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "client_inet_address")
public class ClientINetAddress {

	@Id
	@Column(length = 15, name = "ipv4_address")
	String ipv4;
}
