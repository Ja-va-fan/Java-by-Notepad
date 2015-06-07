package com.domain.message;

public class Message {
	String message = "It is really working!";
	public Message(String message) {
		if (message != null) {
			this.message = message;
		}
	}
	public String getMessage() {
		return message;
	}
}
