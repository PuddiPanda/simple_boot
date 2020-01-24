package com.formation.ctrl;

public class MessageBuilder {
	
	
	StringBuilder result = new StringBuilder();
	
	public String getMessage(String name) {
		if (name ==null || name.trim().length() ==0) {
			result.append("Please provide a name");
		} else {
			result.append("Hello " + name);
		}
		
		return result.toString();
	}
}
