package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.UserDtls;
import com.example.demo.repository.UserRepository;

@Controller
@RequestMapping("/User")
public class HomeController {
	
	@Autowired
	private UserRepository repo;
	
	@GetMapping("/home")
	public String home(Principal p,Model m)
	{
		String em=p.getName();
		UserDtls u=repo.findByEmail(em);
		
		m.addAttribute("fullName",u.getFullname());
		m.addAttribute("address", u.getAddress());
		m.addAttribute("em",u.getEmail());
		return "home";
	}

}
