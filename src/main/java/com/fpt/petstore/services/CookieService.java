package com.fpt.petstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class CookieService {
	@Autowired
    HttpServletRequest request;
	@Autowired
    HttpServletResponse response;
	

	public Cookie create(String name, String value, int days) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(days*24*60*60);
		cookie.setPath("/");
		response.addCookie(cookie);
		return cookie;
	}

	public void delete(String name) {
		this.create(name, "", 0);
	}

	public String getValue(String name, String defaultValue) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equalsIgnoreCase(name)) {
					return cookie.getValue();
				}
			}
		}
		return defaultValue;
	}

}