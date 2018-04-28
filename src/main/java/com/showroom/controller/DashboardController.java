package com.showroom.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.showroom.dto.MotorDTO;
import com.showroom.endpoint.Endpoint;
import com.showroom.pagination.PageableRequest;
import com.showroom.pagination.PageableResponse;

@Controller
public class DashboardController {

	@Autowired
	private RestTemplate restTemplate;

	@ModelAttribute("command")
	public PageableRequest initCommand() {
		return new PageableRequest();
	}

	@RequestMapping(value = "/")
	public String dashboard(@ModelAttribute("command") PageableRequest command, ModelMap model)
			throws JsonParseException, JsonMappingException, IOException {

		String result = restTemplate.getForObject(Endpoint.GET_MOTOR, String.class);
		System.out.println("result : " + result);
		ObjectMapper mapper = new ObjectMapper();
		PageableResponse<MotorDTO> content = mapper.readValue(result, new TypeReference<PageableResponse<MotorDTO>>() {
		});

		content.setRequest(command);

		model.put("page", content);

		return "dashboard";
	}

}
