package com.iaccess.progtest.ClientAppWhitelistAPI.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iaccess.progtest.ClientAppWhitelistAPI.ProductionEnvironment;
import com.iaccess.progtest.ClientAppWhitelistAPI.models.App;
import com.iaccess.progtest.ClientAppWhitelistAPI.models.Client;
import com.iaccess.progtest.ClientAppWhitelistAPI.models.ClientINetAddress;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class WhitelistRequest {
	// @JsonProperty("test")
	// String test;
	@JsonProperty("client")
	Client client;

	@JsonProperty("app")
	App app;

	@JsonProperty("environment")
	ProductionEnvironment environment;

	@JsonProperty("inetAddress")
	ClientINetAddress inetAddress;
}
