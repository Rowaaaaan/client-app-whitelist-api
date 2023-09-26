package com.iaccess.progtest.ClientAppWhitelistAPI.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "APP")
public class App {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long appId;

	@Column(nullable = false)
	String appName;
}
