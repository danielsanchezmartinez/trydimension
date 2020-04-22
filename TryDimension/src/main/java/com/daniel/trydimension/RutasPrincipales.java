package com.daniel.trydimension;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RutasPrincipales {
	
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}	

}
