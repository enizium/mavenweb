package com.itn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class AdminController {
	@GetMapping("/Admin/Dashboard")
	public String adminHome() {
		return "dashboard";
	}

	@GetMapping("/login")
	public String userLogin() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String userLogout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null)
		{
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/index?logout";
	}
}