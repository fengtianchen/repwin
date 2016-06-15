package com.swu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageJumpController {
	
	@RequestMapping("/login")
	public String toLoginPage(){
		return "login";
	}
	
	@RequestMapping("/publish")
	public String toPublishPage(){
		return "publish";
	}
}
