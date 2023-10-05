package com.iaccess.progtest.ClientAppWhitelistAPI.controllers;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.iaccess.progtest.ClientAppWhitelistAPI.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalAdviceController {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ErrorResponse handleResourceNotFoundException(final ResourceNotFoundException rnfe) {
		return ErrorResponse.create(rnfe, HttpStatus.NOT_FOUND, rnfe.getMessage());
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ErrorResponse handleEntityNotFound(final EntityNotFoundException enfe) {
		return ErrorResponse.create(enfe, HttpStatus.NOT_FOUND, enfe.getMessage());
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ErrorResponse handleInvalidRequest(final DataIntegrityViolationException dive) {
		return ErrorResponse.create(dive, HttpStatus.BAD_REQUEST, dive.getMessage());
	}
}
