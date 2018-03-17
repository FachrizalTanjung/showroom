package id.co.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
	
	@RequestMapping(value = "/index")
	public String index()
	{
		return "index";
	}
	
	@RequestMapping(value = "/input")
	public String input()
	{
		return "input";
	}
	
	@RequestMapping(value = "/update")
	public String update()
	{
		return "update";
	}
	
	@RequestMapping(value = "/welcome")
	public String welcome()
	{
		return "welcome";
	}

}