package com.iaccess.progtest.ClientAppWhitelistAPI.exceptions;

public class AppAlreadyExistsException extends ResourceAlreadyExistsException {
	public AppAlreadyExistsException(String message) {
		super(message);
	}
}
