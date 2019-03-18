package com.hipertecnologia.lavemobile.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.hipertecnologia.lavemobile.security.UserSS;

public class UserService {
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			}
		catch (Exception e) {
			return null;
		}
	}
}
