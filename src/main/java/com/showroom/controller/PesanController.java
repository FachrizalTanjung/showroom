package com.showroom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PesanController {

	@RequestMapping(value = "/inputPesan")
	public String inputPesan() {
		return "inputPesan";
	}

	@RequestMapping(value = "/insertPesan", method = RequestMethod.POST)
	public String insertPesan() {
		
		System.out.println("test");
		
		return "redirect:inputPesan";
	}

}
