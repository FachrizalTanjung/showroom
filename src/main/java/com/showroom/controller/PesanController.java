package com.showroom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.showroom.dto.BookingDTO;
import com.showroom.endpoint.Endpoint;

@Controller
public class PesanController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/inputPesan")
	public String inputPesan(Model model) {

		model.addAttribute("bookingDTO", new BookingDTO());

		return "inputPesan";
	}

	@RequestMapping(value = "/insertPesan", method = RequestMethod.POST)
	public String submit(@ModelAttribute BookingDTO bookingDTO) {

		restTemplate.postForObject(Endpoint.INSERT_PESAN, bookingDTO, String.class);

		return "redirect:inputPesan";
	}

}
