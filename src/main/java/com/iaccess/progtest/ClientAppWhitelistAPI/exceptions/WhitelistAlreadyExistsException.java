package com.iaccess.progtest.ClientAppWhitelistAPI.exceptions;

public class WhitelistAlreadyExistsException extends ResourceAlreadyExistsException {
	public WhitelistAlreadyExistsException(String message) {
		super(message);
	}
}
