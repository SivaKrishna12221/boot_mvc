package com.nt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_GATEWAY) // 502 error
public class NoSuchElementException extends RuntimeException {

	public NoSuchElementException() {
		super();
	}

	public NoSuchElementException(String message) {
		super(message);
	}
}
