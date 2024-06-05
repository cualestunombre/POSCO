package com.poscodx.mysite.repository;

public class BoardRepositoryException extends RuntimeException {
	public BoardRepositoryException(Exception e, String message) {
		super(message,e );
	}
}
