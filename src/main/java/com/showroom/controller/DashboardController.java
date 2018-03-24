package com.showroom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
	
	@RequestMapping(value = "/")
	public String dashboard()
	{
		return "dashboard";
	}

}
