package com.program.exception;

/**
 * 
 * Represent exception class for invalid input format
 *
 */
@SuppressWarnings("serial")
public class InvalidInputFormat extends RuntimeException {

	public InvalidInputFormat(String message) {
		super(message);
	}

	public InvalidInputFormat(String message, Throwable th) {
		super(message, th);
	}
}