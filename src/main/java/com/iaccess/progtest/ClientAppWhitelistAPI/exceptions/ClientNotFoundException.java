package com.iaccess.progtest.ClientAppWhitelistAPI.exceptions;

/**
 * 
 */

public class ClientNotFoundException extends Exception {

	public ClientNotFoundException(String errorMessage) {
		super(errorMessage);
	}

	public ClientNotFoundException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

}
