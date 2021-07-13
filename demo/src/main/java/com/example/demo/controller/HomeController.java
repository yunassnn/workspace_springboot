package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	// 요청 url : http://localhost:8070/home
	@RequestMapping("/home")
	@ResponseBody
	public String home() {
		return "hello spring boot";
	}
}
