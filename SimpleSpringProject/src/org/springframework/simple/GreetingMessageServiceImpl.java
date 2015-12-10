package org.springframework.simple;

//@Service
public class GreetingMessageServiceImpl implements GreetingMessageService {

	@Override
	public String greetUser() {
		return "WELCOME TO SPRING FRAMEWORK APPLICATION";
	}

}
