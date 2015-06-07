package com.domain.main;

import com.domain.message.Message;

public class Main {
	public static void main(String... args) {
		if (args.length > 0) {
			System.out.println(new Message(String.join(" ", args)).getMessage());
		} else {
			System.out.println(new Message(null).getMessage());
		}
	}
}
