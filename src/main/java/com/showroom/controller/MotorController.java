package com.showroom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MotorController {
	
	
	@RequestMapping(value = "/inputMotor")
	public String input()
	{
		return "inputMotor";
	}

}
