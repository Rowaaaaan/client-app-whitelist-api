package com.iaccess.progtest.ClientAppWhitelistAPI.exceptions;

/**
 * 
 */

public class AppNotFoundException extends Exception {

	public AppNotFoundException(String errorMessage) {
		super(errorMessage);
	}

	public AppNotFoundException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
}
